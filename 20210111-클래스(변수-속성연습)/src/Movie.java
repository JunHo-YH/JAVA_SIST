/*
 * 1)���� �� Ȩ(2020)  2)����
   3)Lassie Come Home, Lassie: Eine Abenteurliche Reise 4)���� 09 . 5
   5)��庥ó/���/����
   6)����
   7)2021.01.07 ����
   8)96��, 9)��ü������
   10)���� �ϳ� �ô��� 11)�ֿ� ���ٽ��� ����, �ȳ� ������ ����, ���� ������ī
   12)���� 4�� 13)��������936��
   
    14)�� ���� ����Ʈ���� [���ƿ� ����] ����  
	��ȭ ����� ���� ������ ��� �����á��� ���ϴ� 2021�� ���� ù ����! 
	
	������ ���� ������ ģ���� 12�� �ҳ� �÷ο� õ��� ����.
	�ƹ����� ������ ���� ������ �̻����� �÷δ� �� �̻� �ݷ����� Ű�� �� ���� �ǰ�,
	���ô� �ٸ� ����� ���ÿ� �ð�����.
	���۽����� �̺��� ���ÿ� �÷ΰ� ���θ� �׸����ϴ� ��� ��,
	���� ���� �� ������ ������ ���ø� �Ⱦ� �ѱ�� �ϰ�, ���ô� �̸� ���� ����ģ��.
	�� �ҽ��� ���� �÷δ� ���ø� ã�� ���� �밨�� ������ �����µ��� 
	
	�������, �ٽ� ȥ�� ���� �����ԡ�
	�Բ��� �ູ�� �÷ο� ������ ���ν� ������ ���۵ȴ�!
	
	15)Category
	16)��ȭ���� ������ȣ movieCode=115600
	17)����Ʈ
 */
public class Movie {
	// ������ �޸� ������ ���� �� => new�� ����Ѵ�
	//////////////////////���� (�޸� ����) ////////////////////
	String titleKr;
	boolean isShow; // boolean => is~ / void => set~
	String titleEn;
	double score;
	String genre;
	String nation;
	String regdate;
	int time;
	String grade;
	String director;
	String[] actor;
	int reserve;
	int totalAudience;
	String story; // ���ڿ��� ���̿� ������ ����.

	public static void main(String[] args) {
		// �޸𸮿� ���� => ������ �б�(����: ����(�� ����), �б�(����� �� ������ ����))
		Movie m1 = new Movie(); // m1 => �޸� �ּ� (��ü)
		m1.titleKr = "���� �� Ȩ(2020)";
		m1.titleEn = "Lassie Come Home, Lassie: Eine Abenteurliche Reise";
		m1.isShow = true;
		m1.score =  9.5;
		m1.genre = "��庥ó/���/����";
		m1.nation = "����";
		m1.regdate = "2021.01.07 ����";
		m1.time = 96;
		m1.grade = "��ü������";
		m1.director = "�ϳ� �ô���";
		m1.reserve = 4;
		m1.totalAudience = 936;
		m1.story = "�� ���� ����Ʈ���� [���ƿ� ����] ����  \r\n"
				+ "	��ȭ ����� ���� ������ ��� �����á��� ���ϴ� 2021�� ���� ù ����! \r\n"
				+ "	\r\n"
				+ "	������ ���� ������ ģ���� 12�� �ҳ� �÷ο� õ��� ����.\r\n"
				+ "	�ƹ����� ������ ���� ������ �̻����� �÷δ� �� �̻� �ݷ����� Ű�� �� ���� �ǰ�,\r\n"
				+ "	���ô� �ٸ� ����� ���ÿ� �ð�����.\r\n"
				+ "	���۽����� �̺��� ���ÿ� �÷ΰ� ���θ� �׸����ϴ� ��� ��,\r\n"
				+ "	���� ���� �� ������ ������ ���ø� �Ⱦ� �ѱ�� �ϰ�, ���ô� �̸� ���� ����ģ��.\r\n"
				+ "	�� �ҽ��� ���� �÷δ� ���ø� ã�� ���� �밨�� ������ �����µ��� \r\n"
				+ "	\r\n"
				+ "	�������, �ٽ� ȥ�� ���� �����ԡ�\r\n"
				+ "	�Բ��� �ູ�� �÷ο� ������ ���ν� ������ ���۵ȴ�!";
		String actor = "���ٽ��� ����, �ȳ� ������ ����, ���� ������ī";
		m1.actor = actor.split(","); //split => ���ڿ��� �и� => String[]
		//////////////////////////////////////////////////////////////////////////////////
		System.out.println("��ȭ��(�ѱ�)" + m1.titleKr);
		System.out.println(m1.isShow == true ? "����" : "���� ����");
		System.out.println("��ȭ��(����):" + m1.titleEn);
		System.out.println("����:" + m1.director);
		System.out.print("�⿬:");
		String s = "";
		for (String name : m1.actor) {
		s += name + ",";
		
		}
		s = s.substring(0,s.lastIndexOf(",")); // �� �������� �ִ� ,�� ã�Ƽ� ����
		System.out.println(s);
		System.out.println("�帣: " + m1.genre);
		System.out.println("���: " + m1.grade + "������");
		System.out.println("����:" + m1.nation);
		System.out.println("�󿵽ð�: " + m1.time + "��");
		System.out.println("������: " + m1.reserve + "��");
		System.out.println("�����ο�: " + m1.totalAudience + "��");
		System.out.println("stroy: " + m1.story);
	}

}
