/**
 * This class represents a class which shows a
 * collection of ClothingItem
 * @author Sarah Storla
 *
 */
import java.util.Iterator;
//Stores that carry clothing items
public class ClothingItemsCollection implements Iterable<ClothingItem>, DataCollection<ClothingItem> {
	//instance variables
	private ClothingItem items[];
	private int numItems;
	
	//constructor
	/**
	 * @param initalCap is capacity of array
	 */
	public ClothingItemsCollection(int initalCap) {
		this.items = new ClothingItem[initalCap];
		numItems = 0;
	}
	//insert method
	/**
	 * takes one input of type ClothingItem and
	 * inserts it into the collection class in DESCENDING ORDER
	 * along with a try/catch block
	 * @param oneThing of type ClothingItem
	 * @return TRUE if inserted into array
	 * @return FALSE if array full or could not be added
	 */
	@Override
	public boolean insert(ClothingItem oneThing){
		if (numItems == items.length) {
			System.out.println(" \nARRAY FULL - Could not include " + oneThing.getkindOfItem()
			+ "\n");
		    return false;
		}
		String name = oneThing.getkindOfItem();
		int i = 0;
		while (i < numItems && (items[i].getkindOfItem().
				compareToIgnoreCase(name) >= 0 )){
			i++;
		}
		// i is the insertion point
		
		try {
			//moving to make room
			for(int move = numItems; move > i; move--) {
				items[move] = items[move-1];
			}
			//insert
			items[i] = oneThing;
			numItems++;
			//System.out.println(numItems);
			return true;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw e;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return true;
	}

	@Override
	//size method
	/**
	 * @return numItems number of objects in collection
	 */
	public int size() {
		return numItems;
	}
	//toString method
	/**
	 * formats and returns a string representation of clothing
	 * info
	 * @return numItems string representation of ClothingItemCollection
	 */
	public String toString() {
		String clothStuff = "";
		for(int i = 0; i < numItems; i++) {
			clothStuff += items[i].toString();
		}
		String str1 =  "Description" + "\t    ";
		String str2 = "Quantity" + "\t\t";
		String str3 = "Price" + "\t\t" + "\n";
		String str4 = "<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + "\n";
		String str5 = clothStuff;
		String str6 =  "<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + "\n";
		return(str1 + str2 + str3 + str4 + str5 + str6);
		}

	//find method
		/**
		 * takes an input of type String and returns first object
		 * with a key that matches
		 * @param key is the name of the item that you want to find
		 * @return items[i] the item
		 * 
		 */
	@Override
	public ClothingItem find(String key) {
		
		int i = 0;
		while (i < numItems && (items[i].getkindOfItem().
				compareTo(key) != 0 )) {
			i++;
		}
		if(i >= numItems) {
			System.out.println("Could not find " + key);
			System.exit(0);
		}
		return items[i];
	}
	//countOccurrences method
	/**
	 * takes a string and returns the number of times the
	 * string occurs in collection
	 * @param key is the name of object you want to count
	 * @return i number of times it occurs
	 */
	@Override
	public int countOccurrences(String key) {
		int i = 0;
		while (i < numItems && (items[i].getkindOfItem().
				compareTo(key) == 0 )) {
			i++;
		}
		if(i >= numItems) {
			System.out.println("Could not find " + key);
			System.exit(0);
		}
		return i;
	}
	//contains method
	/**
	 * takes the an input of type ClothingItem and sees if 
	 * it exists in the collection
	 * @param oneThing of type ClothingItem 
	 * @return TRUE if the collection does contain oneThing
	 * @return FALSE if collection does not contain oneThing 
	 */
	@Override
	public boolean contains(ClothingItem oneThing) {
		for(int i = 0; i < numItems; i++){
			if(items[i].equals(oneThing)) {
				//System.out.println(items[i]);
				//System.out.println(oneThing);
				return true;
			}
		}
		return false;
	}
	//total method
	/**
	 * calculates and returns the sum of the quantity of ClothingItems
	 *@returns totalQuantity sum of quantity of ClothingItems 
	 */
	@Override
	public int total() {
		int totalQuantity = 0;
		for(int i = 0; i < numItems; i++) {
			totalQuantity += items[i].getNumberOfItems();
			}
		return totalQuantity;
	}

	@Override
	//countRange method
	/**
	 * count how many items has quantity within range and returns how
	 * many items are contained with in this range
	 * @param low is the lower bound of the range you wish to search
	 * @param high is the upper bound of the range you with to search
	 * @return totalQuantRange the total quantity of ClothingItem 
	 * with quantity in range
	 */
	public int countRange(int low, int high) {
		if (low > high) {
			return 0;
			}
		int totalQuantRange = 0;
		for(int i = 0; i < numItems; i++) {
			if(items[i].getNumberOfItems() >= low && 
					items[i].getNumberOfItems() <= high) {
				     totalQuantRange++;
				     }
		}
		return totalQuantRange;
	}
	//delete method
	/**
	 * method deletes one clothingItem and keeps the order
	 * @param oneThing of type ClothingItem that you wish to delete
	 * @return null
	 */
	public void delete(ClothingItem oneThing) {
		for(int i = 0; i < numItems; i++) {
			if (items[i].equals(oneThing)) {
				while(i < (numItems-1)) {
					items[i] = items[i+1];
					i++;
				}
				numItems--;
				items[numItems] = null;
			}
		}
	}
	//iterator
	/**
	 * Causes an iterator to be instantiated
	 * @return ClothingItemCollectionIterator
	 * returns an object that can be used to iterate over
	 * the clothing items
	 */
	@Override
	public Iterator<ClothingItem> iterator() {
		return new ClothingItemsCollectionIterator();
	}
	
	/**
	 * ClothingItemsCollectionIterator
	 * 
	 * Embedded class that implements the constructor,
	 * hasNext() and next() methods for an iterator for the ClothingItemsCollections
	 * class
	 */
	public class ClothingItemsCollectionIterator implements Iterator<ClothingItem>{
		@Override
		public boolean hasNext() {
			int i = 0;
			if (i < numItems && (items[i].getkindOfItem().
					compareToIgnoreCase(items[i].getkindOfItem()) >= 0 )){
				return true;
			}
			else
				return false;
				
			}
		@Override
		public ClothingItem next() {
			//System.out.println(numItems);
			ClothingItem output = items[numItems-1];
			numItems--;
			return output;
			}
		}
		
	}

