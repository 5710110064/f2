import java.util.ArrayList;
public class Auction{
	private ArrayList<Lot> lots;

	public Auction(){
		lots = new ArrayList<Lot> ();
	}

	public void bidFor(int lot, String name, int bids){
		for(Lot lt: lots){
			if(lt.getIdNum() == lot && bids > lt.getHighestBid()){
				lt.bidFor(name, bids);
				System.out.println("The bid for lot number " + lot + " was successful.");
			}
			else if(lt.getIdNum() == lot && bids < lt.getHighestBid()){
				System.out.println("Lot number: " + lot + " already has a bid of: " + lt.getHighestBid());
			}
		}
	}

	public void enterLot(int lotNum, String description){
		lots.add(new Lot(lotNum, description));
	}

	public void showLots(){
		for(Lot lot: lots)
			System.out.println(lot.toString());
	}

	public Lot getLot(int lotNum){
		for(Lot lot: lots)
			if(lot.getIdNum() == lotNum)
				return lot;
			System.out.println("Lot number: " + lotNum + " does not exist.");
			
			return null;
	}
}