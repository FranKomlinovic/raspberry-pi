package hr.foi.raspberrypi.config;

import com.pi4j.io.gpio.RaspiPin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "robot")
public class RaspberryConfig extends RaspiPin {
    private int rightForward;
    private int rightBackward;
    private int leftForward;
    private int leftBackward;

    public int getRightForward() {
        return rightForward;
    }

    public void setRightForward(int rightForward) {
        this.rightForward = rightForward;
    }

    public int getRightBackward() {
        return rightBackward;
    }

    public void setRightBackward(int rightBackward) {
        this.rightBackward = rightBackward;
    }

    public int getLeftForward() {
        return leftForward;
    }

    public void setLeftForward(int leftForward) {
        this.leftForward = leftForward;
    }

    public int getLeftBackward() {
        return leftBackward;
    }

    public void setLeftBackward(int leftBackward) {
        this.leftBackward = leftBackward;
    }
}
