/**
 * Agenda.java
 * An abstract class to create a linkedList of Agenda and some methods
 */
import java.util.LinkedList;

abstract class Agenda{

	/**
	 * Represent the agenda that store items
	 */
	protected LinkedList<MazeGridLocation> agenda; 
	
	public Agenda(){
		agenda = new LinkedList<MazeGridLocation>();
	}
	/**
	 * Add new location to the Agenda
	 * @param loc location to be added
	 */
	public void addLocation(MazeGridLocation loc){
		agenda.addLast(loc);
	}

	/**
	 * Remove and a location from the Agenda
	 * @param loc location to be removed
	 */
	public abstract MazeGridLocation removeLocation();

	/**
	 * Clear all item from the Agenda
	 */
	public void clear(){
		agenda.clear();
	}

	/**
	 * @return the string representation of the Agenda
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		boolean first = true;
		for (int i = 0; i < agenda.size(); i++){
			if (first){
				sb.append(agenda.get(i));
				first = false;
			}else{
				sb.append(", ").append(agenda.get(i));
			}
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Check whether the Agenda is empty or not
	 */
	public boolean isEmpty(){
		return agenda.isEmpty();
	}
}