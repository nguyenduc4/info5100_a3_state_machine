/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package a3_statemachinediagram;

import LunarRover.LunarRover;

/**
 *
 * @author Duc Nguyen
 */
public class A3_StateMachineDiagram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a LunarRover object
        LunarRover rover = new LunarRover();

        // Test Case 1: Start in Idle, press left pedal to accelerate forward
        System.out.println("====== Test Case 1: Accelerating Forward ======");
        rover.pressLeftPedal();  
        System.out.println("Current State: " + rover.getCurrentState());
        System.out.println("--------------------------------------------------------\n");

        // Test Case 2: Press right pedal to decelerate
        System.out.println("====== Test Case 2: Decelerating ======");
        rover.pressRightPedal();  
        System.out.println("Current State: " + rover.getCurrentState());

        System.out.println("\n**Decelerating to Idle**");
        rover.pressRightPedal();  
        System.out.println("Current State: " + rover.getCurrentState());
        System.out.println("--------------------------------------------------------\n");

        // Test Case 3: Press button 1 twice to switch to drill mode
        System.out.println("====== Test Case 3: Switching to Drill Mode ======");
        rover.pressButton1Twice();  
        System.out.println("Current State: " + rover.getCurrentState());
        System.out.println("--------------------------------------------------------\n");

        // Test Case 4: Press button 1 to turn off drill
        System.out.println("====== Test Case 4: Turning Off Drill ======");
        rover.pressButton1();  
        System.out.println("Current State: " + rover.getCurrentState());
        System.out.println("--------------------------------------------------------\n");

        // Test Case 5: Hold button 1 for 5 seconds to switch to color camera mode
        System.out.println("====== Test Case 5: Switching to Color Camera Mode ======");
        rover.pressButton1For5Secs();  
        System.out.println("Current State: " + rover.getCurrentState());
        System.out.println("--------------------------------------------------------\n");

        // Test Case 6: Take a picture in color camera mode
        System.out.println("====== Test Case 6: Taking Picture in Color Camera Mode ======");
        rover.pressButton1();  
        System.out.println("Current State: " + rover.getCurrentState());
        System.out.println("--------------------------------------------------------\n");

        // Test Case 7: Taking Temporizer Picture (holding button for 5 secs)
        System.out.println("====== Test Case 7: Taking Temporizer Picture ======");
        rover.pressButton1For5Secs();  
        System.out.println("Current State: " + rover.getCurrentState());
        System.out.println("--------------------------------------------------------\n");
        
        // Test Case 8: Switch from color camera to 16mm camera mode (holding button for 5 secs)
        System.out.println("====== Test Case 8: Switching To 16mm Camera Mode ======");
        rover.pressButton1For10Secs();  
        System.out.println("Current State: " + rover.getCurrentState());
        System.out.println("--------------------------------------------------------\n");

        // Test Case 9: Press button 2 to go back to Idle state from Camera mode
        System.out.println("====== Test Case 9: Switching Back to Idle Mode ======");
        rover.pressButton2();  
        System.out.println("Current State: " + rover.getCurrentState());
        System.out.println("--------------------------------------------------------\n");

        // Test Case 10: Return to Idle and Accelerate Forward after Camera mode
        System.out.println("====== Test Case 10: Switching from Idle to Accelerate Forward ======");
        rover.pressButton2();  
        System.out.println("Current State: " + rover.getCurrentState());
        
        System.out.println("\n**Accelerating Forward**");
        rover.pressLeftPedal();  
        System.out.println("Current State: " + rover.getCurrentState());
        System.out.println("--------------------------------------------------------\n");

        // Test Case 11: Return to Idle
        System.out.println("====== Test Case 11: Switching from Forward to Accelerate Backward ======");
        System.out.println("**Returning to Idle first**");
        rover.pressButton2();  
        System.out.println("Current State: " + rover.getCurrentState());
        
        System.out.println("\n**Decelerating to Idle**");
        rover.pressRightPedal();  
        rover.pressRightPedal();  
        System.out.println("Current State: " + rover.getCurrentState());
        
        System.out.println("\n**Accelerate Backward**");
        rover.pressLeftPedalOver3Secs();  
        System.out.println("Current State: " + rover.getCurrentState());
        System.out.println("--------------------------------------------------------\n");
    }
}
