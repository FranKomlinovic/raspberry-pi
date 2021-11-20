package hr.foi.raspberrypi.config;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "robot")
public class RaspberryConfig extends RaspiPin {
    private Pin rightForward;
    private Pin rightBackward;
    private Pin leftForward;
    private Pin leftBackward;

    public void setRightForward(int rightForward) {
        this.rightForward = createDigitalPin(rightForward);
    }

    public void setRightBackward(int rightBackward) {
        this.rightBackward = createDigitalPin(rightBackward);
    }

    public void setLeftForward(int leftForward) {
        this.leftForward = createDigitalPin(leftForward);
    }

    public void setLeftBackward(int leftBackward) {
        this.leftBackward = createDigitalPin(leftBackward);
    }

    private Pin createDigitalPin(int pinNumber) {
        return createDigitalPin(pinNumber, "GPIO " + pinNumber);
    }

    public Pin getRightForward() {
        return rightForward;
    }

    public Pin getRightBackward() {
        return rightBackward;
    }

    public Pin getLeftForward() {
        return leftForward;
    }

    public Pin getLeftBackward() {
        return leftBackward;
    }
}
