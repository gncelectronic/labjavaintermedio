package org.utnfrm.ejemplo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductCounter {
	
	private Map<String, Long> productCountMap = new HashMap<String, Long>();
	private Map<String,String> productNames = new HashMap<String, String>();
	
	public ProductCounter(Map<String, String> productNames) {
		super();
		this.productNames = productNames;
	}
	
	
	public void processList(String[] list) {
		long curVal=0;
		for (String item : list) {
			if(productCountMap.containsKey(item)) {
				curVal = productCountMap.get(item);
				curVal++;
				productCountMap.put(item, new Long(curVal));
			}else {
				productCountMap.put(item, new Long(1));
			}
		}
	}
	
	
	public void printReport() {
		System.out.println("=== Product Report ===");
	       
        for (String key : productNames.keySet()) {
            System.out.print("Name: " + key);
            
            System.out.println("\t\tCount: " + productCountMap.get(productNames.get(key)));
        }
    
	}
	
	  public static void main(String[] args) {
		  String[] parts = new String[]{"1S01", "1S01", "1S01", "1S01", "1S01", "1S02", "1S02", "1S02", "1H01", "1H01", "1S02", "1S01", "1S01", "1H01", "1H01", "1H01", "1S02", "1S02", "1M02", "1M02", "1M02"};
		  
		   
	        Map<String, String> productNames = new TreeMap<>();
	        productNames.put("Blue Polo Shirt", "1S01");//1S01=7
	        productNames.put("Black Polo Shirt", "1S02"); //1S02=6
	        productNames.put("Red Ball Cap", "1H01");//1H01=5
	        productNames.put("Duke Mug   ", "1M02");//1M02=3

	        
	        ProductCounter pc1 = new ProductCounter(productNames);
	        //aca estamos pasando el array de String
	        pc1.processList(parts);
	        pc1.printReport();
	  }
	
	
	

}
