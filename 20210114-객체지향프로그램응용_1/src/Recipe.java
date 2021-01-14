/*
 *  "no": 1,
	  "title": "삶은고사리조기찜 만드는법 ~",
	  "poster": "https://recipe1.ezmember.co.kr/cache/recipe/2020/12/14/340a26d592d68c43757cd03e79596e231_m.jpg",
	  "chef": "행복한미니미니맘",
	  "link": "/recipe/6948372",
	  "hit": "조회수 119"
	  
	  
	  캡슐화
	  =====
	  접근지정어
	  ***private: 자신의 클래스에서만 접근이 가능
	  ***default: 같은 패키지(폴더) 내에서만 접근이 가능
	  protected: private + default + 다른 패키지의 자손 클래스에서 접근 가능 
	  ***public: 모든 클래스에서 접근이 가능
 */
public class Recipe {
	private int no;
	private String title;
	private String poster;
	private String chef;
	private String link;
	private String hit;
}
