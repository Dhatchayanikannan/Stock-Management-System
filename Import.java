package stockMng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Import extends Details{
	static int rate;
	static int quan;
	static List<String> impBillLi=new ArrayList<>();
	static List<Double> impBillRate=new ArrayList<>();
	static List<Integer> impBillQuan=new ArrayList<>();
	
public void addProducts() {
	System.out.println("import product");
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the no of products to be import");
	int no = sc.nextInt();
	
	System.out.println("enter the product name , rate , quantity");
	for (int i = 1; i <=no; i++) {
		Scanner scNo=new Scanner(System.in);
		String name = scNo.nextLine();
		int rate1 = scNo.nextInt();
		int quan1 = scNo.nextInt();
		if (li.contains(name)==false) {
			li.add(name);
			quan=quan1;
		}
		else {
			Integer it = quanMp.get(name);
			quan=quan+it+quan1;
		}
		
		rateMp.put(name, rate1);
		quanMp.put(name, quan);
		impBillLi.add(name);
		impBillQuan.add(quan1);
	}
}

public void importBill() {
	
	for (int i = 0; i < impBillLi.size(); i++) {
		String item = impBillLi.get(i);
		Integer it = rateMp.get(item);
		Integer it1 = impBillQuan.get(i);
		double rupee= (double)it*it1;
		impBillRate.add(rupee);
	}
	
	double total=0.0;
	for (Double dou : impBillRate) {
		total=total+dou;
	}
	
	System.out.println();
	System.out.printf("%10s %10s", " "," IMPORT PRODUCT BILL ");
	System.out.println();
	System.out.println("--------------------------------------------------");
	System.out.printf("%15s %5s %8s %10s", "Product-Name","Rate","Quantity","Rupees");
	System.out.println();
	System.out.println("--------------------------------------------------");
	
	for (int i = 0; i < impBillLi.size(); i++) {
		System.out.format("%15s %5d %8s %10s", impBillLi.get(i),rateMp.get(impBillLi.get(i)),impBillQuan.get(i),impBillRate.get(i));
		System.out.println();
	}
	System.out.println();
	System.out.println("---------------------------------------------------");
	System.out.printf("%30s %10s","Total",total);
	System.out.println();
	System.out.println("----------------------------------------------------");
	
	
	
}
}
