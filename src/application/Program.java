package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date moment = new Date();

		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = read.nextLine();
		System.out.print("E-mail: ");
		String email = read.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(read.next());

		Client client = new Client(name, email, birthDate);

		System.out.println();

		System.out.println("Enter order data");
		System.out.print("Status: ");
		String status = read.next();

		Order order = new Order(moment, OrderStatus.valueOf(status), client);

		System.out.print("How many items to this order: ");
		int quantityOrder = read.nextInt();

		for (int i = 1; i <= quantityOrder; i++) {
			System.out.println("Enter " + i + " item data: ");
			System.out.print("Product name: ");
			read.nextLine();
			String nameProduct = read.nextLine();
			System.out.print("Product price: ");
			double price = read.nextDouble();
			System.out.print("Quantity: ");
			int quantity = read.nextInt();

			Product product = new Product(nameProduct, price);
			OrderItem orderItem = new OrderItem(quantity, price, product);

			order.addItem(orderItem);

		}
		System.out.println();
		System.out.println(order);

		read.close();

	}

}
