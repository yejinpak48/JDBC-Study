package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.Employee;

//DAO : Data(base) Access Object
//DB에 접속해서 CRUD를 수행하는 메소드들의 집합인 클래스를 말한다.
//C(Create) : insert
//R(Read) : select
//U(Update) : update
//D(Delete) : delete
public class JDBCModel {
	
	//EMP 테이블의 모든 정보를 조회할 목적의 메소드(selectAll)
	public void testJDBC() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			//1. 해당 데이터베이스에 대한 라이브러리 등록 작업
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 데이터베이스와 연결함 (Connection 객체 생성)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", 
													"scott", 
													"tiger");
			
			System.out.println("conn : " + conn);
			
			//3. 쿼리문을 가지고 DB에서 쿼리문 실행
			// => 실행 결과를 ResultSet으로 받아옴
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
				//4. DB와 관련된 객체는 반드시 close 해야 함
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	//사번을 전달 받아 직원 정보 조회하는 메소드
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
			//객체 생성 후 쿼리 완성
			//객체명.set자료형(?-순번, 적용할 값);
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
	//사원 한 명의 정보를 전달 받아 emp 테이블에 insert하는 메소드
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
				System.out.println(result + "개의 행이 추가되었습니다.");
				conn.commit();
			}else {
				System.out.println("행 추가 실패!");
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
























