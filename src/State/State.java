/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

/**
 *
 * @author Duc Nguyen
 */
public interface State {
    // Button Action State
    void pressButton1();
    void pressButton1For5Secs();
    void pressButton1For10Secs();
    void pressButton1Twice();
    void pressButton2();
    
    // Pedal Action state
    void pressLeftPedal();
    void pressLeftPedalOver3Secs();
    void pressRightPedal();
}
