package com.sist.server;

/* 데이터를 관리 (파일 = 오라클)
 * 
 * 배열(객체 배열): 갯수(고정)
 * => 가변형 : 컬렉션
 * Collection
 *     |
 *------------------------
 *|          |           |
 *List      Set         Map       => 인터페이스
 *
 *기준점
 *List: 순서(인덱스)가 존재, 데이터 중복
 *      => 구현한 클래스: ArrayList, Vector, LinkedList, Stack
 *                    ==========
 *
 *Set: 순서(인덱스)가 없다, 데이터 중복X
 *     => HashSet(중복없는 데이터를 모아서 List에 저장) ==> 오라클 DISTINCT
 *     
 *Map: 순서(인덱스)가 없다 => key, value가 동시에 저장
 *                        => key는 중복할 수 없지만 value는 중복 가능하다.
 */
import java.util.*;
import java.io.*;

public class MovieManager {
	private static ArrayList<MovieVO> list = new ArrayList<MovieVO>(); // 제한이 없다
	// MovieVO[] 데이터 저장공간의 제한 有
	// 프로그램 시작 => 데이터를 저장 => 초기화 블럭(파일 => 메모리)
	// 웹스크랩핑 연습하기
	static {
		try {
			FileReader fr = new FileReader("c:\\javaDev\\daum_movie.txt");
			StringBuffer sb = new StringBuffer();
			int i = 0;
			while ((i = fr.read()) != -1) {
				sb.append(String.valueOf((char) i));
			}
			fr.close();
//			System.out.println(sb.toString());
			String[] movie_data = sb.toString().split("\n");
			/*
			 * 219| 5| 알라딘(2019)| 8.4| 어드벤처/판타지/가족/뮤지컬| 2019.05.23 | 128분| 전체관람가| 가이 리치| 메나
			 * 마수드|
			 * //img1.daumcdn.net/thumb/C155x225/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fmovie%
			 * 2F3673a8a0c5ff4f5c8c25cc959fd6985b1558662957684| 12,723,777| 머나먼 사막 속 신비의
			 * 아그라바 왕국의 시대. 좀도둑 ‘알라딘’은 마법사 ‘자파’의 의뢰로 마법 램프를 찾아 나섰다가 주인에게 세 가지 소원을 들어주는 지니를
			 * 만나게 되고, 자스민 공주의 마음을 얻으려다 생각도 못했던 모험에 휘말리게 되는데…
			 * 
			 */
			for (String s : movie_data) {
				System.out.println(s); // |별로 분리 => VO에 첨부 => ArrayList에 첨부
				StringTokenizer st = new StringTokenizer(s, "|");
				MovieVO vo = new MovieVO();
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setCno(Integer.parseInt(st.nextToken()));
				vo.setTitle(st.nextToken());
				vo.setScore(st.nextToken());
				vo.setGenre(st.nextToken());
				vo.setTime(st.nextToken());
				vo.setGrade(st.nextToken());
				vo.setDirector(st.nextToken());
				vo.setActor(st.nextToken());
				vo.setPoster("http:" + st.nextToken());
				vo.setShowUser(st.nextToken());
				vo.setStroy(st.nextToken());

				list.add(vo);
				// String[] data = s.split("\\|");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 목록 출력 (전체)
//		public ArrayList<MovieVO> movieListData(int page) {
//			ArrayList<MovieVO> mList = new ArrayList<MovieVO>();
//			return mList;
//		}

	}

	public int movieCategoryTotalPag(int cno) {
		int total = 0;
		int count = 0;
		for (MovieVO vo : list) {
			count++;
		}
		total = (int) (Math.ceil(count / 10.0));
		return total;
	}

	public static void main(String[] args) {
		MovieManager m = new MovieManager();
		String[] category = { "", "현재상영영화", "개봉예정영화", "박스오피스(주간)", "박스오피스(월간)", "박스오피스(연간)" };
		System.out.println("총페이지: " + category.length);
		for (int i = 1; i <= 5; i++) {

			System.out.println(category[i] + ":" + m.movieCategoryTotalPag(i));
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.print("검색어 입력: ");
		String find_data = scan.next();
		
		System.out.println("페이지 입력: ");
		int page = scan.nextInt();
	}
	
}
