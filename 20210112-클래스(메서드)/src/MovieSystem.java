// ��û ó���� �ϴ� Ŭ����
public class MovieSystem {
	// ������÷��
	// ����, ����Ŭ�ȿ� �־�� �� ����
	static String[] title={
            "Your Lights",
			"�ܿ���",
			"�츰 ��¼�� ����� �ɱ�",
			"����",
			"VVS (Feat. JUSTHIS) (Prod. by GroovyRoom)",
			"Dynamite",
			"���ϴ��� ���� (2020)",
			"ù��� (Feat. SOLE (��))",
			"Life Goes On",
			"���� ���� �Ͼ��",
			"���� �ٲ��� (Duet With JYP)",
			"���� ���� �ʳ׿�",
			"What Do I Call You",
			"ON AIR (Feat. �β� & ����� & GRAY)",
			"������ �뷡",
			"�����̸� ��������",
			"���� �� ����� �ƴϴ�",
			"For You (Feat. Crush)",
			"Savage Love (Laxed - Siren Beat) (BTS Remix)",
			"��⸦ ���� (�������� �׳� X ���)",
			"HERO",
			"Lovesick Girls",
			"���θ� ���� ��",
			"���ѳ���",
			"������ ���� (Feat. �⸮���� & BIG Naughty (������))",
			"���� �͵��� ���� �� (Boy With Luv) (Feat. Halsey)",
			"���Ұ�",
			"CREDIT (Feat. ���� & �⸮���� & Zion.T)",
			"��� 60�� ��κ��̾߱�",
			"���� (Prod. ������)",
			"�ǿ� (Feat. ������ & ���̸� ���̴�) (Prod. by �ڵ� �ｺƮ)",
			"ȥ���ϰ� ���� ��",
			"��鸮�� �ɵ� �ӿ��� �� ��Ǫ���� �������ž�",
			"���õ� ������ �ʿ��� (To You My Light) (Feat.�̶��)",
			"������ �뷡",
			"��Ҽ�",
			"�׳��� ���� ���� ��������",
			"������ �� ����ؿ�",
			"�Ա�",
			"��� ��, ��� ���� (Every day, Every Moment)",
			"�ٷ�",
			"�� ������ �����ߴ� ���� (�������� �׳� X ����)",
			"�����㿡 �� ����",
			"���� ���� �Ͼ�� (Piano by ������)",
			"�Ѹ� (Feat. JUSTHIS) (Prod. by GroovyRoom)",
			"���� (Prod. & Feat. SUGA of BTS)",
			"�ƹ��� ����� ���� (Nessun Dorma)",
			"���� �� ���� �� �� ���濡��",
			"Achoo (Feat. pH-1 & HAON) (Prod. by GroovyRoom)",
			"Blueming"
	};
	static String[] singer={
                       "�̼� (�������ƽ�)",
                       "���ö",
                       "�㰢",
                       "�����",
                       "�̶��� (Mirani) & ��ġ�� & Khundi Panda & �ӽ����� (MUSHVENOM)",
                       "��ź�ҳ��",
                       "�漭",
                       "������",
                       "��ź�ҳ��",
                       "�ӿ���",
                       "��",
                       "�����",
                       "�¿� (TAEYEON)",
                       "������ (lIlBOI)",
                       "�ӿ���",
                       "Ȳ�ο�",
                       "��â��",
                       "������",
                        "Jawsh 685 & Jason Derulo & ��ź�ҳ��",
                        "���",
                        "�ӿ���",
                        "BLACKPINK",
                        "����",
                        "�̽±�",
                        "������ (lIlBOI)",
                        "��ź�ҳ��",
                        "�̽±�",
                        "������ (lIlBOI)",
                        "�ӿ���",
                        "��ȣ��",
                        "������ (Swings)",
                        "��",
                        "�����",
                        "��ũ�� (Maktub)",
                        "Standing Egg (���ĵ� ����)",
                        "��ȣ��",
                        "�̿���","��ȣ��","10CM","��Ŵ","�ӿ���","���� (KYUHYUN)","�ܳ���","�ӿ���",
                        "Khundi Panda","������ (IU)","��ȣ��","����","�̶��� (Mirani)","������ (IU)"
	};
	static String[] album={
                       "Your Lights (����ũ ������ OST Part.1)","�ܿ���","Hello","����",
                       "��̴��Ӵ� 9 Episode 1","Dynamite (DayTime Ver.)","���ϴ��� ���� (2020)",
                       "ù���","BE","������ �̽���Ʈ�� ����� Ư����","���� �ٲ���","���� ���� �ʳ׿�",
                       "What Do I Call You - The 4th Mini Album","��̴��Ӵ� 9 Final",
                       "����� �ݼ�Ÿ Part19","�����̸� ��������","���� �� ����� �ƴϴ�",
                       "For You","Savage Love (Laxed - Siren Beat) (BTS Remix)",
                       "��⸦ ���� (�������� �׳� X ���)","HERO","THE ALBUM",
                       "���θ� ���� ��","���ѳ���","��̴��Ӵ� 9 Episode 3","MAP OF THE SOUL : PERSONA",
                       "The Project","��̴��Ӵ� 9 Final","������ �̽���Ʈ�� Ʈ�� ���̵� ����Ʈ",
                       "�츮ʫ","��̴��Ӵ� 9 Semi Final","ȥ���ϰ� ���� ��","��ΰ� ü�� OST Part 3 (JTBC ���� ���)",
                       "Red Moon : To You My Light","������ �뷡","��Ҽ�","�׳��� ���� ���� ��������",
                       "������ �� ����ؿ�","5.1",
                       "'Ű�� ���� �ұ��?' OST Part. 3 (SBS ��ȭ���)","������ �̽���Ʈ�� ������ ����Ʈ",
                       "�� ������ �����ߴ� ���� (�������� �׳� X ����)","�ܳ��� �Ұ��� l","���� ���� �Ͼ��",
                       "��̴��Ӵ� 9 Episode 3","����","The Classic Album","���� �� ���� �� �� ���濡��",
                       "��̴��Ӵ� 9 Episode 3","Love poem"
	};

