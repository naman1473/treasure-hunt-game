//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: P05 Treasure Hunt - RestartGameButton Class

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

/**
*This class defines what the restart game button does when clicked by the user
*/

public class RestartGameButton extends Button {



/**
* Creates a RestartGameButton object which displays 'Restart Game' on the screen
* 
* @param x - position of the x coordinate
* @param y - position of the y coordinate
*/

  public RestartGameButton(int x, int y) {

    super("Restart Game", x, y);

  }


/**
* Displays the functionality of the particular button when the user's mouse is pressed 
*/

  public void mousePressed() {

    if (this.isMouseOver()) {

      ((TreasureHunt) Button.processing).initGame();

    }

  }

}
