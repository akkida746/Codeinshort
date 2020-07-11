package com.codeinshort.spark;

import java.util.Arrays;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;

public class SparkWordCount {
    public static void main(String[] args) {

        SparkConf config = new SparkConf().setAppName("JavaWordCount");

        JavaSparkContext sc = new JavaSparkContext(config);

        JavaRDD<String> lines = sc.textFile(args[0]);

        JavaRDD<String> words = lines.flatMap( line -> Arrays.asList(line.split(" ")).iterator());

        JavaPairRDD<String, Integer> pairs = words.mapToPair( word -> new scala.Tuple2<String, Integer>(word, 1));

        JavaPairRDD<String, Integer> counts = pairs.reduceByKey((a, b) -> a + b );

        counts.saveAsTextFile(args[1]);

        sc.close();

    }
}
