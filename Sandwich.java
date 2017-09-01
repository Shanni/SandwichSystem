import java.util.List;


public class Sandwich extends Item{
	
	Bread bread = null;
	Mainfilling mainfill = null;
	
	List<Option> options = null;
	final int MAX_OPTIONS = 5;
	
	public Sandwich(Bread b, Mainfilling m){
		bread = b;
		mainfill = m;
	}
	
	public enum Bread {
	    BRIOCHE, WHITE, ROLL, CLUB,
	    RYE, WRAP, CIABATTA
	}
	
	public enum Mainfilling {
		ROAST_BEEF, CORN_BEEF, CHICKEN_SALAD, 
		GRILLED_CHICKEN, EGG_SALAD, PASTRAMI, TURKEY
	}
	
	public enum Option {
		LETTUCE, TOMATO, SWISS_CHEESE, AMERICAN_CHEESE, ONION,
		MUSHROOM, OLIVE, AVOCADO
	}
	
	public boolean addOptions(Option opt){
		if(options.size() < MAX_OPTIONS){
			options.add(opt);
			return true;
		}
		return false;
	}
	
	public boolean removeOption(Option opt){
		int ind = options.indexOf(opt);
		if(ind != -1){
			options.remove(ind);
			return true;
		}
		return false;
	}
}
