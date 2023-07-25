package it.epicode.be.godfather.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {
	private int orderNumber;
	private String status;
	private int numberOfSeats;
	private LocalDateTime acquisitionTime;
	private List<MenuItem> items = new ArrayList<>();

	// Add the constructor
	public Order(int orderNumber, String status, int numberOfSeats, LocalDateTime acquisitionTime) {
		this.orderNumber = orderNumber;
		this.status = status;
		this.numberOfSeats = numberOfSeats;
		this.acquisitionTime = acquisitionTime;
	}
}
