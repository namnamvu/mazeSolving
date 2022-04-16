/**
 * StackAgenda.java
 * A concrete subclass of Agenda that store and retrieve item in a LIFO manner
 */
import java.util.EmptyStackException;

public class StackAgenda extends Agenda{

	/**
	 * Remove the last item of the Agends
	 */
	@Override
	public MazeGridLocation removeLocation() {
		if (isEmpty()){
			throw new EmptyStackException();
		}
		return agenda.removeLast();
	}

	public static void main(String[] args){
		// Initialize an agenda that behave like a stack
		StackAgenda stack = new StackAgenda();
		System.out.println(stack.isEmpty() + " - Should be true");
		// Create 5 location
		MazeGridLocation loc = new MazeGridLocation(0, 1, '#');
		MazeGridLocation loc1 = new MazeGridLocation(1, 1, '.');
		MazeGridLocation loc2 = new MazeGridLocation(2, 2, '*');
		MazeGridLocation loc3 = new MazeGridLocation(3, 3, '.');
		MazeGridLocation loc4 = new MazeGridLocation(5, 10, '*');

		// Add 5 location
		stack.addLocation(loc);
		stack.addLocation(loc1);
		stack.addLocation(loc2);
		stack.addLocation(loc3);
		stack.removeLocation();
		stack.addLocation(loc4);

		// String after remove loc3
		System.out.println(stack.toString() + " - Should remove (3,3)");
		System.out.println(stack.isEmpty() + " - Should be false");
		stack.clear();
		System.out.println(stack.isEmpty() + " - Should be true");
	}
}