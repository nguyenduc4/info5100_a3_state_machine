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
public class IdleState implements State {
    private final String DOES_NOT_WORK = "DOES_NOT_HAVE_ANY_FUNCTION.";
    private final LunarRover rover;
    
    public IdleState(LunarRover rover) { 
        this.rover = rover;
    }

    @Override
    public void pressButton1() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }

    @Override
    public void pressButton1For5Secs() {
        System.out.println("SWITCHING_TO_COLOR_CAMERA_MODE_(HOLDS_FOR_5_SECS)");
        this.rover.setState(this.rover.getColorCameraState());
    }
    
    @Override
    public void pressButton1For10Secs() { 
        System.out.println("SWITCHING_TO_16MM_CAMERA_MODE._(HOLDS_FOR_10_SECS)");
        this.rover.setState(this.rover.get16mmCameraState());
    }

    @Override
    public void pressButton1Twice() {
        System.out.println("SWITCHING_TO_DRILL_MODE.");
        this.rover.setState(this.rover.getDrillOnState());
    }

    @Override
    public void pressButton2() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }

    @Override
    public void pressLeftPedal() {
        System.out.println("SWITCHING_TO_ACCELERATE_MODE.");
        this.rover.setState(this.rover.getAccelerateForwardState());
    }

    @Override
    public void pressRightPedal() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }

    @Override
    public void pressLeftPedalOver3Secs() {
        System.out.println("SWITCHING_TO_ACCELERATE_BACKWARD_MODE.");
        this.rover.setState(this.rover.getAccelerateBackwardState());
    }
    
}
