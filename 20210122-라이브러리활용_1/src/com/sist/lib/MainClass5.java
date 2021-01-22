package com.sist.lib;
/*
 * Object:
 * 
 */
import java.lang.reflect.Method;

class C {
	public void display() {
		System.out.println("C:display() Call");
	}
}

public class MainClass5{

	public static void main(String[] args) {
		C c = new C();
		Class cc = c.getClass();
		Class cc1 = C.class;
		System.out.println(cc1);
//		Class cc2 = Class.forName("");
//		try {
//			Class clsName = Class.forName("com.sist.lib.C");
//			Object obj = clsName.newInstance();
//			Method[] m = clsName.getDeclaredMethod();
//			m[0].invoke(obj,null);
//		}catch(Exception ex) {
//			
	}
}
