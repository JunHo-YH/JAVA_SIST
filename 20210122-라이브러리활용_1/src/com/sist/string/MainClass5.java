package com.sist.string;

public class MainClass5 {

	public static void main(String[] args) {

		String msg2 = " <title>���Ѽ� ���� <b>����</b>����</title>\r\n"
				+ "<link>http://openapi.naver.com/l?AAABWLyw6CMBREv+ayNJe2UrrogvJwg8aYKGvACiSUalNR/t6azGLO5Mzrrd0moVSQJZDl/6I4KIxGpx9y9P4JNANShXSzHXZLu2q3660Jw2bt0k1+aF1rgFYXfZ+c7j3QorYDkCT4JxuIEEyRUYGcxpGXMeMs3VPBOUEWGXntynUW03k7ohBYfG+mOdRqbPL6E84/apnqgaEAAAA=</link>\r\n"
				+ "<description>���Ѽ� ���� <b>����</b>���� �츮 ��α��Ͻô� �е鲲�� �� �߿��� ������ ���� �ֽ��ϴ� �װ͵� �ַ� <b>����</b> ���ַ� ��α׸� �����Ͻ� ���̶�� ���� �� ������\r\n"
				+ "���� ��������, ��� �ϸ� �������̰� ���� <b>����</b>��... </description>\r\n"
				+ "<bloggername>��¯�� Best Drawing World2</bloggername>\r\n"
				+ "<bloggerlink>http://blog.naver.com/yoonbitgaram</bloggerlink>\r\n"
				+ "<postdate>20161208</postdate>";
		
		msg2 = msg2.replaceAll("[^��-�R]", "");
		System.out.println(msg2);

	}

}
