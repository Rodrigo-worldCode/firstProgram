package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private OrderStatus status;

	private Client client;

	private List<OrderItem> itens = new ArrayList<>();

	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItens() {
		return itens;
	}

	public void addItem(OrderItem item) {
		itens.add(item);
	}

	public void removeItem(OrderItem item) {
		itens.remove(item);

	}

	public Double total() {
		double sum = 0;
		for (OrderItem x : itens) {
			sum += x.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(">>>>> ORDER SUMMARY <<<<< \n");
		sb.append("Order Moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + " " + sdf2.format(client.getBirthDate()) + " - " + client.getEmail()
				+ "\n");
		sb.append("Order items: \n");

		for (OrderItem x : itens) {
			sb.append(x.getProduct().getName() + ", " + String.format("USD$ %.2f", x.getProduct().getPrice()) + ", "
					+ "Quantity: " + x.getQuantity() + "\n");
			sb.append("Subtotal: USD$ " + String.format("%.2f%n", x.subTotal()));

		}

		sb.append("Total price: USD$ " + String.format("%.2f%n", total()));
		return sb.toString();
	}

}
