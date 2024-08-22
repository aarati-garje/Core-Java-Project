package tester;

import static utils.PenUtils.populateMap;
import static utils.PenUtils.updateStock;
import static validations.PenValidations.validateInputs;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import com.app.pen.Pen;
public class PenShop {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			boolean exit = true;
			
			Map<Integer, Pen> map = populateMap();
			Pen pen = null;
			while(exit){
				System.out.println("1.Add pen");
				System.out.println("2.Update stock of pen");
				System.out.println("3.Set a discount");
				System.out.println("4.Display");
				System.out.println("5.Remove Pens which are never sold once listed in 9 months");
				System.out.println("0.Exit");
				System.out.println("Choose option");
				try {
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Enter brand, color, inkColor, material, stock,  stockUpdateDate, stockListingDate, price, discount");
					pen = validateInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),sc.nextDouble());		
					map.put(pen.getpId(), pen);
					break;
					
				case 2:
					System.out.println("enter brand, material, color, inkColor and new stock of pen to update stock");
					updateStock(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(), map);
					
					System.out.println("stock updated!!");
				    break;
				    
				case 3:
					//System.out.println("enter discount");
					for(Pen pen1 : map.values()) {
					if(!(pen1.isSoldInLastThreeMonths())) {
						pen1.setDiscount(20.0);
						pen1.setPrice(pen1.getPrice()-pen1.getPrice()*0.20);
					}
					}
					System.out.println("Offer discount");
					
					break;
					
				case 4:
					for(Pen pens : map.values())
					 System.out.println(pens);
					break;
					
				case 5:
					Iterator<Entry<Integer, Pen>> iterator = map.entrySet().iterator();
					while(iterator.hasNext()) {
						Entry<Integer, Pen> entry = iterator.next();
						Pen pn = entry.getValue();
						if(!(pn.isListedInLastNineMonths())) {
							iterator.remove();
							System.out.println("Pen rempved" + pn);
						}
					}
					
					
					break;
					
				case 0:
					exit = false;
				}
			}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		

	}

}
