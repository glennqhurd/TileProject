import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectedComponents {
	
	public static final Logger LOGGER = Logger.getLogger(ConnectedComponents.class.getName());
	
	public int findComponentCount(String[] piece) {
		ArrayDeque<int[]> arrayQueue = new ArrayDeque<int[]>();
		Set<Coordinate> visited = new HashSet<Coordinate>();
		int componentCount = 0;
		int size = piece[0].length();
		for (int i = 0; i < piece.length; i++) {
			if (piece[i].length() != size) {
				return -1;
			}
			for (int j = 0; j < piece[i].length(); j++) {
				int[] index = {i, j};
				Coordinate coordinate = new Coordinate(index[0], index[1]);
				if ((piece[i].charAt(j) != ' ') && (!visited.contains(coordinate))) {
					LOGGER.log(Level.INFO, "Index[0] {0}", index[0]);
					LOGGER.log(Level.INFO, "Index[1] {0}", index[1]);
					visited.add(coordinate);
					arrayQueue.add(index);
					componentCount++;
					LOGGER.log(Level.INFO, "component added");
				}
				while (!arrayQueue.isEmpty()) {
					int[] element = arrayQueue.pop();
					int[] temp1 = {element[0] + 1, element[1]};
					if (((element[0] + 1) < piece.length) && (!visited.contains(temp1))) {
						if ((piece[element[0] + 1].charAt(element[1])) != ' ') {
							LOGGER.log(Level.INFO, "Inside flood vertical");
							Coordinate queueCoordinate = new Coordinate(temp1[0], temp1[1]);
							visited.add(queueCoordinate);
							arrayQueue.add(temp1);
							LOGGER.log(Level.INFO, "temp1 value: {0}", temp1[0]);
							LOGGER.log(Level.INFO, "temp1 value 2: {0}", temp1[1]);
						}
					}
					int[] temp2 = {element[0], element[1] + 1};
					if (((element[1] + 1) < piece[i].length()) && (!visited.contains(temp2))) {
						if ((piece[element[0]].charAt(element[1] + 1)) != ' ') {
							LOGGER.log(Level.INFO, "Inside flood horizontal");
							Coordinate queueCoordinate = new Coordinate(temp2[0], temp2[1]);
							visited.add(queueCoordinate);
							arrayQueue.add(temp2);
						}
					}
				}
			}
		}
		return componentCount;
	}
}
