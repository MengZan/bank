package com.bankofshanghai.spark;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;

import com.bankofshanghai.drools.CheckDrools;
import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.service.StatisticsService;
import com.bankofshanghai.service.impl.StatisticsServiceImpl;

public class CheckSpark {
	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "D://CODE");

		SparkSession spark = SparkSession.builder().appName("bank").master("local[3]").getOrCreate();

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		StatisticsService ss = new StatisticsServiceImpl();

		long startTime = System.currentTimeMillis();
		JavaRDD<String> lines = spark.read().textFile("C://Users//27538//Desktop//11.txt").javaRDD();
		JavaRDD<BankData> dataRDD = lines.map(line -> {
			String[] s = line.split("\\s+");
			BankData data = new BankData();
			data.setId(Long.parseLong(s[0]));
			data.setFromuser(Long.parseLong(s[1]));
			data.setTouser(Long.parseLong(s[2]));
			data.setMoney(new BigDecimal(Double.parseDouble(s[3])));
			data.setFromplace(s[4]);
			data.setToplace(s[5]);
			data.setDatetime(sdf1.parse(s[6] + " " + s[7]));
			data.setTouserCredit(Integer.parseInt(s[8]));
			data.setTool("手机");
			data.setFromuserOpendate(sdf2.parse(s[9]));
			data.setSafeLevel(0);
			data.setIsFraud("1".equals(s[10]) ? true : false);
			return data;
		});

		JavaRDD<BankData> fraudDataRDD = dataRDD.filter(data -> {
			StatisticsData sData = ss.getStatisticData(data);
			CheckDrools drools = new CheckDrools();
			drools.check(data, sData);
			return data.getSafeLevel() > 60;
		});

		fraudDataRDD.saveAsTextFile("C://Users//27538//Desktop//r.txt");

		// Dataset<Row> fraudDataDF = spark.createDataFrame(fraudDataRDD,
		// BankData.class);
		// fraudDataDF.show();

		spark.stop();

		long time = (System.currentTimeMillis() - startTime) / 1000;
		System.out.println("运行时间：" + time);
	}
}
