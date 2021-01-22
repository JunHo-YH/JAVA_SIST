package com.sist.string;

public class MainClass5 {

	public static void main(String[] args) {

		String msg2 = " <title>¸í¿¹ÈÑ¼Õ ¾øÀÌ <b>¸®ºä</b>¾²±â</title>\r\n"
				+ "<link>http://openapi.naver.com/l?AAABWLyw6CMBREv+ayNJe2UrrogvJwg8aYKGvACiSUalNR/t6azGLO5Mzrrd0moVSQJZDl/6I4KIxGpx9y9P4JNANShXSzHXZLu2q3660Jw2bt0k1+aF1rgFYXfZ+c7j3QorYDkCT4JxuIEEyRUYGcxpGXMeMs3VPBOUEWGXntynUW03k7ohBYfG+mOdRqbPL6E84/apnqgaEAAAA=</link>\r\n"
				+ "<description>¸í¿¹ÈÑ¼Õ ¾øÀÌ <b>¸®ºä</b>¾²±â ¿ì¸® ºí·Î±×ÇÏ½Ã´Â ºÐµé²²´Â ²Ï Áß¿äÇÑ ³»¿ëÀÏ ¼öµµ ÀÖ½À´Ï´Ù ±×°Íµµ ÁÖ·Î <b>¸®ºä</b> À§ÁÖ·Î ºí·Î±×¸¦ ÁøÇàÇÏ½Å ºÐÀÌ¶ó¸é ´õ¿í ´õ ¸»ÀÌÁÒ\r\n"
				+ "¿À´Ã Æ÷½ºÆÃÀº, ¾î¶»°Ô ÇÏ¸é °´°üÀûÀÌ°í ÁÁÀº <b>¸®ºä</b>¸¦... </description>\r\n"
				+ "<bloggername>°ÇÂ¯ÀÇ Best Drawing World2</bloggername>\r\n"
				+ "<bloggerlink>http://blog.naver.com/yoonbitgaram</bloggerlink>\r\n"
				+ "<postdate>20161208</postdate>";
		
		msg2 = msg2.replaceAll("[^°¡-ÆR]", "");
		System.out.println(msg2);

	}

}
