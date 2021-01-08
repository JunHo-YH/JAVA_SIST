/*
 * 	�޼���: �� ���� ����� �����ϱ� ���� ��ɹ��� ����
 *        ==============================
 *        ������ ����
 *        �ݺ��� ������ �� �ִ�
 *        �޼��� ȣ�� => �޼����(��...) => �޼����� �������� {} �ȿ� �ִ� ��� ������ �����ϰ� �ٽ� ȣ��� ��ġ�� �����Ѵ�.
 *        
 *        
 *        ==============================
 *        *** ��ɹ�
 *            int a = 10; // 10�� a��� �޸� ������ �����ض�.
 *            int b = 20;
 *            System.out.println(a + b)
 *            
 *        ����)
 *            ������(�����) �޼����(�Ű�����...) {
 *            	������ ������ �ڵ�
 *            }
 *            
 *            = ������(O) �Ű�����(O)
 *                *** ������: ����ڰ� ��û�� ������ ó���Ŀ� ������ ����� (������� �ݵ�� �ϳ��� !)
 *                          ������� ���� ���� ���: �迭�̳� Ŭ������ ����Ѵ�.
 *                          				  ===========
 *                          = ��� �޼���� �޼��� ���Ḧ ���ؼ� return�� ���
 *                            return ��; (void�� ��쿡�� return�� ������ �� �ִ�)
 *                *** �Ű�����: 
 *            = ������(O) �Ű�����(X)
 *            = ������(X) �Ű�����(O)
 *            = ������(X) �Ű�����(X)
 *            
 *        	  �޼���� �ҽ��� ���ų� ������ ��쿡 �и��ϱ� ���� �����.
 *            
 *        
 */
/*
 * +++ �̷� ��� ��� +++
 * 	1. �ݺ��� ���� *****
 * 	2. ������ �ٽ� ��� *****
 * 	3. ������ �ҽ��ڵ� 
 */
public class �޼������� {
	// ����ϴ� �޼���
	static void print(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
	}

	// �����ϴ� �޼���

	static int[] sort_asc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[i] > arr[k]) {
					int tmp = arr[i];
					arr[i] = arr[k];
					arr[k] = tmp;
				}
			}
		}
		return arr;
	}

	static int[] sort_desc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[i] < arr[k]) {
					int tmp = arr[i];
					arr[i] = arr[k];
					arr[k] = tmp;
				}
			}
		}
		return arr;
	}
	
	static int[] sort(int[] arr, String type) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (type.equals("DESC")){	
					if (arr[i] < arr[k]) {
						int tmp = arr[i];
						arr[i] = arr[k];
						arr[k] = tmp;
					}
				}
				else {	
						if (arr[i] > arr[k]) {
							int tmp = arr[i];
							arr[i] = arr[k];
							arr[k] = tmp;
						}
				}
		
		}
	}
		return arr;
	}
	
	
	public static void main(String[] args) {
		int[] arr = { 30, 20, 50, 10, 40 };
		System.out.println("===== ���� ��=====");
		// ���: for-each => �������� ����ϱ� ��ƴ� / �������� ����Ϸ��� �Ϲ� for���� �������. // �������� �迭�� ���� �����
		// �� ����. // �迭�� ���� ������ �� ����.

		/*
		 * for (int i : arr) { System.out.print(i + " "); }
		 */
		print(arr);
		System.out.println("\n===== ���� ��(ASC: �ø�����) =====");
		/*
		 * i 30 20 50 10 40
		 */
		/*
		 * for (int i = 0; i < arr.length - 1; i++) { for (int k = i + 1; k <
		 * arr.length; k++) { if (arr[i] > arr[k]) { int tmp = arr[i]; arr[i] = arr[k];
		 * arr[k] = tmp; } } }
		 */
		// ���
		/*
		 * for (int i : arr) { System.out.print(i + " "); }
		 */
		int[] arr1 = sort_asc(arr);
		print(arr1);

		System.out.println("\n===== ���� ��(DESC: ��������) =====");
		/*
		 * for (int i = 0; i < arr.length - 1; i++) { for (int k = i + 1; k <
		 * arr.length; k++) { if (arr[i] < arr[k]) { int tmp = arr[i]; arr[i] = arr[k];
		 * arr[k] = tmp; } } }
		 */
		int[] arr2 = sort_desc(arr);
		// ���
		print(arr2);

	}

}
