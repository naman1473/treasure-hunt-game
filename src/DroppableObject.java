//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: P05 Treasure Hunt - Droppable Object Class

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
 * This class models a droppable object designed for the cs300 spring 2022 p05 Treasure Hunt
 * adventure style game application.
 */
public class DroppableObject extends DraggableObject {
    private InteractiveObject target;
    /**
     * Creates a new Droppable object with specific name, x and y positions, message, target, and sets
     * its next clue.
     * @param name     - name of Droppable object
     * @param x        - position (x-coordinate)
     * @param y        - position (y-coordinate)
     * @param message  - message corresponding to object's field
     * @param target   - target/winning location
     * @param nextClue - preceding clue
     */

    public DroppableObject(String name, int x, int y, String message, InteractiveObject target,
        InteractiveObject nextClue) {
        super(name, x, y, message);
        this.target = target;
        this.setNextClue(nextClue);
    }

    /**
     * Checks whether this object is over another interactive object.
     * @param other - reference to another iteractive object. We assume that other is NOT null.
     * @return reference to another iteractive object. We assume that other is NOT null.
     */
    public boolean isOver(InteractiveObject other) {
        if(this.getX() + this.image.width > other.getX()
            && this.getX() < other.getX() + other.image.width
            && this.getY() + this.image.height > other.getY()
            && this.getY() < other.getY() + other.image.height){
            return true;
        }
        return false;
    }

    /**
     * Stops dragging this droppable object. Also, if this droppable object is over its target and the
     * target is activated, this method (1) deactivates both this object and its target and
     * activates
     *
     */
    @Override
    public void mouseReleased() {
        this.stopDragging();
        if (this.isOver(this.target) && this.target.isActive()) {
            this.deactivate();
            this.target.deactivate();
            this.activateNextClue();
            System.out.println(this.message());
        }
    }
}