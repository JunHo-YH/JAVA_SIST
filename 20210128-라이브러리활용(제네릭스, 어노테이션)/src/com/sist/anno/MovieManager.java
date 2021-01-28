package com.sist.anno;

public class MovieManager {
	@RequestMapping("홈")
	public void moiveHome() {// 홈
		System.out.println("영화 홈입니다.");
	}
	@RequestMapping("목록")
	public void moiveList() {// 목록
		System.out.println("영화 목록입니다.");
	}
	
	@RequestMapping("상세")
	public void moiveDetail() {// 상세
		System.out.println("영화 상세보기입니다.");
	}
	
	@RequestMapping("예매")
	public void moiveReserve() {// 예매
		System.out.println("영화 예매 페이지입니다.");
	}
	
	@RequestMapping("찾기")
	public void moiveFind() {// 찾기
		System.out.println("영화를 찾을 수 있습니다.");
	}
	@RequestMapping("종료")
	public void movieEnd() {
		System.out.println("영화 사이트를 종료합니다.");
	}
}
