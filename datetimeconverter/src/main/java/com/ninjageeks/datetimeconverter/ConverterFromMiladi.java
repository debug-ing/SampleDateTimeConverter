package com.ninjageeks.datetimeconverter;

import android.util.Log;

import androidx.annotation.NonNull;

public class ConverterFromMiladi {
    public  String ConvertShamsi(){
        //2020-01-25 15:45:21
        String[] id = DateTimeConverter.data.split(" ");
        String Date = id[0];
        String[] date = Date.split("-");
        //
        DateConverter converter = new DateConverter();
        Log.e("mm",date[0]);
        Log.e("mm",date[1]);
        Log.e("mm",date[2]);
        converter.gregorianToPersian(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
        //
        return converter.getDay() + " " + converter.GetNameMount(converter.getMonth());
    }
    public  String ConvertGhamari(){
        //2020-01-25 15:45:21
            /*
            String[] id = DateTimeConverter.data.split(" ");
            String Date = id[0];
            String[] date = Date.split("-");
            //
            DateConverter converter = new DateConverter();
            Log.e("mm",date[0]);
            Log.e("mm",date[1]);
            Log.e("mm",date[2]);
            converter.gregorianToPersian(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
            //
            return converter.getDay() + " " + converter.GetNameMount(converter.getMonth());
             */
        return "";
    }

    @NonNull
    public String GetDateTime(){
        return DateTimeConverter.data;
    }

}
