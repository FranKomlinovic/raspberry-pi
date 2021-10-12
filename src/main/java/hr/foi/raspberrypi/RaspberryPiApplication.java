package hr.foi.raspberrypi;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;

public class RaspberryPiApplication {

    public static void main(String[] args) {
//        final KeyListenerExample keyListenerExample = new KeyListenerExample();
//        keyListenerExample.start();

//        try {
//            UIManager.setLookAndFeel(U
//            IManager.getSystemLookAndFeelClassName());
//        } catch (Throwable e) {
//            System.out.println("Error setting lookandfeel");
//            e.printStackTrace();
//        }
//        run();
// Configure to use custom specification
        /* Create an event object for the underlying plugin to populate */
        Event event = new Event();

        /* Get the available controllers */
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        for (int i = 0; i < controllers.length; i++) {
            /* Remember to poll each one */
            controllers[i].poll();

            /* Get the controllers event queue */
            EventQueue queue = controllers[i].getEventQueue();

            /* For each object in the queue */
            while (queue.getNextEvent(event)) {
                /* Get event component */
                Component comp = event.getComponent();

            }
        }
    }
}
