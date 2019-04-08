public interface Grid
{
	public char winner();
	public void initialize();
	public void setBox(int row, int column, char player);
}