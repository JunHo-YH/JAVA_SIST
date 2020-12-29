
public class 삼항연산자 {

	public static void main(String[] args) {
		char c = 'K';
		boolean bCheck = c> 'A' ? true : false;
		System.out.println(bCheck);
		
		int a = 33;
		String s = a % 2 == 0 ? "짝수" : "홀수";
		System.out.println(s);
		
		int  num = (int)(Math.random()*4 + 1); // 사칙연산보다 형번환이 우선순위가 높다
		char sex = num == 1 || num == 3 ? '남' : '여';
		// int, long, float, double
		System.out.println(sex);
		
		sex = '남';
		int no = sex == '남' ? 1 : 2;
		// int, long, float, double
		System.out.println(no);
	}

}
