/**
 * This class represents a class which shows on
 * clothing items within a store
 * @author Sarah Storla
 *
 */
public class ClothingItem implements Comparable<ClothingItem>{
	//instance variables
	private int numberOfItems;
	private String kindOfItem;
	private double priceOfItems;
	
	//constructor
	/**
	 * 
	 * @param numberOfItems: number of items
	 * @param kindOfItem: the type of item the store has
	 * @param priceOfItems: the price of the clothing item
	 */
	public ClothingItem(int numberOfItems, String kindOfItem, double priceOfItems) {
		this.numberOfItems = numberOfItems;
		this.kindOfItem = kindOfItem;
		this.priceOfItems = priceOfItems;
	}
	//getters and setters for numberOfItems
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	//getters and setters for kindOfItem
	public String getkindOfItem() {
		return kindOfItem;
	}
	public void setkindOfItem(String kindOfItem) {
		this.kindOfItem = kindOfItem;
	}
	//getters and setters for priceOfItem
	public double getPriceOfItem() {
		return priceOfItems;
	}
	public void setPriceOfItem(double priceOfItem) {
		this.priceOfItems = priceOfItem;
	}
	
	//toString method
	/**
	 * Converts the instance variables into a nicely formated String
	 * @return Formated properties of ClothingItem
	 */
	@Override
	public String toString() {
		String priceFormat = String.format("%.2f", priceOfItems);
		String str1 =  kindOfItem + "\t" + "|   " + "\t";
		String str2 = numberOfItems + "\t" + "|";
		String str3 = "\t" + "$" + priceFormat + "\t    |";
		return  (str1 +  str2 + str3 + "\n");
	}

	//equals method
	/**
	 * Compares the equality of two kind of clothes - case insensitive
	 * @param other Object of type ClothingItem
	 * @return TRUE if the two items are the same
	 * 		   FALSE if items don't have the same name
	 */
	@Override
	public boolean equals(Object other) {
			if(other instanceof ClothingItem) {
				if(this.kindOfItem.equalsIgnoreCase(((ClothingItem) other).kindOfItem) && 
						this.getPriceOfItem() == ((ClothingItem) other).getPriceOfItem()) {
					return true;
				}
			}
		return false;
	}

	@Override
	/**
	 * Implements the Comparable interface
	 * @param o ClothingItem of type ClothingItem
	 * @return negative number if search key is less than parameters search key
	 * 			positive number if search key is greater than parameters search key
	 * 			0 when the two search keys are equal
	 */
	public int compareTo(ClothingItem o) {
		return this.kindOfItem.compareToIgnoreCase(o.kindOfItem) ;
	}
}
