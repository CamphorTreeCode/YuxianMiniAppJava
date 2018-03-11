package com.woman.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Title: DateTime.java
 * @Prject: XCXJK
 * @Package: com.dk.util.gettime
 * @Description: TODO
 * @author: lichenglong
 * @date: 2017年2月22日 下午5:39:27
 * @version: V1.0  
 */
public class DateTime {
	//适合图片的地址
	 public String getDate(){
		 SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		  Date date= new  Date();
		  return dateFormater.format(date);
	 }
	 public String getDateImg(){
		 SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-ddHH-mm-ss");
		  Date date=new  Date();
		  return dateFormater.format(date);
	 }
	 public String getDay(){
		 SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		  Date date=new  Date();
		  return dateFormater.format(date);
	 }
}
