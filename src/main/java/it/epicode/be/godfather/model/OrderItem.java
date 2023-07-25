package it.epicode.be.godfather.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItem implements MenuItem {
	private String name;
	private Double price;
	private int quantity;

	@Override
	public String getMenuItemLine() {
		return name + " - " + price + " (Quantity: " + quantity + ")";
	}
}
