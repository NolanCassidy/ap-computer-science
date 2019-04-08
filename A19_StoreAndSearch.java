public class A19_StoreAndSearch
{
	public static void main(String[] args)
	{
		Store store1 = new Store("NotHere.txt");
		store1.DisplayStore();
		store1.ItemSearch();
		System.out.println("\n");
		Store store2 = new Store("EmptyFile.txt");
		store2.DisplayStore();
		store2.ItemSearch();
		System.out.println("\n");
		Store store3 = new Store();
		store3.DisplayStore();
		store3.ItemSearch();
	}
}