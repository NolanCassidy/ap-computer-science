// Nolan Cassidy
// Item.java

public class Item
{
	private int myId;
	private int myInv;

	public Item(int id, int inv)
	{
		myId = id;
		myInv = inv;
	}

	public int getId()
	{
		return myId;
	}

	public int getInv()
	{
		return myInv;
	}

	public int compareTo(Item other)
	{
		return myId - other.myId;
	}

	public boolean equals(Item other)
	{
		if (myId == other.myId)
			return true;
		else
			return false;
	}

	public String toString()
	{
		return ("ID # " + getId() + ": Inventory = " + getInv());
	}
}
