
public class �迭Ȱ��_8_���ڿ���ȯ {

	public static void main(String[] args) {
		/*
		String data = "Hello Java!!";
		char[] cdata = data.toCharArray(); // {'H', 'e', 'l', ...}
		for (char c : cdata) {
			System.out.println(c);
		}
		*/
		
		/*
			char[] cdata = {'A','B', 'C', 'D', 'E'};
			String data = String.valueOf(cdata);
			System.out.println(data);
		*/
		
		
		
		// substring()
		/*
		 * 	substring(int start)
		 * 	substring(int start, int end)
		 * 						======== ����(�̸�) => end -1���� 
		 * 						MainClass.java => indexOf(".") => .�� ��ġ�� ã�´�.
		 * 
		 * String data = "Hello Java!!";
		 */
	
		String data = "0123456789";
		System.out.println(data.substring(3));
		System.out.println(data.substring(3, 6)); // endIndex - 1
		//                					=== ���� => 3 ~ 5����
		
		
		/*
		 * "hamburger".substring(4, 8) returns "urge"
		 *  012345678
 			"smiles".substring(1, 5) returns "mile"
			 012345
		 * 
		 * 
		 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
