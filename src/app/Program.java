package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Employee;
import entities.ImportedProduct;
import entities.OutsourcedEmployee;
import entities.Product;
import entities.Rectangle;
import entities.Shape;
import entities.UsedProduct;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter the number: "
				+ "\n #1 - Employee/OutsourcedEmployee"
				+ "\n #2 - Product/ImportedProduct/UsedProduct"
				+ "\n #3 - Shape/Rectangle/Circle"
				+ "\n #0 - exit");
		int n = sc.nextInt();
		sc.nextLine();
		
		switch(n) {
		case 1:
			List<Employee> list = new ArrayList<>();
			
			
			System.out.println("Enter the number of employees: ");
			n = sc.nextInt();
			
			
			for (int i=1; i<= n; i++) {
				System.out.print("Employee #" + i + "data: ");
				System.out.print("Outsourced (y/n)? ");
				char ch = sc.next().charAt(0);
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Hours: ");
				int hours = sc.nextInt();
				System.out.print("Value per hour: ");
				double valuePerHour = sc.nextDouble();
				if (ch == 'y') {
					System.out.print("Additional Charge: ");
					double additionalCharge = sc.nextDouble();
					list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
				}
				else {
					list.add(new Employee(name, hours, valuePerHour));
				}
			}
			
			System.out.println();
			System.out.println("PAYMENTS:");
			for (Employee emp : list) {
				System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()));
			}
			break;
		case 2:
			
			List<Product> products = new ArrayList<>();
			System.out.print("Enter the number of products:");
			n = sc.nextInt();
			for (int i = 1; i <=n;i++) {
				System.out.println("Product #" + i + " data:");
				System.out.print("Common, used or imported (c/u/i)?");
				char ch = sc.next().charAt(0);
				sc.nextLine();
				if (ch == 'i') {
					System.out.print("Name: ");
					String name = sc.nextLine();
					System.out.println("Price: ");
					double price = sc.nextDouble();
					System.out.println("Customs fee: ");
					double customsFee = sc.nextDouble();
					products.add(new ImportedProduct(name, price, customsFee));
				}
				if (ch == 'u') {
					System.out.print("Name: ");
					String name = sc.nextLine();
					System.out.println("Price: ");
					double price = sc.nextDouble();
					System.out.print("Manufacture date (DD/MM/YYY): ");
					Date manuDate = sdf.parse(sc.next());
					products.add(new UsedProduct(name, price, manuDate));
				}
				if (ch == 'c') {
					System.out.print("Name: ");
					String name = sc.nextLine();
					System.out.println("Price: ");
					double price = sc.nextDouble();
					products.add(new Product(name, price));
				}
			}
			System.out.println("PRICE TAGS:");
			for (Product product : products) {
				System.out.println(product.priceTag());
			}
			
			break;
		case 3:
			
			List<Shape> shape = new ArrayList<>();
			System.out.print("Enter the number of Shapes: ");
			n = sc.nextInt();
			for (int i = 1; i<=n;i++) {
				System.out.println("Shape #" + i + " data: ");
				System.out.print("Rectangle or Circle (r/c)?");
				char cha = sc.next().charAt(0);
				System.out.print("Color (BLACK/BLUE/RED): ");
				Color color = Color.valueOf(sc.next());
				if (cha == 'r') {
					System.out.print("width: ");
					double width = sc.nextDouble();
					System.out.print("Height: ");
					double height = sc.nextDouble();
					shape.add(new Rectangle(color, width, height));
				}else {
					System.out.print("Radius: ");
					double radius = sc.nextDouble();
					shape.add(new Circle(color, radius));
				}
			}
			
			System.out.println();
			System.out.println("SHAPE AREAS: ");
			for (Shape shapes : shape) {
					System.out.printf(String.format("\n%.2f", shapes.area()));
			}
			
			break;
		}
		
		sc.close();
	}

}
