package hr.foi.raspberrypi.robot;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class DummyRobot implements Robotic {

    @Override
    public void forward() {
        System.out.println("Forward ");
    }

    @Override
    public void backward() {
        System.out.println("Backward");
    }

    @Override
    public void left() {
        System.out.println("Left");
    }

    @Override
    public void right() {
        System.out.println("Right");
    }

    @Override
    public void neutralize() {
        System.out.println("Stop");
    }

}