	static String[] state={
                     "����","����","����","����","����",
                     "����","����","����","���","���",
                     "�ϰ�","�ϰ�","���","���","���",
                     "���","���","���","�ϰ�","�ϰ�",
                     "���","���","���","���","���",
                     "���","���","���","�ϰ�","�ϰ�",
                     "���","���","���","���","���",
                     "���","���","���","���","���",
                     "�ϰ�","�ϰ�","���","���","���",
                     "���","���","���","���","���",
                     "���","���","���","���","���",
                     "���","�ϰ�","�ϰ�","�ϰ�","�ϰ�",
                     "���","���","���","���","���",
                     "���","���","���","���","���",
                     "�ϰ�","�ϰ�","���","���","�ϰ�",
                     "�ϰ�","���","���","���","���",
                     "�ϰ�","�ϰ�","���","���","���",
                     "���","�ϰ�","�ϰ�","���","���",
                     "���","���","�ϰ�","�ϰ�","���",
                     "���","���","���","���","���"
	};

	static int[] modify={
                 0,0,0,0,0,
                 0,0,0,2,2,
                1,1,7,7,2,
                 2,3,3,4,4,
                26,26,20,20,8,
                8,32,32,7,7,
                20,20,23,23,23,
               23,16,16,28,28,
              12,12,30,30,30,
              30,48,48,34,34,
              12,12,18,18,14,
              14,16,16,19,19,
              39,39,7,7,27,
              27,61,61,31,31,
              21,21,26,26,21,
              21,23,23,27,27,
              25,25,5,5,44,
              44,26,26,6,6,
             9,9,28,28,38,
             38,7,7,15,15
	};
	// ���ó�� => �޼���
	// ��ü ��� ���
	Movie[] movieAllData() {      // Movie[] m = {new Movie() ... 50��}
		Movie[] m = new Movie[50];
			for (int i = 0; i < 50; i++) {
				m[i] = new Movie();
				m[i].title = title[i];
				m[i].singer = singer[i];
				m[i].album = album[i];
				m[i].state = state[i];
				m[i].modify = modify[i];
			
			
			
			}
		return m;
	}
	// ����� �˻�
	Movie[] movieFindData(String ss) {
		int count = 0;
		for (String s : title) {
			if (s.contains(ss)) {
				count++; // �迭 ���� ī��Ʈ
			}
		}
		// �迭 �ʱ�ȭ
		Movie[] m = new Movie[count];
		int i = 0;
		for (int j = 0; j < 50; j++) {
			if(title[j].contains(ss)) {
				m[i] = new Movie();
				m[i].title = title[j];
				m[i].singer = singer[j];
				m[i].album = album[j];
				i++;
			}
		}
		
		
		return m;
	}
	// ���������� �뷡 ã��
	String[] singerFindData(String sing) {
		
		int count = 0;
		for (String s : singer) {
			if (s.contains(sing)) {
				count++; // �迭�� ���� Ȯ��
			}
		}
		String[] s = new String[count];
		int j = 0;
		for (int i = 0; i < 50; i++) {
			if (singer[i].startsWith(sing)) {
				s[j] = title[i];
				j++;
			}
		}
		return s;
		
	}	
		// �󼼺���
		// �迭�� 0���� ����
		Movie movieDetailData(int no) {
			Movie m = new Movie();
			m.title = title[no-1];
			m.singer = singer[no-1];
			m.album = album[no-1];
			m.state = state[no-1];
			m.modify = modify[no-1];
			
			return m;
		}
		
		
	
	
}


