/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LunarRover;

import State.State;
import State.IdleState;
import State.ForwardState;
import State.BackwardState;
import State.DeaccelerateState;
import State.DrillOnState;
import State.DrillOffState;
import State.ColorCameraState;
import State._16mmCameraState;
import State.ConstantlyState;



/**
 *
 * @author Duc Nguyen
 */
public class LunarRover {
    private State idleState;
    
    private State lastAccelerateState;
    
    private State accelerateForwardState;
    private State accelerateConstantlyState;
    private State deacceleratingState;
    
    private State backwardState;
    private State accelerateBackwardConstantlyState;
    
    private State drillOnState;
    private State drillOffState;
    
    private State colorCameraState;
    private State _16mmCameraState;
    
    private State currentState;
    
    public LunarRover() { 
        this.idleState = new IdleState(this);
           
        this.lastAccelerateState = null;
        this.accelerateForwardState = new ForwardState(this);
        this.accelerateConstantlyState = new ConstantlyState(this);
        this.deacceleratingState = new DeaccelerateState(this);
        
        this.backwardState = new BackwardState(this);
        this.accelerateBackwardConstantlyState = new ConstantlyState(this);
        
        this.drillOnState = new DrillOnState(this);
        this.drillOffState = new DrillOffState(this);
        
        this.colorCameraState = new ColorCameraState(this);
        this._16mmCameraState = new _16mmCameraState(this);
        
        // * Initial state of LunarRover is Idle
        this.currentState = this.idleState;
    }
    
    public void setState(State state){
        this.currentState = state;
    }
    
    public State getCurrentState() { 
        return this.currentState;
    }
    
    public void pressButton1() { 
        this.currentState.pressButton1();
    }
    
    public void pressButton1For5Secs() {
        this.currentState.pressButton1For5Secs();
    }
    
    public void pressButton1For10Secs() { 
        this.currentState.pressButton1For10Secs();
    }

    public void pressButton1Twice() {
        this.currentState.pressButton1Twice();
    }

    public void pressButton2() {
        this.currentState.pressButton2();
    }

    public void pressLeftPedal() {
        this.currentState.pressLeftPedal();
    }
    
    public void pressLeftPedalOver3Secs() { 
        this.currentState.pressLeftPedalOver3Secs();
    }

    public void pressRightPedal() {
        this.currentState.pressRightPedal();
    }

    // Getter methods for each state
    public State getIdleState() {
        return this.idleState;
    }
    
    /*
        These methods support the switching sate to accelerate
    */
    public void setLastAccelerateState(State state) { 
        this.lastAccelerateState = state;
    }
    
    public State getLastAccelerateState() { 
        return this.lastAccelerateState;
    }
    
    public State getAccelerateForwardState() {
        return this.accelerateForwardState;
    }
    
    public State getAccelerateContantlyState() { 
        return this.accelerateConstantlyState;
    }
    
    public State getDeacceleratingState() { 
        return this.deacceleratingState;
    }

    public State getAccelerateBackwardState() {
        return this.backwardState;
    }
    
    public State getAccelerateBackwardContantlyState(){  
        return this.accelerateBackwardConstantlyState;
    }
    
    /*
        These methods support the On and off State of drill
    */
    public State getDrillOnState() {
        return this.drillOnState;
    }
    
    public State getDrillOffState() { 
        return this.drillOffState;
    }
    
    /*
        These two methods support the switching state when in Camera_mode
        How to use:
            - hold button 1 - 5 seconds => color camera mode
            - hold button 1 - 10 seconds => 16mm camera mode
    */
    public State getColorCameraState() {
        return this.colorCameraState;
    }
    
    public State get16mmCameraState() {
        return this._16mmCameraState;
    }
}
