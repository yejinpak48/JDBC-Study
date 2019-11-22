package product.controller;

import java.util.*;

import javax.swing.JOptionPane;

import product.model.service.ProductService;
import product.model.vo.Product;
import product.views.ErrorDialog;

public class ProductController {
	private ErrorDialog error = new ErrorDialog();

	public ArrayList<Product> selectList() {
		ProductService ps = new ProductService();
		ArrayList<Product> list = new ArrayList<Product>();
		list = ps.selectAll();
		
		return list;
	}

	public int insertRow(Product pro) {
		ProductService ps = new ProductService();
		
		int result = ps.insertRow(pro);
		
		if(result > 0){
			error.errorMessage(result + "개의 상품이 추가되었습니다.");
		}else{
			error.errorMessage("상품 추가 실패!");
		}
		
		return result;
		
	}

	public int updateRow(String pId, int price) {
		ProductService ps = new ProductService();
		int result = ps.updateRow(pId, price);
		
		if(result > 0){
			error.errorMessage(result + "개의 상품이 수정되었습니다.");
		}else{
			error.errorMessage("상품 수정 실패!");
		}
		
		return result;
		
	}

	public int deleteRow(String pId) {
		ProductService ps = new ProductService();
		int result = ps.deleteRow(pId);
		
		if(result > 0){
			error.errorMessage(result + "개의 상품이 삭제되었습니다.");
		}else{
			error.errorMessage("상품 삭제 실패!");
		}
		
		return result;
		
	}

	public Product selectId(String pId) {
		ProductService ps = new ProductService();
		
		Product pro = ps.selectRow(pId);
		
		if(pro == null){
			error.errorMessage("검색한 상품이 존재하지 않습니다.");
		}
		
		return pro;
	}

	public ArrayList<Product> selectName(String pName) {
		ProductService ps = new ProductService();
		ArrayList<Product> list = ps.selectName(pName);
		
		if(list.size() == 0){
			error.errorMessage("검색한 상품이 존재하지 않습니다.");
		}
		
		return list;
	}

}
