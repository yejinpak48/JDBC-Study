package model.vo;

import java.sql.Date;

//vo(value object) == dto(data transfer object)
//do(domain object) == entity == record == row
//DB���̺��� �� ���� ������ ��ϵǴ� ����� ��ü

//voŬ������ �Ǳ� ���� ����
//1. �ݵ�� ĸ��ȭ�� ������ �� : private
//2. ����ʵ忡 ���� getter�� setter �ۼ��� ��
//3. �⺻ �����ڿ� �Ű����� �ִ� ������ �ۼ�
//4. ����ȭó��
public class Employee implements java.io.Serializable{
	private int empNo;
	private String empName;
	private String job;
	private int mgr;
	private Date hireDate;
	private int sal;
	private int comm;
	private int deptNo;
	
	public Employee() {}

	public Employee(int empNo, String empName, String job, int mgr, Date hireDate, int sal, int comm, int deptNo) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.deptNo = deptNo;
	}

	public Employee(int empNo, String empName, String job, int mgr, int sal, int comm, int deptNo) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.deptNo = deptNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", job=" + job + ", mgr=" + mgr + ", hireDate="
				+ hireDate + ", sal=" + sal + ", comm=" + comm + ", deptNo=" + deptNo + "]";
	}
	
	
	
	
}














