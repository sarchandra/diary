package com.wcc.diary.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class Utils {

    static public String GetDateNow(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        return date;
    }

}
