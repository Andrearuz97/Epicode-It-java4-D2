package it.epicode.be.godfather.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Table {
	private int tableNumber;
	private int maxSeats;
	private boolean occupied;
}
