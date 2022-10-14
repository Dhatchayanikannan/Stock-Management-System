package stockMng;

import java.util.Iterator;
import java.util.Scanner;

public class Home extends Details{
	
	public static void login() throws InterruptedException {
		System.out.println("Enter the password to login");
		Scanner sc=new Scanner(System.in);
		
		int count=3;
		for (int i = 1; i <=3; i++) {
			count--;
			String password = sc.next();
			if(password.equals("admin")) {
				rightUser();
				break;
			}
			else {
				if (i==3) {
					wrongUser();
				}
				else {
					System.out.println("Wrong password :: you have only "+count+" times to retry");
				}
			}
		}
		
	}
	
	
	
	public static void rightUser() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("WE ARE HERE TO HELP YOU!!");
		System.out.println();
		selectAction();
	}
	
	
	
	public static void wrongUser() {
		System.out.println("Sorry!!! Your attempts were over.");
	}
	
	
	
	public static void selectAction() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Press the letter which one you want to do");
		System.out.println("------------------------------------------");
		Thread.sleep(1000);
		System.out.println("For IMPORT : I");
		Thread.sleep(1000);
		System.out.println("For EXPORT : E");
		Thread.sleep(1000);
		System.out.println("To see STOCKDETAILS : D");
		
		Scanner sc1=new Scanner(System.in);
		int n=1;
		while(n<20) {
		String action = sc1.next();
		if (action.equalsIgnoreCase("i")) {
			Import im=new Import();
			showProductDetails();
			im.addProducts();
			im.importBill();
			Thread.sleep(1000);
			repeatDetails();
			break;
		}
		else if(action.equalsIgnoreCase("e")){
			Thread.sleep(1000);
			Export ex=new Export();
			showProductDetails();
			ex.enterExportProduct();
			ex.stockBalanceCheck();
			ex.exportBill();
			repeatDetails();
			break;
		}
		else if (action.equalsIgnoreCase("d")) {
			Thread.sleep(1000);
			System.out.println("Balane Inventories details");
			showProductDetails();
			detailsList();
			System.out.println();
			System.out.println("THANK YOU!!");
			break;
		}
		else {
			System.out.println(" INVALID action!! Press valid one ( I , E , D )");
		}
		n++;
		}
	}
	
	public static void repeatDetails() throws InterruptedException {
		System.out.println();
		System.out.println("Do you want see the Stock details press Y else N");
		Scanner sc3=new Scanner(System.in);
		String next = sc3.next();
		if (next.equalsIgnoreCase("y")) {
			Thread.sleep(1000);
			System.out.println("Balane Inventories details");
			detailsList();
			System.out.println();
			System.out.println("THANK YOU!!");
		}
		else {
			System.out.println();
			System.out.println("THANK YOU!!!!!!");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.format("%20s", " STOCK MANAGEMENT SYSTEM ");
		System.out.println();
		System.out.format("%20s","-------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Welcome!!!");
		login();
	}
}
