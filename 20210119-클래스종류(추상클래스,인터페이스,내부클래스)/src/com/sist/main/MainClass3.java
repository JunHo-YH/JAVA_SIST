package com.sist.main;
/*
 * �߻� Ŭ����
 *     = ������ ������ �޼���
 *     = ���� �ؾߵǴ� �޼���
 */
abstract class Board {
	public abstract void write(); //�۾���
	public abstract void list();//���
	public abstract void detail(); // �󼼺���
	public void update() {} // ����
	public abstract void delete(); // ����
	public void find() {} // ã��
}
class �Խ��� extends Board{

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
//	public void write() {} //�۾���
//	public void list() {} //���
//	public void detail() {} // �󼼺���
//	public void update() {} // ����
//	public void delete() {} // ����
//	public void find() {} // ã��
}
class �ڷ�� extends Board{
//	public void write() {} //�۾���, ���� �ø���
//	public void list() {} //���
//	public void detail() {} // �󼼺���, ���� �ٿ�ε�
//	public void update() {} // ����
//	public void delete() {} // ����
//	public void find() {} // ã��
	public void upload() {} // ���ε�
	public void download() {} // �ٿ�ε�
	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void detail() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
}
class �亯�Խ��� extends Board{
//	public void write() {} //�۾���
//	public void list() {} //���, �亯�� ���
//	public void detail() {} // �󼼺���
//	public void update() {} // ����
//	public void delete() {} // ����
//	public void find() {} // ã��
	public void reply() {} // �亯

@Override
public void write() {
	// TODO Auto-generated method stub
	
}

@Override
public void list() {
	// TODO Auto-generated method stub
	
}

@Override
public void detail() {
	// TODO Auto-generated method stub
	
}

@Override
public void delete() {
	// TODO Auto-generated method stub
	
}
}
class ��۰Խ��� extends Board{
//	public void write() {} //�۾���
//	public void list() {} //���
//	public void detail() {} // �󼼺���, ���
//	public void update() {} // ����
//	public void delete() {} // ����
//	public void find() {} // ã��
	public void replyWrite() {} // ��� ����
	public void replayDelete() {} // ��� ����
	public void replyUpdate() {} // ��� ������Ʈ
	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void detail() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
}
public class MainClass3 {

	public static void main(String[] args) {

	}

}
