//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: P05 Treasure Hunt - ScreenshotButton Class

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
* This class defines what the screenshot button does when clicked by the user
*/

public class ScreenshotButton extends Button {

/**
* Creates a ScreenshotButton object which displays "Take a screenshot" on the screen
* 
* @param x - position of the x coordinate
* @param y - position of the y coordinate
*/

  public ScreenshotButton(int x, int y) {

    super("Take a screenshot", x, y);

  }



/**
* Button executes when the mouse is pressed by the user
*/

  public void mousePressed() {

    if (isMouseOver()) {

      processing.save("screenshot.png");

    }

  }
}

