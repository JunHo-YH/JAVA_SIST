package com.sist.data;
import java.io.*;
import java.util.*;
public class MovieManager {
    private static ArrayList<MovieVO> list=new ArrayList<MovieVO>();
    static
    {
    	try
    	{
    		// 파일 읽기 
    		FileInputStream fis=new FileInputStream("c:\\download\\movie.txt");
    		// 객체단위로 변경 : 역직렬화 
    		ObjectInputStream oos=new ObjectInputStream(fis);
    		// ArrayList에 값을 채워준다
    		list=(ArrayList<MovieVO>)oos.readObject();
    		oos.close();
    	}catch(Exception ex){}
    }
    // 기능 => 메소드 
    // 1. 전체 목록 출력 => 페이지 나누기 
    /*
     *   윈도우창 => 사용자 요청 => 2페이지 보여달라 => MovieManager처리 => 결과값 => 윈도우 
     *     웹(브라우저) 
     */
    public ArrayList<MovieVO> movieListData(int page)
    {
    	ArrayList<MovieVO> mList=new ArrayList<MovieVO>();
    	int rowSize=20;
    	int start=(page*rowSize)-rowSize;
    	/*
    	 *    1page  0~19 (1~20)
    	 *    2page  20~39 (21~40)
    	 *    11page 200~219 => (201~219)
    	 */
    	int total=movieTotalPage();
    	//System.out.println(total);
    	if(page==total)
    	{
    		rowSize=list.size()%20;// 데이터총갯수%20 => 219%20 = 19 219 => 220
    		// 219%20
    		// 11%20 ==> 11
    	}
    	
    	for(int i=start;i<start+rowSize;i++)
    	{
    		MovieVO vo=list.get(i);
    		mList.add(vo);
    	}
    	return mList;
    }
    // 1-1. 총페이지 구하기
    public int movieTotalPage()
    {
    	return (int)(Math.ceil(list.size()/20.0)); //219/20 => 11
    	// ceil => 올림 메소드 => 소수점이하가 1이상이면 올림
    	// random() , ceil()
    }
    // 2. 카테고리별 출력 => 페이지 나누기
    // 3. 검색 : 제목별  => 페이지 나누기 
    // 4. 검색 : 장르별  => 페이지 나누기 => 사람이 한눈에 볼수 있는 화면(그림 15)
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieManager m=new MovieManager();
		ArrayList<MovieVO> list=m.movieListData(11);
		for(MovieVO vo:list)
		{
			System.out.println(vo.getMno());
			System.out.println(vo.getTitle());
			System.out.println("==================================================");
		}
        /*for(MovieVO vo:list)
        {
        	System.out.println(vo.getMno());
        	System.out.println(vo.getTitle());
        	System.out.println(vo.getDirector());
        	System.out.println(vo.getActor());
        	System.out.println("===================================================");
        }*/
		/*Scanner scan=new Scanner(System.in);
		String[] menu={
				"1. 현재 상영 영화",
				"2. 개봉 예정 영화",
				"3. 박스오피스(주간)",
				"4. 박스오피스(월간)",
				"5. 박스오피스(연간)"
		};
		System.out.println("========== 메뉴 ==========");
		for(String s:menu)
		{
			System.out.println(s);
		}
		System.out.println("=========================");
		System.out.print("메뉴를 선택하세요?");
		int index=scan.nextInt();
		for(MovieVO vo:list)
		{
			if(vo.getCno()==index)
			{
				System.out.println(vo.getMno());
	        	System.out.println(vo.getTitle());
	        	System.out.println(vo.getDirector());
	        	System.out.println(vo.getActor());
	        	System.out.println("===================================================");
			}
		}
		System.out.print("장르 입력:");
		String genre=scan.next();
		for(MovieVO vo:list)
		{
			if(vo.getGenre().contains(genre))
			{
				System.out.println(vo.getMno());
				System.out.println(vo.getGenre());
	        	System.out.println(vo.getTitle());
	        	System.out.println(vo.getDirector());
	        	System.out.println(vo.getActor());
	        	System.out.println("===================================================");
			}
		}
		
		System.out.print("영화 제목 입력:");
		String title=scan.next();
		for(MovieVO vo:list)
		{
			if(vo.getTitle().contains(title))
			{
				System.out.println(vo.getMno());
				System.out.println(vo.getGenre());
	        	System.out.println(vo.getTitle());
	        	System.out.println(vo.getDirector());
	        	System.out.println(vo.getActor());
	        	System.out.println("===================================================");
			}
		}
		
		System.out.print("1~219 번호를 선택:");
		int detail=scan.nextInt();
		MovieVO vo=list.get(detail-1); // ArrayList => 시작 0
		System.out.println(vo.getMno());
		System.out.println(vo.getGenre());
    	System.out.println(vo.getTitle());
    	System.out.println(vo.getDirector());
    	System.out.println(vo.getActor());
    	System.out.println(vo.getTime());
    	System.out.println(vo.getGrade());
    	System.out.println(vo.getRegdate());
    	System.out.println(vo.getScore());*/
	}

}










