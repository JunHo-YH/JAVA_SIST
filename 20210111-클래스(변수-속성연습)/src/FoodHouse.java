
public class FoodHouse {
	String name;
	double score;
	String address1;
	String address2;
	String tel;
	String type;
	String price;
	String parkPlace;
	String busineeHours;
	String breakTime;
	String[] menu;
	int good;
	int soso;
	int bad;
	static String title = "�����÷���Ʈ";
	// poster

	public static void main(String[] args) {
		FoodHouse f = new FoodHouse();
		f.name = "";
		f.score = 4.3;
		f.address1 = "����Ư���� ������ �ø��ȷ�60�� 5 �ѽ����� 1F";
		f.address2 = "����� ������ ������ 111-55 �ѽ����� 1F";
		f.tel = "02-474-3520";
		f.type = "�±� ����";
		f.price = "����-2����";
		f.parkPlace = "������������";
		f.busineeHours = "11:30 - 21:30";
		f.breakTime = "14:30 - 17:00";
		f.menu = new String[4]; // �迭�� �ִ� ��� => �ݵ�� ũ�� ����
		f.menu[0] = "��Ÿ�� 10,000��";
		f.menu[1] = "������Ŀ�� (2����) 18,000��";
		f.menu[2] = "�c��� 12,000��";
		f.menu[3] = "�ٿ��̶�� 9,000��";
		f.good = 58;
		f.bad = 10;
		f.soso = 9;
		
		System.out.println("===== �󼼺��� =====");
		System.out.println(f.name + " " + f.score);
		System.out.println("�ּ�: " + f.address1);
		System.out.println("     ����:" + f.address2);
		System.out.println("��ȭ��ȣ: " + f.tel);
		System.out.println("��������" + f.type); 
		System.out.println("���ݴ�: " + f.price);
		System.out.println("����: " + f.parkPlace);
		System.out.println("�����ð�: " + f.busineeHours);
		System.out.println("���½ð�: " + f.breakTime);
		System.out.println("�޴�:");
		for (String s : f.menu) {
			System.out.println(s);
		}
		System.out.println("����(" + (f.good + f.soso + f.bad) + ")");
		System.out.println("���ִ�: " + f.good);
		System.out.println("������:" + f.soso);
		System.out.println("���δ�:" + f.bad);
		System.out.println("\n���������� ��ü: " + f.title);
		
	}

}
