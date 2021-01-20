package com.sist.main2;

interface DataBase {
	public void connect();

	public void disconnect();
}

class Oracle implements DataBase {

	@Override
	public void connect() {
		System.out.println("오라클 연결");
	}

	@Override
	public void disconnect() {
		System.out.println("오라클 닫기");
	}

}

class MsSQL implements DataBase {

	@Override
	public void connect() {
		System.out.println("MsSQL 연결");
	}

	@Override
	public void disconnect() {
		System.out.println("MsSQL 닫기");

	}

}

class MySQL implements DataBase {

	@Override
	public void connect() {
		System.out.println("MySQL 연결");

	}

	@Override
	public void disconnect() {
		System.out.println("MySQL 닫기");

	}

}

class DB2 implements DataBase {

	@Override
	public void connect() {
		System.out.println("DB2 연결");

	}

	@Override
	public void disconnect() {
		System.out.println("DB2 닫기");

	}

}

class Container {
	public DataBase dbSelect(String type) {
		DataBase db = null;
		if (type.equals("Oracle"))
			db = new Oracle();
		else if (type.equals("MsSQL"))
			db = new MsSQL();
		else if (type.equals("MySQL"))
			db = new MySQL();
		else if (type.equals("DB2"))
			db = new DB2();
		return db;
	}
}
/*
 * 인터페이스: 리모컨
 * ========
 *   
 */
public class MainClass {

	public static void main(String[] args) {
		Container c = new Container();
		DataBase db = c.dbSelect("Oracle");
		db.connect();
		db.disconnect();
		System.out.println("=======================");
		db = c.dbSelect("DB2");
		db.connect();
		db.disconnect();
	}

}
