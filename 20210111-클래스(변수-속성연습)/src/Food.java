
public class Food {
	static String title = "������ ������";
	String writer;
	String name;
	String story;
	int people;
	int time;
	String level;
	String[] material;
	String[] flow;
	String warning;

	public static void main(String[] args) {
		Food f = new Food();
		f.writer = "�丮�ϴ·���";
		f.name = "�ߺ���������~ �ʳ�° ����� �Դ� ��� �����ؿ�!";
		f.story = "�ʰ��� ���������� ���� �ִ� ���� ��信 ���� ��ģ ���־��� �ڶ��ϴ� �ߺ�����~ ���� ��𿡼� �������� ���൵ �α⸸�� �����ǿ���";
		f.people = 2;
		f.time = 60;
		f.level = "�ƹ���";
		f.material = new String[10];
		f.material[0] = "�ߺ� 20��";
		f.material[1] = "���� ������";
		f.material[2] = "���� 1/2��";
		f.material[3] = "���� 1/2��";
		f.material[4] = "���� 5������";
		f.material[5] = "���� 2������";
		f.material[6] = "���� 2������";
		f.material[7] = "û�� 2������";
		f.material[8] = "��ø 1������";
		f.material[9] = "���� 1������";

		f.flow = new String[13];
		f.flow[0] = "1. �ߺ� 2��, �����δ� 20���� �غ��ؿ�";
		f.flow[1] = "2. �ߺ��� ���� ������ ���� �� 30�а� ��� �⳻�� �������ݴϴ�";
		f.flow[2] = "3. 30�� ��, ������ ��ų��� ü�� ���� ���⸦ ���ּ���(�Ϲ����� ����� �ؼ����� ���⼭ �������ϰ� Step6���� ������~)";
		f.flow[3] = "4. �õ����̳� �⳻�� ���� ������� ��ġ�� ������ �߰����ּ���(���û���)";
		f.flow[4] = "5. ���� ���� ���� �߰� ���� ������ �ְ� 3�а� ��ģ �� �ϳ��ϳ� �ľ��ݴϴ� ^^";
		f.flow[5] = "6. ������ �����ҿ� ���� 5, ���� 2, ���� 2, û�� 2, ��ø 1, ���� 1�� �־� ���� ����";
		f.flow[6] = "7. ���� ��� ���� �ݴ븦 ŭ���ϰ� �߶� �ְ�";
		f.flow[7] = "8. ���� ��Ḧ ��� ���� �Ѳ��� ���� �ߺҷ� 20�а� �����ݴϴ� (�ߺ�)";
		f.flow[8] = "9. �߰��߰� �Ѳ��� ���� ���Ʒ� ��ġ�� ��� �ٲ㰡�� �����ּ���~ ���� ���� �ʾ����� �ڹ��ڹ� ������ �����鼭 Ÿ�� �ʾƿ� ^^";
		f.flow[9] = "10. �ߺҷ� 20�� ������ ����Դϴ�~ ���� ���� �޶�����? ���� �Ѳ��� ���� ������ ���Ƶ鵵�� �߰��ҷ� 10�� ���� �� �����ָ� ���Ⱑ ��¦��¦ ���鼭 �ϼ��˴ϴ�!! (�߰���)";
		f.flow[10] = "���Ĵ� �������� ����ּ���~ ���, ��, ���� ���� �Ѳ����� �ߺ� 20��, �Ѳ����� �߰��� 10��, �߰��߰� �����ֱ�~ �������� :)";
		f.flow[11] = "���Կ� ��� ����Ա⵵ ���� �������� ����� ��¥ ������ �������ϱ� �� �ѹ� ��������~ ���� �����̳� ���ĸ� �÷��� �����ϴ�";
		f.flow[12] = "��§��§���δ� ǥ���ϱ� ������ �ߺ���������~ �� �ѹ��� ����� ���� ���� ������ ���� �ܰ�޴��� �ɰſ��� :D";

		f.warning = "1)�� ��䷹���ǿ� ä�Ҹ� �Բ� ���� ���� �� ��︮�� �ʾƿ�~ ������ �ߺ��� �����ּ��� ^^ (�߳����� �����ϴ�!)";

		System.out.println(
				"===============================================================================================");
		System.out.println("����:	" + f.name);
		System.out.println("�Ұ�: " + f.story);
		System.out.print("           " + f.people + "�κ� \t");
		System.out.print(f.time + "�̳� \t");
		System.out.print(f.level);
		System.out.println("\n===== ��� =====");
		System.out.println(f.material[0]);
		System.out.println(f.material[1]);
		System.out.println(f.material[2]);
		System.out.println(f.material[3]);
		System.out.println(f.material[4]);
		System.out.println(f.material[5]);
		System.out.println(f.material[6]);
		System.out.println(f.material[7]);
		System.out.println(f.material[8]);
		System.out.println(f.material[9]);

		System.out.println("===== ���� ���� =====");
		System.out.println(f.flow[0]);
		System.out.println(f.flow[1]);
		System.out.println(f.flow[2]);
		System.out.println(f.flow[3]);
		System.out.println(f.flow[4]);
		System.out.println(f.flow[5]);
		System.out.println(f.flow[6]);
		System.out.println(f.flow[7]);
		System.out.println(f.flow[8]);
		System.out.println(f.flow[9]);
		System.out.println(f.flow[10]);
		System.out.println(f.flow[11]);
		System.out.println(f.flow[12]);
		System.out.println("===== ���� ���� ======");
		System.out.println(f.warning);

	}

}
