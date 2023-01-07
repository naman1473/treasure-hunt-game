//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: P05 Treasure Hunt - Clickable class

// Course: CS 300 Spring 2022

// Author: Naman Parekh

// Email: ncparekh@wisc.edu

// Lecturer: Hobbes LeGault

//

//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////

//

// Nisitha De Silva

//

///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////

//

// NONE

//

///////////////////////////////////////////////////////////////////////////////


public interface Clickable {
	
	
	public void draw(); // draws this Clickable object to the screen
	public void mousePressed(); // defines the behavior of this Clickable object
	                            // each time the mouse is pressed
	
	public void mouseReleased(); // defines the behavior of this Clickable object
	                             // each time the mouse is released
	
	
	public boolean isMouseOver(); // returns true if the mouse is over this clickable object

}
