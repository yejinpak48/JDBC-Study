package controller;

import model.dao.JDBCModel;
import model.vo.Employee;

public class TestMain {

	public static void main(String[] args) {
		JDBCModel test = new JDBCModel();
		
		//EMP���̺� ��� �� ��ȸ
		//test.testJDBC();
		
		//����� �����Ͽ� ��� �� ���� ���� ��ȸ
		//test.testJDBC2(7782);
		
		//��ü ���� �� ����
		Employee emp = new Employee(7777, "JARON", "ANALYST", 9999, 12000, 99, 10);
		test.testInsert(emp);
		
		//��ü ���� �� ������Ʈ -> ��� ���� ����
		//����� ��ġ�ϴ� ����� ����, �޿�, Ŀ�̼��� �����Ͻÿ�
		//���, ����, �޿�, Ŀ�̼�
		//Employee e = new Employee(7777, "CHAIRMAN", 500000, 100000);
		//test.testUpdate(e);
		
		//������Ʈ �� ��ȸ
		//test.testJDBC();
		
		//��� ���� �� ����
		//test.testDelete(7777);
		
		//���� �� ��ü ��ȸ
		//test.testJDBC();
	}

}



















