package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.Employee;

//DAO : Data(base) Access Object
//DB�� �����ؼ� CRUD�� �����ϴ� �޼ҵ���� ������ Ŭ������ ���Ѵ�.
//C(Create) : insert
//R(Read) : select
//U(Update) : update
//D(Delete) : delete
public class JDBCModel {
	
	//EMP ���̺��� ��� ������ ��ȸ�� ������ �޼ҵ�(selectAll)
	public void testJDBC() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			//1. �ش� �����ͺ��̽��� ���� ���̺귯�� ��� �۾�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. �����ͺ��̽��� ������ (Connection ��ü ����)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", 
													"scott", 
													"tiger");
			
			System.out.println("conn : " + conn);
			
			//3. �������� ������ DB���� ������ ����
			// => ���� ����� ResultSet���� �޾ƿ�
			String query = "SELECT * FROM EMP";
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				System.out.println(rset.getInt("EMPNO") + ", "
								 + rset.getString("ENAME") + ", "
								 + rset.getString("JOB") + ", "
								 + rset.getInt("MGR") + ", "
								 + rset.getDate("HIREDATE") + ", "
								 + rset.getInt("SAL") + ", "
								 + rset.getInt("COMM") + ", "
								 + rset.getInt("DEPTNO"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//4. DB�� ���õ� ��ü�� �ݵ�� close �ؾ� ��
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	//����� ���� �޾� ���� ���� ��ȸ�ϴ� �޼ҵ�
	public void testJDBC2(int empNo) {
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
												"scott", "tiger");
			
			
			/*String query = "SELECT * FROM EMP WHERE EMPNO = " + empNo;
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);*/
			
			String query = "SELECT * FROM EMP WHERE EMPNO = ?";
			
			pstmt = conn.prepareStatement(query);
			//��ü ���� �� ���� �ϼ�
			//��ü��.set�ڷ���(?-����, ������ ��);
			pstmt.setInt(1, empNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println(rset.getInt("EMPNO") + ", "
								+ rset.getString("ENAME") + ", "
								+ rset.getString("JOB") + ", "
								+ rset.getInt("MGR") + ", "
								+ rset.getDate("HIREDATE") + ", "
								+ rset.getInt("SAL") + ", "
								+ rset.getInt("COMM") + ", "
								+ rset.getInt("DEPTNO"));
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				//stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	//��� �� ���� ������ ���� �޾� emp ���̺� insert�ϴ� �޼ҵ�
	public void testInsert(Employee emp) {
		Connection conn = null;
		Statement stmt = null;
		//PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
												"scott", "tiger");
		
			String query = "INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)"
						+ "VALUES(" + emp.getEmpNo() + ", '" + emp.getEmpName() 
									+ "', '" + emp.getJob() + "', " + emp.getMgr() 
									+ ", sysdate, " + emp.getSal() + ", "
									+ emp.getComm() + ", " + emp.getDeptNo() + ")";
			
			System.out.println(query);
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(query);
			
			/*String query = "INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)"
							+ "VALUES(?, ?, ?, ?, SYSDATE, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setInt(5, emp.getSal());
			pstmt.setInt(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptNo());
			
			result = pstmt.executeUpdate();*/
			
			
			if(result > 0) {
				System.out.println(result + "���� ���� �߰��Ǿ����ϴ�.");
				conn.commit();
			}else {
				System.out.println("�� �߰� ����!");
				conn.rollback();
			}
			
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				//pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
























