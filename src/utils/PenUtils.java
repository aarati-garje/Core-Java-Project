package utils;

import static validations.PenBrand.CELLO;
import static validations.PenBrand.PARKER;
import static validations.PenBrand.RAYNOLDS;
import static validations.PenBrand.TRIMAX;
import static validations.PenMaterial.ALLOY_STEEL;
import static validations.PenMaterial.METAL;
import static validations.PenMaterial.PLASTIC;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.app.pen.Pen;

import validations.PenBrand;
import validations.PenMaterial;
public class PenUtils {

	
	public static Map<Integer, Pen> populateMap() {
		Map<Integer,Pen> map = new HashMap<>();
		map.put(1,new Pen(CELLO, "black", "black", PLASTIC, 10, LocalDate.parse("2023-01-21"), LocalDate.parse("2022-01-21"), 10, 1));
		map.put(2,new Pen(PARKER, "black", "green", ALLOY_STEEL, 20, LocalDate.parse("2024-02-09"), LocalDate.parse("2023-05-03"), 300, 2.5));
		map.put(3,new Pen(RAYNOLDS, "blue", "blue", METAL, 15, LocalDate.parse("2023-12-10"), LocalDate.parse("2023-08-12"), 20, 3));
		map.put(4,new Pen(TRIMAX, "skyblue", "black", PLASTIC, 25, LocalDate.parse("2024-01-24"), LocalDate.parse("2023-11-10"), 50, 3));
		map.put(5,new Pen(CELLO, "purple", "red", METAL, 30, LocalDate.parse("2023-04-05"), LocalDate.parse("2022-12-02"), 25, 2));
		return map;
	}
	
	
   public static void updateStock(String brand, String material, String color, String inkColor, int newStock, Map<Integer, Pen> map)
		                                 throws IllegalArgumentException {
	for(Pen pen : map.values())  {
		PenBrand newBrand = PenBrand.valueOf(brand.toUpperCase());
		PenMaterial newMaterial = PenMaterial.valueOf(material.toUpperCase());
		if(pen.getBrand().equals(newBrand) && pen.getMaterial().equals(newMaterial) && pen.getColor().equals(color) &&
				                pen.getInkColor().equals(inkColor)) {
			pen.setStock(pen.getStock()+newStock);
		}
	}
}

   
 

}