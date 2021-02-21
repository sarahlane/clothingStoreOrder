import java.util.Iterator;
public class ClosetDriver {
	public static void main(String[] args) {

		ClothingItemsCollection shoeStore = new ClothingItemsCollection(10);
		ClothingItem shoes1 = new ClothingItem(3, "Red Heels", 44.95);
		ClothingItem shoes2 = new ClothingItem(1, "Black Heels", 75);
		ClothingItem shoes3 = new ClothingItem(3, "Yellow Boots", 25);
		ClothingItem shoes4 = new ClothingItem(2, "Yellow Boots", 49.95);
		ClothingItem shoes5 = new ClothingItem(2, "White Sneakers", 45);
		ClothingItem socks1 = new ClothingItem(9, "Green Socks", 10);
		ClothingItem laces = new ClothingItem(5, "Shoe laces", 10);

		shoeStore.insert(shoes1);
		shoeStore.insert(shoes2);
		shoeStore.insert(shoes3);
		shoeStore.insert(shoes4);
		shoeStore.insert(shoes5);
		shoeStore.insert(socks1);
		shoeStore.insert(laces);
		
		Iterator<ClothingItem> iter = shoeStore.iterator();
		
		System.out.println(shoeStore.toString());
		System.out.println("•Size method: " + shoeStore.size());
		System.out.print("•Find method for 'Yellow Boots': " + shoeStore.find("Yellow Boots"));
		System.out.println("•countOccurences method for 'Yellow Boots': " 
		+ shoeStore.countOccurrences("Yellow Boots"));
		System.out.println("•Contains method for 'shoe2': " + shoeStore.contains(shoes2));
		System.out.println("•Total method: " + shoeStore.total());
		System.out.println("•countRange method for '(2,3)': "+ shoeStore.countRange(2,3));
		System.out.println("•delete method for 'Shoe laces': \n");
		shoeStore.delete(laces);
		System.out.println("•iterator method: \n" );
		while (iter.hasNext()){
			System.out.print(iter.next().toString());
		}

		System.out.println("\n•Showing error when array full");
		ClothingItemsCollection pantsStore = new ClothingItemsCollection(4);
		ClothingItem pants1 = new ClothingItem(3, "Black Jeans", 75);
		ClothingItem pants2 = new ClothingItem(2, "LightWash Jeans", 75);
		ClothingItem pants3 = new ClothingItem(7, "Red YogaPants", 65);
		ClothingItem pants4 = new ClothingItem(4, "Pink YogaPants", 65);
		ClothingItem pants5 = new ClothingItem(8, "Maroon YogaPants", 65);
		
		pantsStore.insert(pants1);
		pantsStore.insert(pants2);
		pantsStore.insert(pants3);
		pantsStore.insert(pants4);
		pantsStore.insert(pants5);
		
		Iterator<ClothingItem> iter2 = pantsStore.iterator();
		
		System.out.println(pantsStore.toString());
		System.out.println("•iterator method: \n" );
		
		while (iter2.hasNext()){
			System.out.print(iter2.next().toString());
		}
	}
}