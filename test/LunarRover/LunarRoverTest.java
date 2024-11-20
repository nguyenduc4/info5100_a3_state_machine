/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package LunarRover;

import State.State;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
import LunarRover.LunarRover;
/**
 *
 * @author danie
 */
public class LunarRoverTest {
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
    private LunarRover rover;
    public LunarRoverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.rover = new LunarRover();
        this.idleState = new IdleState(this.rover);
           
        this.lastAccelerateState = null;
        this.accelerateForwardState = new ForwardState(this.rover);
        this.accelerateConstantlyState = new ConstantlyState(this.rover);
        this.deacceleratingState = new DeaccelerateState(this.rover);
        
        this.backwardState = new BackwardState(this.rover);
        this.accelerateBackwardConstantlyState = new ConstantlyState(this.rover);
        
        this.drillOnState = new DrillOnState(this.rover);
        this.drillOffState = new DrillOffState(this.rover);
        
        this.colorCameraState = new ColorCameraState(this.rover);
        this._16mmCameraState = new _16mmCameraState(this.rover);
        
        // * Initial state of LunarRover is Idle
        this.currentState = this.idleState;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setState method, of class LunarRover.
     */
    @Test
    public void testSetState() {
        System.out.println("Test Case 1: Set State to backward");
        State state = this.backwardState;
        this.rover.setState(state);
        
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("BackwardState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of getCurrentState method, of class LunarRover.
     */
    @Test
    public void testGetCurrentState() {
        System.out.println("Test Case 2: Get the Current State ");
        String expResult = "IdleState";
        State result = this.rover.getCurrentState();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals(expResult, result.getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of pressButton1 method, of class LunarRover.
     */
    @Test
    public void testPressButton1() {
        System.out.println("Test Case 3: Press Button 1 from Idle State");
        this.rover.pressButton1();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("IdleState", this.rover.getCurrentState().getClass().getSimpleName());
        
        System.out.println("--------------------------");
    }

    /**
     * Test of pressButton1For5Secs method, of class LunarRover.
     */
    @Test
    public void testPressButton1For5Secs() {
        System.out.println("Test Case 4: Hold 5 secs");
        
        this.rover.pressButton1For5Secs();
        System.out.println("Press Button 1 for 5 seconds");
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("ColorCameraState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of pressButton1For10Secs method, of class LunarRover.
     */
    @Test
    public void testPressButton1For10Secs() {
        System.out.println("Test Case 5: Hold 5 secs and hold another 5 seconds");
        this.rover.pressButton1For10Secs();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("_16mmCameraState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of pressButton1Twice method, of class LunarRover.
     */
    @Test
    public void testPressButton1Twice() {
        System.out.println("Test Case 6: Presbutton 1 twice from ");
        this.rover.pressButton1For5Secs();
        this.rover.pressButton1Twice();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("DrillOnState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of pressButton2 method, of class LunarRover.
     */
    @Test
    public void testPressButton2() {
        System.out.println("Test Case 7: go back to idle state ");
        this.rover.pressButton1For5Secs();
        this.rover.pressButton2();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("IdleState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of pressLeftPedal method, of class LunarRover.
     */
    @Test
    public void testPressLeftPedal() {
        System.out.println("Test Case 8: Press left pedal - Accelerate Forward");

        this.rover.pressLeftPedal();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("ForwardState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of pressLeftPedalOver3Secs method, of class LunarRover.
     */
    @Test
    public void testPressLeftPedalOver3Secs() {
        System.out.println("Test Case 9: Accelerate Continuously");
        this.rover.pressLeftPedal();
        this.rover.pressLeftPedalOver3Secs();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("ConstantlyState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of pressRightPedal method, of class LunarRover.
     */
    @Test
    public void testPressRightPedal() {
        System.out.println("Test Case 10: Deacelerate ");
        this.rover.pressLeftPedal();
        this.rover.pressRightPedal();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("DeaccelerateState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of getIdleState method, of class LunarRover.
     */
    @Test
    public void testGetIdleState() {
        System.out.println("Test Case 11: Test Idle State ");
        String expResult = "IdleState";
        String result = this.rover.getIdleState().getClass().getSimpleName();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals(expResult, result);
        System.out.println("--------------------------");
    }

    /**
     * Test of setLastAccelerateState method, of class LunarRover.
     */
    @Test
    public void testSetLastAccelerateState() {
        System.out.println("Test Case 12: Test get last state");
        this.rover.setLastAccelerateState(this.idleState);
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("IdleState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of getLastAccelerateState method, of class LunarRover.
     */
    @Test
    public void testGetLastAccelerateState() {
        System.out.println("Test Case 12: Test get last state");
        this.rover.pressButton1For5Secs();
        this.rover.getLastAccelerateState();
        this.rover.setLastAccelerateState(this.colorCameraState);
        System.out.println(this.rover.getLastAccelerateState().getClass().getSimpleName());
        assertEquals("ColorCameraState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of getAccelerateForwardState method, of class LunarRover.
     */
    @Test
    public void testGetAccelerateForwardState() {
        System.out.println("Test Case 13: Test Accelerate forward state");
        this.rover.pressLeftPedal();
        this.rover.getAccelerateForwardState();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("ForwardState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of getAccelerateContantlyState method, of class LunarRover.
     */
    @Test
    public void testGetAccelerateContantlyState() {
        System.out.println("Test Case 14: Test Accelerate constantly state");
        this.rover.pressLeftPedal();
        this.rover.pressLeftPedalOver3Secs();
        this.rover.getAccelerateContantlyState();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("ConstantlyState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of getDeacceleratingState method, of class LunarRover.
     */
    @Test
    public void testGetDeacceleratingState() {
        System.out.println("Test Case 15: Test Deaccelerate state");
        this.rover.pressLeftPedal();
        this.rover.pressRightPedal();
        this.rover.getDeacceleratingState();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("DeaccelerateState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of getAccelerateBackwardState method, of class LunarRover.
     */
    @Test
    public void testGetAccelerateBackwardState() {
        System.out.println("Test Case 16: Test Deaccelerate state from idle");
        this.rover.pressLeftPedalOver3Secs();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("BackwardState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of getAccelerateBackwardContantlyState method, of class LunarRover.
     */
    @Test
    public void testGetAccelerateBackwardContantlyState() {
        System.out.println("Test Case 17: Test Deaccelerate contantly state from idle");
        this.rover.pressLeftPedalOver3Secs();
        this.rover.pressLeftPedalOver3Secs();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("ConstantlyState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of getDrillOnState method, of class LunarRover.
     */
    @Test
    public void testGetDrillOnState() {
        System.out.println("Test Case 18: Drill on");
        this.rover.pressButton1Twice();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("DrillOnState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of getDrillOffState method, of class LunarRover.
     */
    @Test
    public void testGetDrillOffState() {
        System.out.println("Test Case 19: Drill on then off");
        this.rover.pressButton1Twice();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        
        this.rover.pressButton2();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("IdleState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of getColorCameraState method, of class LunarRover.
     */
    @Test
    public void testGetColorCameraState() {
        System.out.println("Test Case 20: Get Color Camera");
        this.rover.pressButton1For5Secs();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("ColorCameraState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }

    /**
     * Test of get16mmCameraState method, of class LunarRover.
     */
    @Test
    public void testGet16mmCameraState() {
        System.out.println("Test Case 21: Get 16mm Camera");
        this.rover.pressButton1For5Secs();
        this.rover.pressButton1For10Secs();
        System.out.println(this.rover.getCurrentState().getClass().getSimpleName());
        assertEquals("_16mmCameraState", this.rover.getCurrentState().getClass().getSimpleName());
        System.out.println("--------------------------");
    }
    
}
