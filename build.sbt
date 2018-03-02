name := "spark"

version := "1.0"

scalaVersion := "2.10.5"

resolvers ++= Seq("pentaho-repo" at "https://public.nexus.pentaho.org/content/groups/omni/",
  "hbase-spark" at "https://mvnrepository.com/artifact/org.apache.hbase/hbase-spark/",
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
  "org.apache.hbase"  %  "hbase-common"    % hbaseVersion exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  "org.apache.hbase"  %  "hbase-server"    % hbaseVersion exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  "org.apache.hbase"  %  "hbase-protocol"  % hbaseVersion exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  "org.apache.hbase"  %  "hbase-client"    % hbaseVersion exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  "org.apache.hbase" % "hbase-spark" % "1.2.0-cdh5.8.4" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  "org.apache.hbase" % "hbase" % hbaseVersion exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy")
  //"com.databricks" % "spark-csv_2.10" % "0.1" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy")


).map(_.excludeAll(ExclusionRule(organization = "org.mortbay.jetty"),ExclusionRule(organization = "javax.servlet"))

)