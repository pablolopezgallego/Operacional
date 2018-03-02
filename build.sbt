name := "spark"

version := "1.0"

scalaVersion := "2.10.5"

resolvers ++= Seq("pentaho-repo" at "https://public.nexus.pentaho.org/content/groups/omni/",
  "sparkLib" at "https://dl.bintray.com/spark-packages/maven/",
  "ClouderaRepo" at "https://repository.cloudera.com/content/repositories/releases",
  "Spring" at "http://repo.spring.io/plugins-release/")

val hbaseVersion  = "1.1.2.2.5.0.0-1245"

libraryDependencies ++= Seq(
  //"org.apache.spark" % "spark-core_2.10" % "1.6.2" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  //"org.apache.spark" % "spark-sql_2.10" % "1.6.2" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  //"org.apache.hadoop" % "hadoop-common" % "2.7.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  //"org.apache.spark" % "spark-sql_2.10" % "1.6.2" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  "org.apache.spark" % "spark-hive_2.10" % "1.6.2" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  "org.apache.spark" % "spark-yarn_2.10" % "1.6.2" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  //"org.apache.spark" % "spark-streaming_2.10" % "1.6.2" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  //"org.apache.spark" % "spark-streaming-kafka_2.10" % "1.6.2" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),

  //"com.databricks" % "spark-csv_2.10" % "0.1" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy")


).map(_.excludeAll(ExclusionRule(organization = "org.mortbay.jetty"),ExclusionRule(organization = "javax.servlet"))

)