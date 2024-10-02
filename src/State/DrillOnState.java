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
public class DrillOnState implements State{
    private final String DOES_NOT_WORK = "DOES_NOT_HAVE_ANY_FUNCTION.";
    private LunarRover rover ; 

    public DrillOnState(LunarRover rover) {
        this.rover = rover;
    }

    @Override
    public void pressButton1() {
        System.out.println("TURNING_OFF_DRILL");
        this.rover.setState(this.rover.getDrillOffState());
    }

    @Override
    public void pressButton1For5Secs() {
        System.out.println("SWITCHING_TO_COLOR_CAMERA");
        this.rover.setState(this.rover.getColorCameraState());
    }
    
    @Override
    public void pressButton1For10Secs() {
        System.out.println("SWITCHING_TO_16mm_CAMERA");
        this.rover.setState(this.rover.get16mmCameraState());
    }

    @Override
    public void pressButton1Twice() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }
    
    @Override
    public void pressButton2() {
        System.out.println("SWITCHING_TO_IDLE_MODE");
        this.rover.setState(this.rover.getIdleState());
    }

    @Override
    public void pressLeftPedal() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }

    @Override
    public void pressRightPedal() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }

    @Override
    public void pressLeftPedalOver3Secs() {
        System.out.println(DOES_NOT_WORK + " ___ STAYED_IN " + this.rover.getCurrentState().toString());
    }
}