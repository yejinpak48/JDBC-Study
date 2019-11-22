package book.model.vo;

public class Book implements java.io.Serializable{
	private int bid;			//도서아이디
	private String title;		//도서명
	private String author;		//작가명
	private String pub;			//출판사명
	private String pubDate;		//출판일
	private int price;			//가격
	
	public Book() {}

	public Book(String title, String author, String pub, String pubDate, int price) {
		super();
		this.title = title;
		this.author = author;
		this.pub = pub;
		this.pubDate = pubDate;
		this.price = price;
	}

	public Book(int bid, String title, String author, String pub, String pubDate, int price) {
		super();
		this.bid = bid;
		this.title = title;
		this.author = author;
		this.pub = pub;
		this.pubDate = pubDate;
		this.price = price;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", author=" + author + ", pub=" + pub + ", pubDate=" + pubDate
				+ ", price=" + price + "]";
	}
	
	
}

