package book.controller;

import java.util.ArrayList;

import book.model.service.BookService;
import book.model.vo.Book;
import book.view.BookMenu;

//Controller : 1. 요청받은 데이터를 검증하고 가공한다.
//             2. 서비스 클래스의 메소드에 인자로 값을 전달한다.
//             3. 리턴받은 결과를 통해 뷰 페이지를 선택해 값을 넘겨준다.
public class BookController {
	private BookMenu bm = new BookMenu();
	
	public void insertBook(Book inputBook) {
		BookService bs = new BookService();
		
		int result = bs.insertBook(inputBook);
		
		if(result > 0) {
			System.out.println("도서 정보 입력 완료!");
		}else {
			bm.displayError("insert");
		}
		
	}
	//도서 아이디로조회용 메소드
	public void searchBook(int bid) {
		BookService bs = new BookService();
		
		Book b = bs.selectBook(bid);
		
		if(b == null) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			bm.displayBook(b);
		}
		
	}
	//도서명으로 도서 검색용 메소드
	public void searchBookTitle(String title) {
		BookService bs = new BookService();
		
		ArrayList<Book> list = bs.searchBookTitle(title);
		
		if(list == null) {
			System.out.println("검색에 실패했습니다.");
		}else {
			bm.displayBookList(list);
		}
		
	}

}




















