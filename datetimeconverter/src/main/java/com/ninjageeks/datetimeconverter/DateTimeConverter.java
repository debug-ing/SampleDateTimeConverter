package com.ninjageeks.datetimeconverter;


import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DateTimeConverter {
    public static ConverterFromMiladi con;
    public static String data;
    private static Object Converter;

    public static TimeZone GetTimeZonePhone(){
        TimeZone tz = TimeZone.getDefault();
        return tz;
    }
    /**
     * Get DateTime Now Other TimeZone
     *
     * @param toZone  TimeZone
     * @param DateTime  String
     * @param toZone TimeZone
     * @param format  Int (Type)
     * @param FarsiNumber  Boolean (Enable Return Persian Number
     * @return Day as int
     */
    public static  ConverterFromMiladi ConvertDateTimeFromTimeZoneToZone(TimeZone Zone, String DateTime,TimeZone toZone,int format, Boolean FarsiNumber){
        DateTime = DateTime.replace("T"," ");
        DateTime = DateTime.replace(".000Z","");
        String dateStr =DateTime;
        SimpleDateFormat df = null;
        if (format == 1){
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        }else if (format == 2) {
            df = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss", Locale.ENGLISH);
        }
        df.setTimeZone(Zone);
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        df.setTimeZone(toZone);
        String formattedDate = df.format(date);
        if (FarsiNumber == true){

            data = NumberConverter.EnToPer(formattedDate);
        }else{
            data = formattedDate;
        }
        con = new ConverterFromMiladi();
        return con;
    }

    public static String GetDateTimeNow(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }
    /**
     * Get DateTime Now Other TimeZone
     *
     * @param toZone  TimeZone
     * @param format  Int (Type)
     * @param FarsiNumber  Boolean (Enable Return Persian Number
     * @return Day as int
     */
    @Nullable
    public static ConverterFromMiladi GetDateTimeNowOtherTimeZone(TimeZone toZone, int format, Boolean FarsiNumber){
        TimeZone Zone = GetTimeZonePhone();
        String DateTime = GetDateTimeNow();
        DateTime = DateTime.replace("T"," ");
        DateTime = DateTime.replace(".000Z","");
        String dateStr =DateTime;
        SimpleDateFormat df = null;
        if (format == 1){
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        }else if (format == 2) {
            df = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss", Locale.ENGLISH);
        }
        df.setTimeZone(Zone);
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        df.setTimeZone(toZone);
        String formattedDate = df.format(date);
        //
        if (FarsiNumber == true){

            data = NumberConverter.EnToPer(formattedDate);
        }else{
            data = formattedDate;
        }
        con = new ConverterFromMiladi();
        return con;
    }

    /**
     * Get DateTime Now Other TimeZone
     *
     * @param toZone  TimeZone
     * @param format  Int (Type)
     * @param custom  String
     * @param FarsiNumber  Boolean (Enable Return Persian Number)
     * @return Day as int
     */
    public static ConverterFromMiladi GetDateTimeNowOtherTimeZoneCustom(TimeZone toZone,int format,String custom,Boolean FarsiNumber){
        TimeZone Zone = GetTimeZonePhone();
        String DateTime = GetDateTimeNow();
        DateTime = DateTime.replace("T"," ");
        DateTime = DateTime.replace(".000Z","");
        String dateStr =DateTime;
        SimpleDateFormat df = null;
        if (format == 1){
             df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        }else if (format == 2){
            df = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss", Locale.ENGLISH);
        }else if (format == 3){
            df = new SimpleDateFormat("yyyy" + custom + "MM" + custom +"dd HH:mm:ss", Locale.ENGLISH);
        }else if (format == 4){
            df = new SimpleDateFormat("yyyy" + custom + "MMMM" + custom +"dd HH:mm:ss", Locale.ENGLISH);
        }
        df.setTimeZone(Zone);
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        df.setTimeZone(toZone);
        String formattedDate = df.format(date);
        //
        if (FarsiNumber == true){

            data = NumberConverter.EnToPer(formattedDate);
        }else{
            data = formattedDate;
        }
        con = new ConverterFromMiladi();
        return con;
    }
    /**
     * Conver tMilad iTo Shamsi
     *
     * @param datetime  String  Example 2020-01-25 15:45:21 Or 2020-01-25
     * @return DateTime Shamsi as String
     */
    @NotNull
    public static String ConvertMiladiToShamsi(String datetime,Boolean Name){

        String[] id = datetime.split(" ");
        String Date = id[0];
        String[] date = Date.split("-");
        //
        DateConverter converter = new DateConverter();
        Log.e("mm",date[0]);
        Log.e("mm",date[1]);
        Log.e("mm",date[2]);
        converter.gregorianToPersian(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
        if (Name == false){
            return converter.getYear() + "/" + converter.getMonth() + "/" + converter.getDay();
        }else{
            return converter.getYear() + " " + converter.GetNameMount(converter.getMonth()) + " " + converter.getDay();
        }
    }

    /**
     * Get TimeZone With Send Location
     *
     * @param Location  as String (Send GMT For Get TimeZone GMT)
     * @return TimeZone as int
     */
    public static TimeZone GetTimeZone(String Location){
        TimeZone tz = TimeZone.getTimeZone(Location);
        return tz;
    }
}
