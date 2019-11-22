package book.controller;

import java.util.ArrayList;

import book.model.service.BookService;
import book.model.vo.Book;
import book.view.BookMenu;

//Controller : 1. ��û���� �����͸� �����ϰ� �����Ѵ�.
//             2. ���� Ŭ������ �޼ҵ忡 ���ڷ� ���� �����Ѵ�.
//             3. ���Ϲ��� ����� ���� �� �������� ������ ���� �Ѱ��ش�.
public class BookController {
	private BookMenu bm = new BookMenu();
	
	public void insertBook(Book inputBook) {
		BookService bs = new BookService();
		
		int result = bs.insertBook(inputBook);
		
		if(result > 0) {
			System.out.println("���� ���� �Է� �Ϸ�!");
		}else {
			bm.displayError("insert");
		}
		
	}
	//���� ���̵����ȸ�� �޼ҵ�
	public void searchBook(int bid) {
		BookService bs = new BookService();
		
		Book b = bs.selectBook(bid);
		
		if(b == null) {
			System.out.println("�˻� ����� �����ϴ�.");
		}else {
			bm.displayBook(b);
		}
		
	}
	//���������� ���� �˻��� �޼ҵ�
	public void searchBookTitle(String title) {
		BookService bs = new BookService();
		
		ArrayList<Book> list = bs.searchBookTitle(title);
		
		if(list == null) {
			System.out.println("�˻��� �����߽��ϴ�.");
		}else {
			bm.displayBookList(list);
		}
		
	}

}




















