package com.sist.math;
// Math 
/*
 *    ceil() : 올림 메소드 ===> public static double ceil(double d)
 *    
 *    int count=38;
 *    int total=count/10;  => total=3
 *    if(total%10>0)
 *       total++;     total=4
 *       
 *    int count=38;
 *    int total=(int)(Math.ceil(count/10.0))  total=4
 *    
 *    ==> SELECT CEIL(COUNT(*)/10.0) FROM movie => SQL(검색)
 *    
 *    
 *    random() => 컴퓨터에서 임의의 수를 가지고 온다 (난수) ==> public static double random()
 *    ========
 *      0.0 ~ 0.99 사이의 실수를 발생 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ceil
		int count=47;
		int total=(int)(Math.ceil(count/10.0)); //total=4
		//                       =========== 4.0 ==> 4.7 (1이상)
		System.out.println(total);
		
		// random()
		int data=(int)(Math.random()*100)+1;// 0.0~99.0=> 0~99 ==> 1~100
		// 연산자 우선순위 ===> () (type) => 
		System.out.println(data);
	}

}








