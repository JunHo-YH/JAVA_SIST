package com.sist.anno;

import java.lang.reflect.Method;

public class MovieSystem {
	public static void main(String[] args) {
		MovieSystem ms = new MovieSystem();
		ms.movie("찾기");
	}

	public void movie(String menu) {
		try {
			Class clsName = Class.forName("com.sist.anno.MovieManager"); // 클래스의 정보를 가지고 온다.
			// 메모리 할당
			Object obj = clsName.getConstructor().newInstance();
			// MovieManager m = new MovieManager();
			// clsName가 가지고 있는 모든 메서드를 가지고 온다.
			Method[] methods = clsName.getDeclaredMethods();
			for (Method m : methods) {
				// System.out.println(m.getName());
				RequestMapping rm = m.getAnnotation(RequestMapping.class);
				if (rm.value().equals(menu)) {
					m.invoke(obj, null);
					break;
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
