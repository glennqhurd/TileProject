
public class Coordinate {
	private int row;
	private int column;
	 
	Coordinate(int row1, int column1) {
       row = row1;
       column = column1;
	}
	 
	public int getRow() {
        return row;
    }
	
	public int getColumn() {
		return column;
	}
	 
    @Override
    public boolean equals(Object o) {
        if ((o instanceof Coordinate) && (((Coordinate) o).getValue() == this.value)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    
}
