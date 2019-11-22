package product.model.vo;

public class Product implements java.io.Serializable{
	private String pId;
	private String pName;
	private int price;
	private String desc;
	
	public Product(){}

	public Product(String pId, String pName, int price, String desc) {
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.desc = desc;
	}

	public String getpId() {
		return pId;
	}

	public String getpName() {
		return pName;
	}

	public int getPrice() {
		return price;
	}

	public String getDesc() {
		return desc;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString(){
		return pId + ", " + pName + ", " + price + ", " + desc;
	}
	
}
