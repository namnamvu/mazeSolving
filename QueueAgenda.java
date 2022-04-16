/**
 * QueueAgenda.java
 * A concrete subclass of Agenda that store and retrieve item in a FIFO manner
 */
import java.util.NoSuchElementException;

public class QueueAgenda extends Agenda{

	/**
	 * Remove the first item of the Agenda
	 */
	@Override
	public MazeGridLocation removeLocation() {
		if (isEmpty()){
			throw new NoSuchElementException();
		}
		return agenda.removeFirst();
	}

	public static void main(String[] args){
		// Initialize an agenda that behave like a queue
		QueueAgenda queue = new QueueAgenda();
		System.out.println(queue.isEmpty() + " - Should be true");
		// Create 5 locations
		MazeGridLocation loc = new MazeGridLocation(0, 1, '#');
		MazeGridLocation loc1 = new MazeGridLocation(1, 1, '.');
		MazeGridLocation loc2 = new MazeGridLocation(2, 2, '*');
		MazeGridLocation loc3 = new MazeGridLocation(3, 3, '.');
		MazeGridLocation loc4 = new MazeGridLocation(5, 10, '*');
		//Add 5 locations
		queue.addLocation(loc);
		queue.addLocation(loc1);
		queue.addLocation(loc2);
		queue.addLocation(loc3);
		queue.removeLocation();
		queue.addLocation(loc4);

		//String after remove loc1
		System.out.println(queue.toString() + " - Should remove (0,1)");
		System.out.println(queue.isEmpty() + " - Should be false");
		queue.clear();
		System.out.println(queue.isEmpty() + " - Should be true");
	}
}