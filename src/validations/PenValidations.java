package validations;

import java.time.LocalDate;

import com.app.pen.Pen;

public class PenValidations {

	public static Pen validateInputs(String brand, String color, String inkColor, String material, int stock, String stockUpdateDate
			, String stockListingDate, double price, double discount) {
		
	     PenBrand newBrand = validateBrand(brand);
	     PenMaterial newMaterial = validateMaterial(material);
	     return new Pen(newBrand, color, inkColor, newMaterial, stock, LocalDate.parse(stockUpdateDate), LocalDate.parse(stockListingDate),
	    		 price, discount);
	}
	
   public static PenBrand validateBrand(String brand) {
	   return PenBrand.valueOf(brand.toUpperCase());
   }
   
   public static PenMaterial validateMaterial(String material) {
	   return PenMaterial.valueOf(material.toUpperCase());
   }


  


}

