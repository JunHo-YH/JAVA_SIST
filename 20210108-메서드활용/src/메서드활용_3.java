
public class �޼���Ȱ��_3 {
	// void => �ᱣ���� �������� �ʴ´� (�޼��忡�� ���)
	static void aMethod() {
		System.out.println("aMethod ȣ�� ����");
		System.out.println("aMethod ��� ó��");
		System.out.println("aMethod ����");
	}

	static void bMethod() {
		System.out.println("bMethod ȣ�� ����");
		System.out.println("bMethod ��� ó��");
		System.out.println("bMethod ����");
	}

	static void cMethod() {
		System.out.println("cMethod ȣ�� ����");
		System.out.println("cMethod ��� ó��");
		System.out.println("cMethod ����");
	}

	public static void main(String[] args) { // main => ���۰� ���Ḧ ��Ÿ���� �޼���
		System.out.println("���� ����");
		aMethod();
		aMethod();
		bMethod();
		cMethod();
		System.out.println("Main ����");

	}

}
