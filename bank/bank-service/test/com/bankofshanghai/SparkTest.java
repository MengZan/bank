package com.bankofshanghai;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public final class SparkTest {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("test").setMaster("local[2]");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1, 23, 456));
		
		/**
		 * 翻倍
		 */
//		JavaRDD<Integer> rdd2 = rdd.map(new Function<Integer, Integer>() {
//			public Integer call(Integer v1) {
//				return v1 * 2;
//			}
//		});
		JavaRDD<Integer> rdd2 = rdd.map(s -> s*2);
		
		/**
		 * 过滤
		 */
//		JavaRDD<Integer> rdd3 = rdd.filter(new Function<Integer, Boolean>() {
//			public Boolean call(Integer v1) throws Exception {
//				return v1>10;
//			}
//		});
		JavaRDD<Integer> rdd3 = rdd.filter(s -> s>10);
				
		/**
		 * 展开
		 */
		JavaRDD<String> rdd4 = sc.parallelize(Arrays.asList("a b c","d e","ff"));
//		JavaRDD<String> rdd5 = rdd4.flatMap(new FlatMapFunction<String, String>() {
//			public Iterator<String> call(String t) throws Exception {
//				return Arrays.asList(t.split(" ")).iterator();
//			}
//		});
		JavaRDD<String> rdd5 = rdd4.flatMap(s->Arrays.asList(s.split(" ")).iterator());
		
		/**
		 * 并集、交集
		 */
		JavaRDD<Integer> rdd6 = sc.parallelize(Arrays.asList(1, 234, 5678));
		JavaRDD<Integer> rdd7 = rdd6.union(rdd);
		JavaRDD<Integer> rdd8 = rdd7.distinct();  //去重
		JavaRDD<Integer> rdd9 = rdd6.intersection(rdd);
		
		/**
		 * reduce
		 */
		int rdd10 = rdd.reduce((a,b)->a+b);
		
		System.out.println(rdd8.collect().toString());
		sc.stop();
	}
}