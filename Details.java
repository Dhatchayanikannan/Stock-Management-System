package stockMng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Details {
	static List<String> li=new ArrayList<>();
	static Map<String, Integer> rateMp=new HashMap<>();
	static Map<String,Integer> quanMp=new HashMap<>();
	
	
public static void stockInventories() {
		li.add("rice");
		li.add("biscuit");
		li.add("sugar");
		li.add("dhall");
		li.add("chilli");
		
}

public static void addinventoriesRate() {
	rateMp.put("rice", 500);
	rateMp.put("biscuit", 30);
	rateMp.put("sugar", 70);
	rateMp.put("dhall", 60);
	rateMp.put("chilli", 80);
}

public static void addStockInventoriesQuantity() {
	quanMp.put("rice", 150);
	quanMp.put("biscuit", 0);
	quanMp.put("sugar", 50);
	quanMp.put("dhall", 25);
	quanMp.put("chilli", 0);
}


public static void detailsList() {
	System.out.println();
	System.out.printf("%20s", " STOCK DETAILS ");
	System.out.println();
	System.out.println("--------------------------------------------------");
	System.out.printf("%15s %5s %8s", "Product-Name","Rate","Quantity");
	System.out.println();
	System.out.println("--------------------------------------------------");
	
	for (int i = 0; i < li.size(); i++) {
		System.out.format("%15s %5d %8d", li.get(i),rateMp.get(li.get(i)),quanMp.get(li.get(i)));
		System.out.println();
	}
}


public static void showProductDetails() {
	stockInventories();
	addinventoriesRate();
	addStockInventoriesQuantity();
}

}
