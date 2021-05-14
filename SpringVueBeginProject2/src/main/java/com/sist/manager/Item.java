package com.sist.manager;
/*
 *    jaxb
 *    jaxp => dom(����,����,�߰�) , sax (������,���̹�Ƽ��)
 *   <rss>  ========== class Rss
 *     <channel> ===== class Channel
 *       <item>  ===== class Item
 *        <title>��</title>  ==> String title
 *       </item>
 *     </channel>
 *   </rss>
 *   
 *   <table>  class Table
 *     <tr>   class Tr 
 *       <td>��<td> => String td
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

















