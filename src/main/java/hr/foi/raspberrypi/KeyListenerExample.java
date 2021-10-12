package hr.foi.raspberrypi;


import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerState;

// got from https://www.javatpoint.com/java-keylistener
public class KeyListenerExample {
    Robot robot;
    ControllerManager controllers;

    KeyListenerExample() {
//        robot = new Robot();
        controllers = new ControllerManager();
        controllers.initSDLGamepad();
    }

    public void start() {
        while (true) {
            final ControllerState state = controllers.getState(0);
            if (state.isConnected) {
                moveRobot(state);
            } else {
                System.out.println("Not connected");

            }
        }
    }

    private void moveRobot(ControllerState state) {
        if(state.dpadUpJustPressed) {
            System.out.println("UP");
        }
        if(state.dpadDownJustPressed) {
            System.out.println("DOWN");
        }
        if(state.dpadLeftJustPressed) {
            System.out.println("LEFT");
        }
        if(state.dpadRightJustPressed) {
            System.out.println("RIGHT");
        }
    }
}