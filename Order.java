import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Order {
	int order_number = -1;

	// list of items in order
	List<Item> items = null;
	// maximum number of items in each order
	final int MAX_ITEMS = 20;
	
	double total_price = -1;
	final double COMBO_DISCOUNT = 0.8;

	public Order(int o){
		order_number = o;
		items = new ArrayList<>();
	}
	
	public boolean addToOrder(Item it){
		if(items.size() >= MAX_ITEMS)
			return false;
		
		items.add(it);
		return true;
	}
	
	public boolean removeFromOrder(Item it){
		int ind = items.indexOf(it);
		if(ind == -1)
			return false;
		
		items.remove(ind);
		return true;
	}
	
	// determine if order has a combo and return the combo
	public Set<Item> hasCombo(){
		boolean hasSandwich = false, hasChips = false, hasDrink = false;
		Set<Item> combo = new HashSet<>();
		for(Item it: items){
			if(it instanceof Chips && !hasChips){
				combo.add(it);
				hasChips = true;
			}
			if(it instanceof Drink && !hasDrink){
				combo.add(it);
				hasDrink = true;
			}
			if(it instanceof Sandwich && !hasSandwich){
				combo.add(it);
				hasSandwich = true;
			}
		}
		return hasSandwich && hasChips && hasDrink ? combo: null;
	}
	
	// calculate combo price separately, adding up price of each item
	public double getTotalPrice(){
		total_price = 0;
		
		Set<Item> combo = hasCombo();
		if(combo != null){
			for(Item it: combo){
				total_price += it.getPrice() * COMBO_DISCOUNT;
			}
		}
		for(Item it: items){
			if(combo == null || !combo.contains(it))
				total_price += it.getPrice();
		}
		return total_price;
	}
	
	public int getOrderNumber() {
		return order_number;
	}

}
