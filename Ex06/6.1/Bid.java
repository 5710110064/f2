public class Bid{
	private String bidderName;
	private int value;

	public Bid(String name, int val){
		bidderName = name;
		value = val;
	}

	public String getBidderName(){
		return bidderName;
	}

	public int getValue(){
		return value;
	}
}