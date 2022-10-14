package stockMng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Export extends Details{
	static List<String> expBillLi = new ArrayList<>();
	static Map<String, Double> expBillRate = new HashMap<String, Double>();
	static List<Integer> expBillQuan = new ArrayList<>();
	static List<Double> expBillRupees = new ArrayList<>();
	int addno;
	
	public static void enterExportProduct() {
		System.out.println("enter the no of product to be export");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		System.out.println("enter the product name ,quantity");
		for (int i = 0; i < no; i++) {
			Scanner sc1 = new Scanner(System.in);
			String eName = sc1.nextLine();
			expBillLi.add(eName);
			int eQuan = sc1.nextInt();
			expBillQuan.add(eQuan);
		}
	}
	
	
	public void stockBalanceCheck() {
		for (int i = 0; i < expBillLi.size(); i++) {
			Integer totalQuan = quanMp.get(expBillLi.get(i));
			if (totalQuan >= expBillQuan.get(i)) {
				addno = i;
				addAddOn();
			} else {
				System.out.println("OOPS!! we have only " + totalQuan + " " + expBillLi.get(i) + " product available");
			}
		}
		
		for (int i = 0; i < expBillLi.size(); i++) {
			Integer reduce = expBillQuan.get(i);
			Integer wholeQuan = quanMp.get(expBillLi.get(i));
			quanMp.put(expBillLi.get(i), wholeQuan-reduce);
		}
	}
	
	
	public void addAddOn() {

		System.out.println("enter the addon percent to " + expBillLi.get(addno) + " for sale");
		Scanner sc2 = new Scanner(System.in);
		int percent = sc2.nextInt();
		Integer actual = rateMp.get(expBillLi.get(addno));
		double addOn = (double) (percent * 100 / actual);
		expBillRate.put(expBillLi.get(addno), actual + addOn);
		 
	}
	
	
	public void exportBill() {

		double total = 0;

		for (int i = 0; i < expBillLi.size(); i++) {
			String item = expBillLi.get(i);
			Double it = (double) expBillQuan.get(i);
			Double it1 = expBillRate.get(item);
			expBillRupees.add(it * it1);
		}

		for (Double dou : expBillRupees) {
			total = total + dou;
		}

		
		  System.out.println(); 
		  System.out.printf("%10s %10s", " "," EXPORT PRODUCT BILL ");
		  System.out.println();
		  System.out.println("--------------------------------------------------");
		  System.out.printf("%15s %8s %8s %10s","Product-Name","Rate","Quantity","Rupees"); 
		  System.out.println();
		  System.out.println("--------------------------------------------------");
		  
		  for (int i = 0; i < expBillLi.size(); i++) {
			  System.out.format("%15s %8s %8s %10s",expBillLi.get(i),expBillRate.get(expBillLi.get(i)),expBillQuan.get(i),expBillRupees.get(i));
			  System.out.println(); 
			  } 
		  System.out.println();
		  System.out.println("---------------------------------------------------");
		  System.out.printf("%33s %10s","Total",total);
		  System.out.println();
		  System.out.println("-------------------------------------------------");
		 
	}
	
	
	

}
