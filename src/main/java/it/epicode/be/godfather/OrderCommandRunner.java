package it.epicode.be.godfather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.epicode.be.godfather.model.DrinkLemonade;
import it.epicode.be.godfather.model.Menu;
import it.epicode.be.godfather.model.MenuItem;
import it.epicode.be.godfather.model.Order;
import it.epicode.be.godfather.model.OrderItem;
import it.epicode.be.godfather.model.PizzaMargherita;
import it.epicode.be.godfather.model.PizzaTopping;
import it.epicode.be.godfather.model.ToppingCheese;

@Component
public class OrderCommandRunner {

	private static final Logger logger = LoggerFactory.getLogger(OrderCommandRunner.class);

	@Autowired
	private Menu menu;

	public void run() {
		// Create an order
		Order order = new Order(1, "in corso", 4, java.time.LocalDateTime.now());

		// Add items to the order
		PizzaMargherita pizza = new PizzaMargherita();
		PizzaTopping toppingCheese = new ToppingCheese(pizza);
		DrinkLemonade lemonade = new DrinkLemonade();

		order.getItems().add(pizza);
		order.getItems().add(toppingCheese);
		order.getItems().add(lemonade);

		// Calculate the total amount
		double totalAmount = order.getItems().stream().mapToDouble(MenuItem::getPrice).sum();
		totalAmount += menu.getCoverCharge() * order.getNumberOfSeats();
		order.getItems().add(new OrderItem("Cover Charge", menu.getCoverCharge(), 1));

		// Print the order details
		logger.info("Order Number: " + order.getOrderNumber());
		logger.info("Status: " + order.getStatus());
		logger.info("Number of Seats: " + order.getNumberOfSeats());
		logger.info("Acquisition Time: " + order.getAcquisitionTime());
		logger.info("Order Items:");
		order.getItems().forEach(item -> {
			logger.info(item.getMenuItemLine());
		});
		logger.info("Total Amount: " + totalAmount);
	}
}
