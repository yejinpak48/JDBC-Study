package book.model.service;

//import common.JDBCTemplate;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.dao.BookDao;
import book.model.vo.Book;

//Service : 1. 컨트롤러로부터 매개변수로 정보를 전달받는다.
//			2. Connection 객체를 생성한다.
//          3. 생성한 Connection객체와 전달받은 매개변수를
//             Dao로 전달한다.
//          4. 수행 결과에 따른 트랜젝션 처리를 한다.
public class BookService {
	
	//신규 도서 등록용 메소드
	public int insertBook(Book inputBook) {
		Connection con = /*JDBCTemplate.*/getConnection();
		
		BookDao bd = new BookDao();
		
		int result = bd.insertBook(con, inputBook);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	//아이디로 도서 검색용 메소드
	public Book selectBook(int bid) {
		Connection con = getConnection();
		
		BookDao bd = new BookDao();
		
		Book b = bd.selectBook(con, bid);
		
		close(con);
				
		return b;
	}
	//도서명으로 도서 검색용 메소드
	public ArrayList<Book> searchBookTitle(String title) {
		Connection con = getConnection();
		BookDao bd = new BookDao();
		
		ArrayList<Book> list = bd.searchBookTitle(con, title);
		
		close(con);
		
		return list;
	}
	


}


















