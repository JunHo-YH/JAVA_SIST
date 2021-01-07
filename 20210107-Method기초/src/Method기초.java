
//		String find(String title);
/*
 * ���̺귯������ �����ϴ� �޼������ Ű���尡 �ƴϴ�.
 * ������: 
 * �Ű�����:
 * ======================= �⺻�������� + ������������(�迭,Ŭ����(String)) 
 * �޼��� ����� ����: �и� => �ҽ��� ������ ó�� (���õ� ������ ��Ƽ� �����): ������, ����, ���������� �����ϴ�.
 * 
 *  �޼��尡 ����� �� return�� ���
 *  void => return�� ������ �� �ִ�.
 *  
 *  https://www.genie.co.kr/chart/top200
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Method���� {
	static void genie() {
		try {
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			Elements title = doc.select("td.info a.title");
			for (int i = 0; i < title.size(); i++) {
				System.out.println(title.get(i).text());
			}
		} catch (Exception ex) {
		}
	}

	public static void main(String[] args) {
		genie();
	}

}
