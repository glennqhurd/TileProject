import java.util.Objects;

public class Coordinate {
	private final int row;
	private final int column;
	 
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
        return Objects.equals(row, coordinate.getRow())
                && Objects.equals(column, coordinate.getColumn());
    }
    
    @Override
    public int hashCode() {
    	int result = 17;
    	result = 37*result + row;
    	result = 37*result + column;
    	return result;
    }
}
