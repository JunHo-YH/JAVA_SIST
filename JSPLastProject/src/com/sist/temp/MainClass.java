package com.sist.temp;

import java.util.Arrays;

// 5,10,11,21,30
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReserveDAO dao=new ReserveDAO();
		for(int i=1;i<=31;i++)
		{
			String s=getReserveData();
			dao.rdayInsert(i, s);
		}
        //getReserveData();
	}
	public static String getReserveData()
	{
		String result="";
		int rand=(int)(Math.random()*5)+3;
		System.out.println("rand:"+rand);
		int[] com=new int[rand];// 10~15
		int su=0;
		boolean bCheck=false;
		for(int i=0;i<rand;i++)
		{
			bCheck=true;
			while(bCheck)
			{
				su=(int)(Math.random()*12)+1;
				bCheck=false;
				for(int j=0;j<i;j++)
				{
					if(com[j]==su)
					{
						bCheck=true;
						break;
					}
				}
			}
			com[i]=su;
		}
		// 출력
		Arrays.sort(com);
		for(int i:com)
		{
			result+=i+",";
		}
		result=result.substring(0,result.lastIndexOf(","));
		System.out.println(result);
		return result;
	}

}













