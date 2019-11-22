package book.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import book.model.vo.Book;

//DAO(Data Access Object) : CRUD ������
public class BookDao {

	public int insertBook(Connection con, Book inputBook) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		//String query = "INSERT INTO BOOK VALUES(SEQ.NEXTVAL, ?, ?, ?, TO_DATE(?, 'RRRR/MM/DD'), ?)";
		
		try {
			Properties prop = new Properties();
			
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("insertBook");
			
			System.out.println("query : " + query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, inputBook.getTitle());
			pstmt.setString(2, inputBook.getAuthor());
			pstmt.setString(3, inputBook.getPub());
			pstmt.setString(4, inputBook.getPubDate());
			pstmt.setInt(5, inputBook.getPrice());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		return result;
	}
	//���̵�� ���� ���� select�� �޼ҵ�
	public Book selectBook(Connection con, int bid) {
		Book b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM BOOK WHERE BOOK_ID = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Book();
				
				b.setBid(rset.getInt("BOOK_ID"));
				b.setTitle(rset.getString("TITLE"));
				b.setAuthor(rset.getString("AUTHOR"));
				b.setPub(rset.getString("PUBLISHER"));
				b.setPubDate(rset.getString("PUBLISHER_DATE"));
				b.setPrice(rset.getInt("PRICE"));
				
			}
			
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return b;
	}
	//���������� ���� ���� ����Ʈ select�� �޼ҵ�
	public ArrayList<Book> searchBookTitle(Connection con, String title) {
		ArrayList<Book> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM BOOK WHERE TITLE LIKE '%'||?||'%'";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			
			rset = pstmt.executeQuery();
			
			if(rset != null) {
				list = new ArrayList<Book>();
				
				while(rset.next()) {
					Book b = new Book();
					
					b.setBid(rset.getInt("BOOK_ID"));
					b.setTitle(rset.getString("TITLE"));
					b.setAuthor(rset.getString("AUTHOR"));
					b.setPub(rset.getString("PUBLISHER"));
					b.setPubDate(rset.getString("PUBLISHER_DATE"));
					b.setPrice(rset.getInt("PRICE"));
					
					list.add(b);
				}
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}


















