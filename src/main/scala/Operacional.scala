import org.apache.spark.{SparkConf, SparkContext}
import org.apache.hadoop.hbase.{CellUtil, HBaseConfiguration, TableName}
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.client.ConnectionFactory


object Operacional {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("HBaseStream")
    if (sys.env("ENTORNO") == "DESARROLLO") {
      conf.setMaster("local[*]")
    }
    val sc = new SparkContext(conf)

    val rutaDatos = args(0) //URL a identificador de taxonomía
    val tabla = args(1)

    val datos = sc.textFile(rutaDatos).map(x => x.split(";"))

    val cabeceras = datos.first()
    cabeceras.foreach(println)
    val datosSC = datos.mapPartitionsWithIndex { (idx, iter) => if (idx == 0) iter.drop(1) else iter }

    datosSC.foreachPartition(y => {
      val confi = HBaseConfiguration.create()
      confi.set(TableInputFormat.INPUT_TABLE, "operacional" + tabla)
      val connection = ConnectionFactory.createConnection(confi)
      val table = connection.getTable(TableName.valueOf(Bytes.toBytes("operacional" + tabla)))
      while (y.hasNext) {
        val x = y.next()
        val put = new Put(Bytes.toBytes(x(0)))
        //if (cabeceras.length == x.length)
        for (i <- 1 until x.length)
          if (x(i) != "")  //Esta condición es para no meter los datos con valor vacío, es más eficiente, ahorra 1/7 de tiempo aproximadamente (De 3.6 a 3.1)
            put.addColumn(Bytes.toBytes("adn"), Bytes.toBytes(cabeceras(i)), Bytes.toBytes(x(i)))
        put.addColumn(Bytes.toBytes("adn"), Bytes.toBytes("recomendacion"), Bytes.toBytes("90"))
        table.put(put)
        table.close()
      }
    })
  }
}
