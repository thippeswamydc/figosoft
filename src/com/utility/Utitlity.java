package com.utility;

public class Utitlity 
{

	public static int parseStringToInt(String s){
        s = s.replaceAll(",", ""); //remove commas
        return (int)Math.round(Double.parseDouble(s)); //return rounded double cast to int
    }
	
}
