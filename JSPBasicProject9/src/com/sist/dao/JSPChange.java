package com.sist.dao;
/*
 * "../food/home.jsp",
   	=> main.jsp?mode=0
   "../food/category.jsp",
   	=> main.jsp?mode=1
   "../food/detail.jsp"
   	=> main.jsp?mode=2&no=1
  	==> detail.jsp?no=1
   
   
 * 
 */
public class JSPChange {
    private static String[] jsp={
       "../food/home.jsp",
       "../food/category.jsp",
       "../food/detail.jsp"
    };
    
    public static String change(int no)
    {
    	return jsp[no];
    }
}
