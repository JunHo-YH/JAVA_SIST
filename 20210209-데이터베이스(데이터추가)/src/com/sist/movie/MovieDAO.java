package com.sist.movie;

// ����Ŭ ���� 
import java.sql.*;

public class MovieDAO {
	private Connection conn;// ����Ŭ ����
	private PreparedStatement ps;// SQL������ ����
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// jdbc:��ü��:IP:PORT:�����ͺ��̽���
	// thin����̹� => ���� (����Ŭ <==> �ڹ��������α׷�) => �ӵ��� �ʴ� , ����
	// ����̹� ��� => �ѹ��� ����
	public MovieDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ����Ŭ�ϰ� ������ �� �ְ� ����̹� ��ġ (����Ʈ����)
			// ���÷��� => Ŭ���� ������ �о �޸� �Ҵ� => Properties�� �̿��ϴ� ���
		} catch (Exception ex) {
		}
	}

	// ����Ŭ ����
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy"); // ���� => ����Ŭ URL , username , password
			// conn hr/happy => ����Ŭ �Ѿ��
		} catch (Exception ex) {
		}
	}

	// ����Ŭ �ݱ�
	public void disConnection() {
		try {
			if (ps != null)
				ps.close(); // OutputStream / BufferedReader => Statement
			if (conn != null)
				conn.close(); // Socket => TCP
			// exit
		} catch (Exception ex) {
		}
	}

	// ��� (������ �߰�)
	/*
	 * MNO NUMBER(4) TITLE VARCHAR2(100) GENRE VARCHAR2(100) POSTER VARCHAR2(200)
	 * ACTOR VARCHAR2(300) REGDATE VARCHAR2(100) GRADE VARCHAR2(50) DIRECTOR
	 * VARCHAR2(50)
	 */
	// ���
	public void movieInsert(MovieVO vo) {
		try {
			/*
			 * SELECT : ������ �˻� INSERT : ������ �߰� UPDATE : ������ ���� DELETE : ������ ���� ==> CURD =>
			 * ������ ���� ����Ŭ ���� => �������� ���� ��ġ , ��� ������ �� �ִ� ������
			 */
			getConnection();
			String sql = "INSERT INTO movie VALUES(?,?,?,?,?,?,?,?)"; // ����Ŭ�� ������ �߰� ��ɾ�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getMno()); // TO_NUMBER()
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getGenre());
			ps.setString(4, vo.getPoster());
			ps.setString(5, vo.getActor());
			ps.setString(6, vo.getRegdate());
			ps.setString(7, vo.getGrade());
			ps.setString(8, vo.getDirector());

			// ����
			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
	}
}
