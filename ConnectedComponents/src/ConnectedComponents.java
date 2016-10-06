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
				Coordinate coordinate = new Coordinate(i, j);
				if ((piece[i].charAt(j) != ' ') && (!visited.contains(coordinate))) {
					LOGGER.log(Level.INFO, "Coordinate row {0}", coordinate.getRow());
					LOGGER.log(Level.INFO, "Coordinate column {0}", coordinate.getColumn());
					visited.add(coordinate);
					queue.add(coordinate);
					componentCount++;
					LOGGER.log(Level.INFO, "component added");
				}
				while (!queue.isEmpty()) {
					Coordinate element = queue.pop();
					Coordinate queueCoordinateD = new Coordinate(element.getRow() + 1, element.getColumn());
					if ((queueCoordinateD.getRow() < height) && (queueCoordinateD.getColumn() >= 0) && (!visited.contains(queueCoordinateD))) {
						LOGGER.log(Level.INFO, "Inside flood down");
						if (piece[queueCoordinateD.getRow()].charAt(queueCoordinateD.getColumn()) != ' ') {
							queue.add(queueCoordinateD);
							visited.add(queueCoordinateD);
							LOGGER.log(Level.INFO, "temp1 value: {0}", queueCoordinateD.getRow());
							LOGGER.log(Level.INFO, "temp1 value 2: {0}", queueCoordinateD.getColumn());
						}
					}
					Coordinate queueCoordinateR = new Coordinate(element.getRow(), element.getColumn() + 1);
					if ((queueCoordinateR.getColumn() < width) && (queueCoordinateR.getRow() >= 0) && (!visited.contains(queueCoordinateR))) {
						LOGGER.log(Level.INFO, "Inside flood right");
						if (piece[queueCoordinateR.getRow()].charAt(queueCoordinateR.getColumn()) != ' ') {
							queue.add(queueCoordinateR);
							visited.add(queueCoordinateR);
						}
					}
					Coordinate queueCoordinateU = new Coordinate(element.getRow() - 1, element.getColumn());
					if ((queueCoordinateU.getRow() >= 0) && (queueCoordinateU.getColumn() >= 0) && (!visited.contains(queueCoordinateU))) {
						LOGGER.log(Level.INFO, "Inside flood up");
						if (piece[queueCoordinateU.getRow()].charAt(queueCoordinateU.getColumn()) != ' ') {
							queue.add(queueCoordinateU);
							visited.add(queueCoordinateU);
							//LOGGER.log(Level.INFO, "temp1 value: {0}", temp[0]);
							//LOGGER.log(Level.INFO, "temp1 value 2: {0}", temp[1]);
						}
					}
					Coordinate queueCoordinateL = new Coordinate(element.getRow(), element.getColumn() - 1);
					if ((queueCoordinateL.getColumn() >= 0) && (!visited.contains(queueCoordinateL))) {
						LOGGER.log(Level.INFO, "Inside flood left");
						if (piece[queueCoordinateL.getRow()].charAt(queueCoordinateL.getColumn()) != ' ') {
							queue.add(queueCoordinateL);
							visited.add(queueCoordinateL);
							//LOGGER.log(Level.INFO, "temp1 value: {0}", temp[0]);
							//LOGGER.log(Level.INFO, "temp1 value 2: {0}", temp[1]);
						}
					}
				}
			}
		}
		return componentCount;
	}
}
