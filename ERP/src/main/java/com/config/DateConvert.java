package com.config;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateConvert {
public static String toDay(){ SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");return df.format(new Date());} 
public static Date date(String sDate){SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); try{ return df.parse(sDate); }catch(Exception e){} return null;}
public static Date toDate(String sDate){SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); try{ return df.parse(sDate); }catch(Exception e){} return null;}
}