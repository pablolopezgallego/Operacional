#!/bin/bash -x

if [[ $# -eq 0 ]] ; then
    echo 'necesitas especificar el nombre de cliente'
    exit 1
fi

(cd /root/cliente$1/spark/; sbt package)
spark-submit --class OperacionalHBase --master yarn-cluster --packages it.nerdammer.bigdata:spark-hbase-connector_2.10:1.0.3,org.apache.spark:spark-streaming-kafka_2.10:1.6.2 --conf spark.yarn.appMasterEnv.ENTORNO=PRODUCCION --executor-memory 2G --driver-memory 4G --num-executors 4 --executor-cores 1 --driver-cores 4 /root/cliente$1/spark/target/scala-2.10/spark_2.10-1.0.jar operacional$1 /$1/resultados/adn/
