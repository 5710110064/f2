import java.util.ArrayList;
public class Lot{
	private ArrayList<Bid> bids;
	private int idNum;
	private String description;
	private int highestBid;
	
	public Lot(int num, String descrip){
		bids = new ArrayList<Bid> ();
		idNum = num;
		description = descrip;
		highestBid = 0;
	}

	public void bidFor(String name, int value){
		bids.add(new Bid(name, value));
		for(Bid bd: bids){
			if(bd.getValue() > highestBid){
				highestBid = bd.getValue();
			}
			else{}
		}
	}

	public int getIdNum(){
		return idNum;
	}

	public String getDescription(){
		return description;
	}

	public int getHighestBid(){
		return highestBid;
	}

	public String toString(){
		String str = " ";
		if(bids.isEmpty()){
			str = getIdNum() + " : " + getDescription() + "    <No bid>"; 
		}
		else{
			for(Bid bid: bids){
				if(bid.getValue() == getHighestBid())
					str = getIdNum() + " : " + getDescription() + " Bid: " + getHighestBid() + " by " + bid.getBidderName();
			}
		}
		return str;
	}
}