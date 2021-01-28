package com.sist.main;

import java.util.HashMap;

interface I {
	public void dispaly();
}


class A implements I {
	public void dispaly() {
		System.out.println("A: display Call...");
	}
}
class B implements I {
	public void dispaly() {
		System.out.println("B: display Call...");
	}
}
class C implements I {
	public void dispaly() {
		System.out.println("C: display Call...");
	}
}

class Container {
	HashMap map = new HashMap();
	public Container() {
		// 클래스를 저장
		map.put("a",  new A());
		map.put("b", new B());
		map.put("c", new C());
	}
	public I getBean(String key) {
		return (I)map.get(key);
	}
}
public class MainClass3 {

	public static void main(String[] args) {
		Container con = new Container();
		I i = con.getBean("a");
		System.out.println("i= " + i);
		i.dispaly();
		System.out.println();
		
		i = con.getBean("b");
		System.out.println("i= " + i);
		i.dispaly();
		System.out.println();
		
		i = con.getBean("c");
		System.out.println("i= " + i);
		i.dispaly();
		System.out.println();
		
		i = con.getBean("a");
		System.out.println("i= " + i);
		i.dispaly();
		
		
	}

}
