import java.util.Objects;

public class Coordinate {
	private int row;
	private int column;
	 
	Coordinate(int row, int column) {
       this.row = row;
       this.column = column;
	}
	 
	public int getRow() {
        return row;
    }
	
	public int getColumn() {
		return column;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	 
    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Coordinate coordinate = (Coordinate) o;
        // field comparison
        return Objects.equals(row, coordinate.row)
                && Objects.equals(column, coordinate.column);
    }
    
    @Override
    public int hashCode() {
    	int result = 17;
    	result = 37*result + row;
    	result = 37*result + column;
    	return result;
    }
}
