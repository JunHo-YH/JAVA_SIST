package com.sist.math;
// Math 
/*
 *    ceil() : �ø� �޼ҵ� ===> public static double ceil(double d)
 *    
 *    int count=38;
 *    int total=count/10;  => total=3
 *    if(total%10>0)
 *       total++;     total=4
 *       
 *    int count=38;
 *    int total=(int)(Math.ceil(count/10.0))  total=4
 *    
 *    ==> SELECT CEIL(COUNT(*)/10.0) FROM movie => SQL(�˻�)
 *    
 *    
 *    random() => ��ǻ�Ϳ��� ������ ���� ������ �´� (����) ==> public static double random()
 *    ========
 *      0.0 ~ 0.99 ������ �Ǽ��� �߻� 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ceil
		int count=47;
		int total=(int)(Math.ceil(count/10.0)); //total=4
		//                       =========== 4.0 ==> 4.7 (1�̻�)
		System.out.println(total);
		
		// random()
		int data=(int)(Math.random()*100)+1;// 0.0~99.0=> 0~99 ==> 1~100
		// ������ �켱���� ===> () (type) => 
		System.out.println(data);
	}

}








