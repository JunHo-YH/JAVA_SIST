package com.sist.io;

import java.io.*;
import java.util.*;

public class MainClass11 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:\\download\\sawon.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Sawon> list = (ArrayList<Sawon>)ois.readObject();
			for(Sawon s : list) {
				System.out.println("이름: " + s.getName());
				System.out.println("연봉: " + s.getPay());
				System.out.println("====================");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
