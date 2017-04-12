package com.bankofshanghai.spark;

import scala.Tuple2;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public final class WordCount {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("WC").setMaster("local[2]");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> textFile = sc.textFile("D://CODE//11.txt").cache();
//		JavaRDD<String> words = textFile.flatMap(new FlatMapFunction<String, String>() {
//			public Iterator<String> call(String s) {
//				return Arrays.asList(s.split(" ")).iterator();
//			}
//		});
		JavaRDD<String> words = textFile.flatMap(s->Arrays.asList(s.split(" ")).iterator());
//		JavaPairRDD<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
//			public Tuple2<String, Integer> call(String s) {
//				return new Tuple2<String, Integer>(s, 1);
//			}
//		});
		JavaPairRDD<String, Integer> pairs = words.mapToPair(s->new Tuple2(s, 1));
//		JavaPairRDD<String, Integer> counts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
//			public Integer call(Integer a, Integer b) {
//				return a + b;
//			}
//		});
		JavaPairRDD<String, Integer> counts = pairs.reduceByKey((a,b)->a+b);
		System.out.println(counts.collect().toString());
		sc.stop();
	}
}