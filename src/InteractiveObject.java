//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: P05 Treasure Hunt - Interactive Object Class

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

import java.io.File;
import java.util.NoSuchElementException;
import processing.core.PImage;

/**
 * This class sets up objects and the clues
 */
public class InteractiveObject implements Clickable {
    // reference to the PApplet where this object will be drawn
    protected static TreasureHunt processing;
    private final String NAME; // name of this interactive object
    protected PImage image; // reference to the image of this object
    private int x; // x-position of this interactive object in the screen
    private int y; // y-position of this interactive object in the screen
    private boolean isActive; // tells whether or not this object is active
    private boolean wasClicked; // tells whether this object was already clicked
    private String message; // message to be displayed when this object is clicked
    private InteractiveObject nextClue; // Object to be activated when this object is



    @Override public void draw() {
        processing.image(this.image, this.x, this.y);

    }

    @Override public void mousePressed() {
        if (isMouseOver()) {
            System.out.println(message());
            if (nextClue != null && !this.wasClicked) {
                this.wasClicked = true;
                activateNextClue();
            }
        }

    }
    @Override public void mouseReleased() {
    }
    /**
     * This is for the interactive objects with no clue
     * @param name  name to be assigned to this interactive object. We assume that name is
     *             VALID (not null and not equal to an empty string)
     * @param x   x-position to be assigned to this interactive object
     * @param y   y-position to be assigned to this interactive object
     * @param message  message to be displayed on the console each time this interactive object
     *                 is clicked. We assume that message
     *                 is VALID (not null and not equal to an empty string)
     */
     public InteractiveObject(String name, int x, int y, String message){

        this.NAME = name;
        this.x = x;
        this.y = y;
        this.isActive = true;
        this.message = message;
        this.wasClicked = false;
        this.nextClue = null;
        //InteractiveObject noNextClue = new InteractiveObject(name,x,y,message);
        this.image = processing.loadImage("images" + File.separator + name + ".png");
        //processing.image(this.image, this.x, this.y);

        // activate();
        // if(nextClue == null){
        //  InteractiveObject noNextClue =  new InteractiveObject(name,x,y,message);
        //}
    }

    /**
     * This is for the interactive objects with a clue
     * @param name    name to be assigned to this interactive object. We assume that name is VALID
     *               (not null and not equal to an empty string)
     * @param x  x-position to be assigned to this interactive object
     * @param y  y-position to be assigned to this interactive object
     * @param message message to be displayed on the console each time this interactive
     *               object is clicked. We assume that message is VALID (not null and not equal to an empty string)
     * @param nextClue   a reference to a non-null InteractiveObject which represents
     *                  the next clue associated to this interactive object.
     */
    public InteractiveObject(String name, int x, int y,String message, InteractiveObject nextClue ){

        this(name, x, y,message);
        this.nextClue = nextClue;
        this.isActive = true;
        this.wasClicked = false;
        this.nextClue = nextClue;
        this.nextClue.deactivate();

        this.image = processing.loadImage("images" + File.separator + name + ".png");

        // if(nextClue != null){
        //InteractiveObject noNextClue =  new InteractiveObject(name,x,y,message);
        //  activateNextClue();

        // }
    }

    /**
     * Sets the PApplet object of the treasure hunt application where all the interactive
     * objects will be drawn. Note that a graphic application has ONLY one display window of type
     * PApplet where all graphic objects interact. In p05, the TreasureHunt class is of type PApplet
     * @param processing represents the reference to the TreasureHunt PApplet object where
     *                   all the interactive objects will be drawn.
     */
    public static void setProcessing(TreasureHunt processing){
        InteractiveObject.processing = processing;
    }

    /**
     * gets the x position of the current object
     * @return
     */
    public int getX(){

        return this.x;
    }

    /**
     * gets the y position of the current object
     * @return
     */
    public int getY(){

        return this.y;
    }

    /**
     * Moves the current x and y positions of this interactive object with dx and dy, respectively
     * @param dx    move to be added to the x position of this interactive object
     * @param dy    move to be added to the y position of this interactive object
     */
    public void move(int dx,int dy){

        this.x = dx + x;
        this.y = dy + y;
    }

    /**
     * Checks whether the name of this interactive object equals to the name passed as input
     * parameter We consider a case-sensitive comparison.
     * @param name name to compare to
     * @return true if the name of this interactive object equals the provided name, false otherwise
     */
    public boolean hasName(java.lang.String name){
        if( this.NAME.equals(name)){
            return true;
        }
        return false;
    }

    /**
     * checks if the current object is active or not
     * @return
     */
    public boolean isActive(){
        if(!this.isActive){
            return false;
        }

        return true;
    }

    /**
     * activates the object
     */
    public void activate(){
        this.isActive = true;
    }

    /**
     * deactivates the object
     */
    public void deactivate(){
        this.isActive = false;
    }

    /**
     * retunrs the message to be printed out
     * @return
     */
    public java.lang.String message(){
        return this.message;
    }

    /**
     *  sets the next clue for the current object
     * @param nextClue
     */
    public void setNextClue(InteractiveObject nextClue){
        this.nextClue = nextClue;

    }

    /**
     * Activates the next clue if there's a next clue available if not it will throw a
     * no such element exception
     * @throws java.util.NoSuchElementException
     */
    protected void activateNextClue() throws java.util.NoSuchElementException{
        if (this.nextClue == null) {
            throw new NoSuchElementException("next clue is not assigned");
        }
        this.nextClue.isActive = true;
        processing.add(this.nextClue);
    }
    
    @Override
    public boolean isMouseOver() {
    	 if (processing.mouseX <= this.getX() + image.width && processing.mouseX >= this.getX()
                && processing.mouseY <= this.getY() + image.height && processing.mouseY >= this.getY()) {

    		      return true;

    		    }

    		    return false;

            }
}
     