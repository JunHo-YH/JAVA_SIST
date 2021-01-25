package com.sist.util;
// StringTokenizer => java.util.* 
/*
 *   단어별로 문지열을 분리하는 역할 (빅데이터)
 *   = hasMoreTokens()
 *   = countTokens()
 *   = nextToken()
 *   
 *   StringTokenizer(colors,",");
 *                   ======
 *                   제어할 문자열  , 구분자 
 */
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String colors="red|yellow|blue|green|black|white";
        StringTokenizer st=new StringTokenizer(colors,"|");
        System.out.println(st.countTokens());
        /*while(st.hasMoreTokens())
        {
        	System.out.println(st.nextToken());
        }*/
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        //System.out.println(st.nextToken());
	}

}















