package com.sist.string;

public class MainClass5 {

	public static void main(String[] args) {

		String msg2 = " <title>명예훼손 없이 <b>리뷰</b>쓰기</title>\r\n"
				+ "<link>http://openapi.naver.com/l?AAABWLyw6CMBREv+ayNJe2UrrogvJwg8aYKGvACiSUalNR/t6azGLO5Mzrrd0moVSQJZDl/6I4KIxGpx9y9P4JNANShXSzHXZLu2q3660Jw2bt0k1+aF1rgFYXfZ+c7j3QorYDkCT4JxuIEEyRUYGcxpGXMeMs3VPBOUEWGXntynUW03k7ohBYfG+mOdRqbPL6E84/apnqgaEAAAA=</link>\r\n"
				+ "<description>명예훼손 없이 <b>리뷰</b>쓰기 우리 블로그하시는 분들께는 꽤 중요한 내용일 수도 있습니다 그것도 주로 <b>리뷰</b> 위주로 블로그를 진행하신 분이라면 더욱 더 말이죠\r\n"
				+ "오늘 포스팅은, 어떻게 하면 객관적이고 좋은 <b>리뷰</b>를... </description>\r\n"
				+ "<bloggername>건짱의 Best Drawing World2</bloggername>\r\n"
				+ "<bloggerlink>http://blog.naver.com/yoonbitgaram</bloggerlink>\r\n"
				+ "<postdate>20161208</postdate>";
		
		msg2 = msg2.replaceAll("[^가-힣]", "");
		System.out.println(msg2);

	}

}
