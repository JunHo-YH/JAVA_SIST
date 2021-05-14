package com.sist.manager;
/*
 *    jaxb
 *    jaxp => dom(수정,삭제,추가) , sax (스프링,마이바티스)
 *   <rss>  ========== class Rss
 *     <channel> ===== class Channel
 *       <item>  ===== class Item
 *        <title>값</title>  ==> String title
 *       </item>
 *     </channel>
 *   </rss>
 *   
 *   <table>  class Table
 *     <tr>   class Tr 
 *       <td>값<td> => String td
 *     </tr>
 *   </table>
 */
public class Item {
    private String title;
    private String description;
    private String author;
    private String link;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
   
}

















