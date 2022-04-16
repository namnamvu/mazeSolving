/**
 * MazeSolver.java
 * A program to determine if the maze has a solution and get the solution
 */
import java.util.ArrayList;

class MazeSolver{

	/**
	 * Initialize a private agenda of location
	 */
	private Agenda agenda;

	public MazeSolver(Agenda a){
		// Check if a is empty, clear if not
		if (!(a.isEmpty())){
			a.clear();
		}
		agenda = a;
	}

	/**
	 * Trace back location from the goal to the start
	 * @param list list of location to solution path
	 * @param prev 2d array that keeps track of the previous location of the current one
	 * @param mg The mazeGUI to make changes to the maze colors
	 * @param currLoc Current location (start with goal)
	 * @param start The start location of the maze
	 * @return an arrayList of solution location
	 */
	private ArrayList<MazeGridLocation> traceBack(ArrayList<MazeGridLocation> list, MazeGridLocation[][] prev,  MazeGUI mg, MazeGridLocation currLoc, MazeGridLocation start){
		// Base case if currLoc is the start
		if (currLoc == start){
			return list;

		// Recursive case
		}else{
			// Get the previous location of current location(part of the solution), change current location to previous
			currLoc = prev[currLoc.getRow()][currLoc.getColumn()];
			// Add the solution location
			list.add(currLoc);
			// Mark the locations that are part of the solution path
			mg.addLocToPath(currLoc);
			return traceBack(list, prev, mg, currLoc, start);
		}
	}

	/**
	 * Add possible neighbors to the agenda and add previous location of neighbors to 2d array
	 * @param m the maze object
	 * @param currLoc current location
	 * @param prev 2d array to keep track of previos location
	 */
	private void addNeighbors(Maze m, MazeGridLocation currLoc, MazeGridLocation[][] prev){
		// Get neighbor of the current location (which is the start at first)
		ArrayList<MazeGridLocation> neighbors = m.getOpenNeighbors(currLoc);
		// Add all possible neighbors to agenda
		for (MazeGridLocation move : neighbors){
			// Don't add visited move
			if (!(m.isVisited(move))){
				// Get a 2d array with the row and column of previous location, and the result = current location
				prev[move.getRow()][move.getColumn()]= currLoc;
				// Add location to the agenda
				agenda.addLocation(move);
				// mg.addLocToAgenda(move);
			}
		}
	}
	
	/**
	 * Method to solve the maze
	 * @return an arrayList of solution (enmpty list if there are no solution)
	 */
	public ArrayList<MazeGridLocation> solveMaze(Maze m, MazeGUI mg){	
		// Initialize an arrayList of solution 
		ArrayList<MazeGridLocation> list = new ArrayList<MazeGridLocation>();
		// Initialize a 2d array of the same size as the maze
		MazeGridLocation[][] prev = new MazeGridLocation[m.getNumRows()][m.getNumColumns()];

		MazeGridLocation start = m.getStartLocation();
		MazeGridLocation goal = m.getGoalLocation();
		// Add the start position to the agenda
		agenda.addLocation(start);

		// Loop until agenda is empty to determine if there is a possible solution
		while (!(agenda.isEmpty())){
			// Remove a location from the agenda
			MazeGridLocation currLoc = agenda.removeLocation();
			// Mark it as visited
			m.markVisited(currLoc);
			// mg.visitLoc(currLoc);
			
			// If curretn location reach goal, return an arrayList of solution
			if (currLoc.equals(goal)){
				return traceBack(list, prev, mg, currLoc, start);
			// Else add neighbors of the current location to the agenda
			}else{
				addNeighbors(m, currLoc, prev);
			}
		}
		return list; // This is just here so your program compiles!
	}

}