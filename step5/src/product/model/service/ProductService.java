package product.model.service;

import java.sql.*;
import java.util.*;

import static common.JDBCTemplet.*;

import product.model.dao.ProductDao;
import product.model.vo.Product;

public class ProductService {
	//상품 전체 조회용 메소드
	public ArrayList<Product> selectAll() {
		
		return null;
	}
	//상품 등록용 메소드
	public int insertRow(Product pro) {
		
		return 0;
	}
	//상품 정보 수정용 메소드
	public int updateRow(String pId, int price) {
		
		return 0;
	}
	//상품 삭제용 메소드
	public int deleteRow(String pId) {
		
		return 0;
	}
	//아이디로 상품 검색용 메소드
	public Product selectRow(String pId) {
		
		return null;
	}
	//이름으로 상품 검색용 메소드
	public ArrayList<Product> selectName(String pName) {
		
		return null;
	}

}
