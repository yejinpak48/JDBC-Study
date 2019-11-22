package product.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import static common.JDBCTemplet.*;
import product.model.vo.Product;

public class ProductDao {
	private Properties prop;
	
	//기본 생성자를 통해 prop 객체 초기화
	public ProductDao(){
		prop = new Properties();
		try {
			prop.load(new FileReader("query.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//상품 전체 목록 조회용 메소드
	public ArrayList<Product> selectAll(Connection con) {
		
		return null;
	}
	//상품 정보 입력용 메소드
	public int insertRow(Connection con, Product p) {
		
		return 0;
	}
	//상품 정보 수정용 메소드
	public int updateRow(Connection con, String pId, int price) {
		
		return 0;
	}
	//상품 정보 삭제용 메소드
	public int deleteRow(Connection con, String pId) {
		
		return 0;
	}
	//아이디로 조회용 메소드
	public Product selectRow(Connection con, String pId) {
		
		return null;
	}
	//이름으로 목록 조회용 메소드
	public ArrayList<Product> selectName(Connection con, String pName) {
		
		return null;
	}

}
