import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.IllegalArgumentException;

public class ConnectedComponents {
	
	public static final Logger LOGGER = Logger.getLogger(ConnectedComponents.class.getName());
	
	/**
	 * This function takes a String array as a parameter and after
	 * checking that the String lengths are uniform checks each element
	 * for chars that represent a different color of the piece.
	 * Every piece that has a char that isn't ' ' starts a search to adjacent
	 * sections of the piece unless it has been visited already.  If the index
	 * of the piece has been visited it will be stored in the set visited.
	 * If a tile has a non ' ' char and it is visited for the first time at
	 * the start of algorithm it will add 1 to the variable componentCount.
	 * 
	 * @param piece a String array representing a colored tile
	 * @return componentCount number of connected non ' ' sections of the tile
	 */
	public int findComponentCount(String[] piece) {
		ArrayDeque<Coordinate> queue = new ArrayDeque<Coordinate>();
		Set<Coordinate> visited = new HashSet<Coordinate>();
		int componentCount = 0;
		int width = piece[0].length();
		int height = piece.length;
		for (int i = 0; i < height; i++) {
			if (piece[i].length() != width) {
				throw new IllegalArgumentException();
			}
			for (int j = 0; j < width; j++) {
				int[] index = {i, j};
				Coordinate coordinate = new Coordinate(i, j);
				if ((piece[i].charAt(j) != ' ') && (!visited.contains(coordinate))) {
					LOGGER.log(Level.INFO, "Index[0] {0}", index[0]);
					LOGGER.log(Level.INFO, "Index[1] {0}", index[1]);
					visited.add(coordinate);
					queue.add(coordinate);
					componentCount++;
					LOGGER.log(Level.INFO, "component added");
				}
				while (!queue.isEmpty()) {
					Coordinate element = queue.pop();
					Coordinate queueCoordinate = new Coordinate(element.getRow() + 1, element.getColumn());
					if ((queueCoordinate.getRow() < height) && (queueCoordinate.getColumn() >= 0) && (!visited.contains(queueCoordinate))) {
						LOGGER.log(Level.INFO, "Inside flood down");
						if (piece[queueCoordinate.getRow()].charAt(queueCoordinate.getColumn()) != ' ') {
							queue.add(queueCoordinate);
							LOGGER.log(Level.INFO, "temp1 value: {0}", queueCoordinate.getRow());
							LOGGER.log(Level.INFO, "temp1 value 2: {0}", queueCoordinate.getColumn());
						}
						visited.add(queueCoordinate);
					}
					queueCoordinate.setRow(element.getRow()); 
					queueCoordinate.setColumn(element.getColumn() + 1);
					if ((queueCoordinate.getColumn() < width) && (queueCoordinate.getRow() >= 0) && (!visited.contains(queueCoordinate))) {
						LOGGER.log(Level.INFO, "Inside flood right");
						if (piece[queueCoordinate.getRow()].charAt(queueCoordinate.getColumn()) != ' ') {
							queue.add(queueCoordinate);
						}
						visited.add(queueCoordinate);
					}
					queueCoordinate.setRow(element.getRow() - 1);
					queueCoordinate.setColumn(element.getColumn());
					if ((queueCoordinate.getRow() >= 0) && (queueCoordinate.getColumn() >= 0) && (!visited.contains(queueCoordinate))) {
						LOGGER.log(Level.INFO, "Inside flood up");
						if (piece[queueCoordinate.getRow()].charAt(queueCoordinate.getColumn()) != ' ') {
							queue.add(queueCoordinate);
							//LOGGER.log(Level.INFO, "temp1 value: {0}", temp[0]);
							//LOGGER.log(Level.INFO, "temp1 value 2: {0}", temp[1]);
						}
						visited.add(queueCoordinate);
					}
					queueCoordinate.setRow(element.getRow());
					queueCoordinate.setColumn(element.getColumn() - 1);
					if ((queueCoordinate.getColumn() >= 0) && (!visited.contains(queueCoordinate))) {
						LOGGER.log(Level.INFO, "Inside flood left");
						if (piece[queueCoordinate.getRow()].charAt(queueCoordinate.getColumn()) != ' ') {
							queue.add(queueCoordinate);
							//LOGGER.log(Level.INFO, "temp1 value: {0}", temp[0]);
							//LOGGER.log(Level.INFO, "temp1 value 2: {0}", temp[1]);
						}
						visited.add(queueCoordinate);
					}
				}
			}
		}
		return componentCount;
	}
}
