package com.sist.main2;

interface DataBase {
	public void connect();

	public void disconnect();
}

class Oracle implements DataBase {

	@Override
	public void connect() {
		System.out.println("����Ŭ ����");
	}

	@Override
	public void disconnect() {
		System.out.println("����Ŭ �ݱ�");
	}

}

class MsSQL implements DataBase {

	@Override
	public void connect() {
		System.out.println("MsSQL ����");
	}

	@Override
	public void disconnect() {
		System.out.println("MsSQL �ݱ�");

	}

}

class MySQL implements DataBase {

	@Override
	public void connect() {
		System.out.println("MySQL ����");

	}

	@Override
	public void disconnect() {
		System.out.println("MySQL �ݱ�");

	}

}

class DB2 implements DataBase {

	@Override
	public void connect() {
		System.out.println("DB2 ����");

	}

	@Override
	public void disconnect() {
		System.out.println("DB2 �ݱ�");

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
 * �������̽�: ������
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
