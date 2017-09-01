import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrderSystem {
	Map<Integer, Order> orders = null;
	int order_size = 0;
	
	public OrderSystem(){
		orders = new HashMap<>();
		order_size = 0;
	}
	
	public Order startNewOrder(){
		Order order = new Order(order_size);
		orders.put(order_size, order);
		order_size++;
		return order;
	}
	
	public boolean deleteOrder(int order_number){
		if(orders.containsKey(order_number)){
			orders.remove(order_number);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		System.out.println("Starting new order here...");
	}
}
