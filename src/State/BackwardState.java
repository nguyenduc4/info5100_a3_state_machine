/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

import LunarRover.LunarRover;

/**
 *
 * @author Duc Nguyen
 */
public class BackwardState implements State{
    private final String DOES_NOT_WORK = "DOES_NOT_HAVE_ANY_FUNCTION.";
    private LunarRover rover ; 

    public BackwardState(LunarRover rover) {
        this.rover = rover;
    }

    @Override
    public void pressButton1() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }

    @Override
    public void pressButton1For5Secs() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }
    
    @Override
    public void pressButton1For10Secs() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }

    @Override
    public void pressButton1Twice() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }

    @Override
    public void pressButton2() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }

    @Override
    public void pressLeftPedal() {
        System.out.println("ACCELERATE_BACKWARD");
        this.rover.setState(this.rover.getAccelerateBackwardState());
    }
    
    @Override
    public void pressLeftPedalOver3Secs() { 
        System.out.println("ACCELERATING_CONSTANTLY");
        this.rover.setState(this.rover.getAccelerateBackwardContantlyState());
    }

    @Override
    public void pressRightPedal() {
        System.out.println("DEACCELERATING.");
        this.rover.setLastAccelerateState(this.rover.getCurrentState());
        this.rover.setState(this.rover.getDeacceleratingState());
    }
}
