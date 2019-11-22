package book.view;

import java.util.ArrayList;
import java.util.Scanner;

import book.controller.BookController;
import book.model.vo.Book;

public class BookMenu {

	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		BookController bc = new BookController();
		
		do {
			System.out.println("*** ���� ���� ���α׷� ***\n");
			System.out.println("1. ���� �߰�");
			System.out.println("2. ���� ���� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. ���� ���̵�� ��ȸ");
			System.out.println("5. ���� �������� ��ȸ");
			System.out.println("6. ���� ��� ��ü ��ȸ");
			System.out.println("9. ������");
			System.out.print("��ȣ ���� : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 : bc.insertBook(inputBook()); break;
				//case 2 : bc.updateBook(inputBookId(), inputBook()); break;
				//case 3 : bc.deleteBook(inputBookId()); break;
				case 4 : bc.searchBook(inputBookId()); break;
				case 5 : bc.searchBookTitle(inputBookTitle()); break;
				//case 6 : bc.selectAll(); break;
				case 9 : return;
				default : System.out.println("��ȣ�� �߸� �����̽��ϴ�. �ٽ� �Է����ּ���"); break;
			}
						
		}while(true);
		
	}
	//���� ���� �Է¿� �޼ҵ�
	public Book inputBook() {
		Book b = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ : ");
		String title = sc.nextLine();
		System.out.print("���ڸ� : ");
		String author = sc.nextLine();
		System.out.print("���ǻ� : ");
		String pub = sc.nextLine();
		System.out.print("��������(19990101 �������� �Է�) : ");
		String pubDate = sc.nextLine();
		System.out.print("���� : ");
		int price = sc.nextInt();
		
		b = new Book(title, author, pub, pubDate, price);
		
		return b;
	}
	
	//���� ���̵� �Է¿� �޼ҵ�
	public int inputBookId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ��ȣ �Է� : ");
		int bid = sc.nextInt();
		
		return bid;
	}
	
	
	//���� ���� �Է¿� �޼ҵ�
	public String inputBookTitle() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�˻��� ������ �Է� : ");
		String title = sc.nextLine();
		
		return title;
	}
	

	
	//���� �޼��� ��¿� �޼ҵ�
	public void displayError(String string) {
		switch(string) {
			case "insert" : System.out.println("���� ���� �Է� ����!"); break;
			case "update" : System.out.println("���� ���� ���� ����!"); break;
			case "delete" : System.out.println("���� ���� ���� ����!"); break;
			default : System.out.println("�� �� ���� ���� �߻�"); break;
		}
		
	}
	//���� ���� ��¿� �޼ҵ�
	public void displayBook(Book b) {
		System.out.println(b);
		
	}
	//���� ���� ����Ʈ ��¿� �޼ҵ�
	public void displayBookList(ArrayList<Book> list) {
		for(Book b : list) {
			System.out.println(b);
		}
		
	}

}






















