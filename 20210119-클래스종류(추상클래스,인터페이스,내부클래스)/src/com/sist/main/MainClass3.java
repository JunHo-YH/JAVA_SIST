package com.sist.main;
/*
 * 추상 클래스
 *     = 구현이 가능한 메서드
 *     = 선언만 해야되는 메서드
 */
abstract class Board {
	public abstract void write(); //글쓰기
	public abstract void list();//목록
	public abstract void detail(); // 상세보기
	public void update() {} // 수정
	public abstract void delete(); // 삭제
	public void find() {} // 찾기
}
class 게시판 extends Board{

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
//	public void write() {} //글쓰기
//	public void list() {} //목록
//	public void detail() {} // 상세보기
//	public void update() {} // 수정
//	public void delete() {} // 삭제
//	public void find() {} // 찾기
}
class 자료실 extends Board{
//	public void write() {} //글쓰기, 파일 올리기
//	public void list() {} //목록
//	public void detail() {} // 상세보기, 파일 다운로드
//	public void update() {} // 수정
//	public void delete() {} // 삭제
//	public void find() {} // 찾기
	public void upload() {} // 업로드
	public void download() {} // 다운로드
	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void detail() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
}
class 답변게시판 extends Board{
//	public void write() {} //글쓰기
//	public void list() {} //목록, 답변을 출력
//	public void detail() {} // 상세보기
//	public void update() {} // 수정
//	public void delete() {} // 삭제
//	public void find() {} // 찾기
	public void reply() {} // 답변

@Override
public void write() {
	// TODO Auto-generated method stub
	
}

@Override
public void list() {
	// TODO Auto-generated method stub
	
}

@Override
public void detail() {
	// TODO Auto-generated method stub
	
}

@Override
public void delete() {
	// TODO Auto-generated method stub
	
}
}
class 댓글게시판 extends Board{
//	public void write() {} //글쓰기
//	public void list() {} //목록
//	public void detail() {} // 상세보기, 댓글
//	public void update() {} // 수정
//	public void delete() {} // 삭제
//	public void find() {} // 찾기
	public void replyWrite() {} // 댓글 쓰기
	public void replayDelete() {} // 댓글 삭제
	public void replyUpdate() {} // 댓글 업데이트
	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void detail() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
}
public class MainClass3 {

	public static void main(String[] args) {

	}

}
