// ���̺귯�� �̿�
public class �迭����_2 {

	public static void main(String[] args) {
		String[] names = {"ȫ�浿", "�̼���", "������", "��������", "�ڹ���"};
		String[] members = new String[10];
		String s;
//		System.arraycopy(������, ���۹�ȣ, �������, ���۹�ȣ, �);
		
		// ����
		System.arraycopy(names, 0, members, 0, 5);
		for(String name : members) {
			System.out.println(name);
		}
		System.out.println();
		System.arraycopy(names, 0, members, 5, 5);
		for(String name : members) {
			System.out.println(name);
		}
		System.out.println();
		
		
	}

}
