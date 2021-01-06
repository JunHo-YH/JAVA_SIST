
public class 배열활용_8_문자열변환 {

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
		 * 						======== 제외(미만) => end -1까지 
		 * 						MainClass.java => indexOf(".") => .의 위치를 찾는다.
		 * 
		 * String data = "Hello Java!!";
		 */
	
		String data = "0123456789";
		System.out.println(data.substring(3));
		System.out.println(data.substring(3, 6)); // endIndex - 1
		//                					=== 제외 => 3 ~ 5까지
		
		
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
