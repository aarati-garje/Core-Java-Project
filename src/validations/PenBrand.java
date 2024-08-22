package validations;

public enum PenBrand {
    CELLO(10), TRIMAX(50), PARKER(200), RAYNOLDS(20);
 
    private int price;

	private PenBrand(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	
	
}
