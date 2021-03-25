package com.sist.dao;

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
