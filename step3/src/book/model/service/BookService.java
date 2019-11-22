package book.model.service;

//import common.JDBCTemplate;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.dao.BookDao;
import book.model.vo.Book;

//Service : 1. ��Ʈ�ѷ��κ��� �Ű������� ������ ���޹޴´�.
//			2. Connection ��ü�� �����Ѵ�.
//          3. ������ Connection��ü�� ���޹��� �Ű�������
//             Dao�� �����Ѵ�.
//          4. ���� ����� ���� Ʈ������ ó���� �Ѵ�.
public class BookService {
	
	//�ű� ���� ��Ͽ� �޼ҵ�
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
	//���̵�� ���� �˻��� �޼ҵ�
	public Book selectBook(int bid) {
		Connection con = getConnection();
		
		BookDao bd = new BookDao();
		
		Book b = bd.selectBook(con, bid);
		
		close(con);
				
		return b;
	}
	//���������� ���� �˻��� �޼ҵ�
	public ArrayList<Book> searchBookTitle(String title) {
		Connection con = getConnection();
		BookDao bd = new BookDao();
		
		ArrayList<Book> list = bd.searchBookTitle(con, title);
		
		close(con);
		
		return list;
	}
	


}


















