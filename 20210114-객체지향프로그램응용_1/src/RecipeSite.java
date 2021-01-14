
// ���� �б� => recipe.jason
import java.io.*; // io�� ���� �����, �޸� �����, ��Ʈ��ũ ����½� ����Ѵ�.

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 * 1. �䱸���� �м�
 * 2. ���α׷��� �����ϱ� ���� ���� �߻��� ���� ������ �ؾ��Ѵ�.
 */

public class RecipeSite {
	public Recipe[] recipeAllData() { // �޼���� public���� �ַ� ����Ѵ�. // �ν��Ͻ��޼���

		Recipe[] recipe = new Recipe[146854];
		StringBuffer data = new StringBuffer();

		// IO => ����ó��
		try {
			// ������๮��
			// ������ �о ���ڿ��� ����
			FileReader fr = new FileReader("c:\\javaDev\\recipe.json");
			int i = 0; // ���� => 1���ڸ� �д´� => ���ڹ�ȣ

			while ((i = fr.read()) != -1) {// -1�� ������ �� (EOF, BOF
				data.append(String.valueOf((char) i));
			}
			fr.close();

			String json = data.toString();

			JSONParser parser = new JSONParser();
			JSONObject re = (JSONObject) parser.parse(json);
			JSONArray arr = (JSONArray)re.get("recipe");
			System.out.println("arr=" + arr);
			System.out.println(arr.size());
			for (i = 0; i < arr.size(); i++) {
				
				/*
				 *  "no": 146854,
					  "title": "��Ŀ��... �Ѱ� ������ ��θ� ���� �ٳ��� ���ڷ�Ĩ ����",
					  "poster": "https://recipe1.ezmember.co.kr/cache/recipe/2015/06/09/340ad2b10d86eb75698a1f7f6637545a_m.jpg",
					  "chef": "June",
					  "link": "/recipe/340368",
					  "hit": "��ȸ�� 1,647"
				 */
				JSONObject obj = (JSONObject) arr.get(i);
				recipe[i] = new Recipe();
				
				long a = (long)obj.get("no");
				recipe[i].setNo((int)a);
				recipe[i].setTitle((String)obj.get("title"));
				// 1. Ŭ���� ����ȯ, ����ó��, ���̺귯��(����ȭ)
				recipe[i].setChef((String)obj.get("chef"));
				recipe[i].setPoster((String)obj.get("poster"));
				recipe[i].setLink((String)obj.get("link"));// setxxx() ����: �޸𸮿� ����
				
				
			}
		} catch (Exception ex) {
			// ������ �� ��츦 ����ϴ� ���α׷�
		}
		return recipe;
	}

	public static void main(String[] args) {
		RecipeSite rs = new RecipeSite(); // recipeAllData�� �����Ѵ�.
		Recipe[] recipe = rs.recipeAllData();
		System.out.println("========== ������ ��� ==========");
		for (Recipe r : recipe) {
			System.out.println("��ȣ: " + r.getNo());// getXxx() �б�: �޸𸮿��� ���� �о�� �� 
													// �޼��带 �̿��ؼ� ���
			System.out.println("����: " + r.getTitle());
			System.out.println("����: " + r.getChef());
			System.out.println(r.getHit());
			System.out.println("===============================");
			
		}

	}


}
