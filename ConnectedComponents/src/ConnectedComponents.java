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
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
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
					queue.add(index);
					componentCount++;
					LOGGER.log(Level.INFO, "component added");
				}
				while (!queue.isEmpty()) {
					int[] element = queue.pop();
					int[] temp = {element[0] + 1, element[1]};
					if ((temp[0] < height) && (temp[1] >= 0) && (!visited.contains(temp))) {
						LOGGER.log(Level.INFO, "Inside flood down");
						Coordinate queueCoordinate = new Coordinate(temp[0], temp[1]);
						if (piece[temp[0]].charAt(temp[1]) != ' ') {
							queue.add(temp);
							visited.add(queueCoordinate);
							LOGGER.log(Level.INFO, "temp1 value: {0}", temp[0]);
							LOGGER.log(Level.INFO, "temp1 value 2: {0}", temp[1]);
						}
					}
					temp[0] = element[0]; 
					temp[1] = element[1] + 1;
					if ((temp[1] < width) && (temp[0] >= 0) && (!visited.contains(temp))) {
						LOGGER.log(Level.INFO, "Inside flood right");
						Coordinate queueCoordinate = new Coordinate(temp[0], temp[1]);
						if (piece[temp[0]].charAt(temp[1]) != ' ') {
							queue.add(temp);
							visited.add(queueCoordinate);
						}
					}
					temp[0] = element[0] - 1;
					temp[1] = element[1];
					if ((temp[0] >= 0) && (temp[1] >= 0) && (!visited.contains(temp))) {
						LOGGER.log(Level.INFO, "Inside flood up");
						Coordinate queueCoordinate = new Coordinate(temp[0], temp[1]);
						if (piece[temp[0]].charAt(temp[1]) != ' ') {
							queue.add(temp);
							visited.add(queueCoordinate);
							//LOGGER.log(Level.INFO, "temp1 value: {0}", temp[0]);
							//LOGGER.log(Level.INFO, "temp1 value 2: {0}", temp[1]);
						}
					}
					temp[0] = element[0];
					temp[1] = element[1] - 1;
					if ((temp[1] >= 0) && (!visited.contains(temp))) {
						LOGGER.log(Level.INFO, "Inside flood left");
						Coordinate queueCoordinate = new Coordinate(temp[0], temp[1]);
						if (piece[temp[0]].charAt(temp[1]) != ' ') {
							queue.add(temp);
							visited.add(queueCoordinate);
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
