package com.journaldev.sparkdemo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
import scala.inline;

import java.util.Arrays;

import javax.annotation.meta.When;

public class WordCounter {

    private static void wordCount(String master, String inputFile, String output) {

        /*When running in local*/
        SparkConf conf = new SparkConf().setMaster(master).setAppName("WorkCount");

        // Create a Java version of the Spark Context from the configuration
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Load the input data, which is a text file read from the command line
        JavaRDD<String> input = sc.textFile(inputFile);

        // Java 8 with lambdas: split the input string into words
        JavaRDD<String> words = input.flatMap(s -> Arrays.asList(s.split(" ")));

        // Java 8 with lambdas: transform the collection of words into pairs (word and 1) and then count them
        JavaPairRDD<String, Integer> counts = words.mapToPair(t -> new Tuple2(t, 1)).reduceByKey((x, y) -> (int) x + (int) y);

        // Save the word count back out to a text file, causing evaluation.
        counts.saveAsTextFile(output);

    }

    public static void main(String[] args) {

        /* When running in local */
        //wordCount("local", "C:\\Users\\deepa\\Desktop\\input.txt","output");


        if (args.length == 0) {
            System.out.println("No files provided.");
            System.exit(0);
        }

        wordCount(args[0], args[1], args[2]);


    }
}
