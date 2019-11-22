package controller;

import model.dao.JDBCModel;
import model.vo.Employee;

public class TestMain {

	public static void main(String[] args) {
		JDBCModel test = new JDBCModel();
		
		//EMP테이블 모든 행 조회
		//test.testJDBC();
		
		//사번을 전달하여 사원 한 명의 정보 조회
		//test.testJDBC2(7782);
		
		//객체 생성 후 삽입
		Employee emp = new Employee(7777, "JARON", "ANALYST", 9999, 12000, 99, 10);
		test.testInsert(emp);
		
		//객체 생성 후 업데이트 -> 사원 정보 수정
		//사번과 일치하는 사원의 직급, 급여, 커미션을 변경하시오
		//사번, 직급, 급여, 커미션
		//Employee e = new Employee(7777, "CHAIRMAN", 500000, 100000);
		//test.testUpdate(e);
		
		//업데이트 후 조회
		//test.testJDBC();
		
		//사번 전달 후 삭제
		//test.testDelete(7777);
		
		//삭제 후 전체 조회
		//test.testJDBC();
	}

}



















