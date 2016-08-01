package edu.hrbeu.newsserver.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GateTime {
	 //鏍煎紡鍖栨棩鏈熸椂闂翠负鈥滃勾-鏈�-鏃� 鏃讹細鍒嗭細绉掆�濈殑鏍煎紡
    public String formatTime(Date date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str=format.format(date);
        return str;
    }    
}
