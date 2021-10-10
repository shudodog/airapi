package com.airconditon.airapi.v1.infrastructure.api.seoul;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodayDate {



    public static String now(){
        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");

        Date time = new Date();

        final String time1 = format1.format(time);


        return time1;
    }



}
