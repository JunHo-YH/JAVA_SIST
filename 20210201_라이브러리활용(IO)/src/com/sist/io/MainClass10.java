package com.sist.io;

/*
 * 1|1|소울(2020)|8.6|애니메이션/판타지|2021.01.20 |107분|전체관람가|피트 닥터|켐프 파워스|//img1.daumcdn.net/thumb/C155x225/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F71454256ae63506a7fee5e03cf929b9b65a4f433|1|나는 어떻게 ‘나’로 태어나게 되었을까? 지구에 오기 전 영혼들이 머무는 ‘태어나기 전 세상’이 있다면? 뉴욕에서 음악 선생님으로 일하던 ‘조’는 꿈에 그리던 최고의 밴드와 재즈 클럽에서 연주하게 된 그 날, 예기치 못한 사고로 영혼이 되어 ‘태어나기 전 세상’에 떨어진다. 탄생 전 영혼들이 멘토와 함께 자신의 관심사를 발견하면 지구 통행증을 발급하는 ‘태어나기 전 세상’ ‘조’는 그 곳에서 유일하게 지구에 가고 싶어하지 않는 시니컬한 영혼 ‘22’의 멘토가 된다. 링컨, 간디, 테레사 수녀도 멘토되길 포기한 영혼 ‘22’ 꿈의 무대에 서려면 ‘22’의 지구 통행증이 필요한 ‘조’ 그는 다시 지구로 돌아가 꿈의 무대에 설 수 있을까?

 */
// 직렬화 => ObjectOutputStream
// 역직렬화 => ObjectInputStream
import java.io.*;
import java.util.*;

class Sawon implements Serializable {
	private int sabun;
	private String name;
	private String dept;
	private String loc;
	transient private int pay;

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public Sawon(int sabun, String name, String dept, String loc, int pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.loc = loc;
		this.pay = pay;
	}

}

public class MainClass10 {

	public static void main(String[] args) {
		try {

			ArrayList<Sawon> list = new ArrayList<Sawon>();
			list.add(new Sawon(1, "홍길동", "개발부", "서울", 3000));
			list.add(new Sawon(2, "심청이", "자재부", "부산", 3600));
			list.add(new Sawon(3, "김두환", "총무부", "경기", 3200));
			list.add(new Sawon(4, "강감찬", "기획부", "강원", 3300));
			list.add(new Sawon(5, "춘향이", "영업부", "제주", 3800));

			// 출력
			for (Sawon s : list) {
				System.out.println("이름:" + s.getName());
				System.out.println("부서:" + s.getDept());
				System.out.println("근무지:" + s.getLoc());
				System.out.println("연봉:" + s.getPay());
				System.out.println("----------------------");
			}
			File file = new File("c:\\download\\sawon.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// 객체 단위로 파일에 저장
			oos.writeObject(list);
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
