package hr.foi.raspberrypi.robot;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import hr.foi.raspberrypi.config.RaspberryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class RaspberryPiRobot implements Robotic {
    private final GpioPinDigitalOutput rightBackward;
    private final GpioPinDigitalOutput rightForward;
    private final GpioPinDigitalOutput leftBackward;
    private final GpioPinDigitalOutput leftForward;

    @Autowired
    public RaspberryPiRobot(final RaspberryConfig raspberryConfig) {
        final GpioController gpio = GpioFactory.getInstance();
        rightBackward = gpio.provisionDigitalOutputPin(raspberryConfig.getRightBackward(), "rightBackward", PinState.LOW);
        rightForward = gpio.provisionDigitalOutputPin(raspberryConfig.getRightForward(), "rightForward", PinState.LOW);
        leftBackward = gpio.provisionDigitalOutputPin(raspberryConfig.getLeftBackward(), "leftBackward", PinState.LOW);
        leftForward = gpio.provisionDigitalOutputPin(raspberryConfig.getLeftForward(), "leftForward", PinState.LOW);

    }

    @Override
    public void forward() {
        rightForward.high();
        leftForward.high();
    }

    @Override
    public void backward() {
        rightBackward.high();
        leftBackward.high();
    }

    @Override
    public void left() {
        leftBackward.high();
        rightForward.high();
    }

    @Override
    public void right() {
        rightBackward.high();
        leftForward.high();
    }

    @Override
    public void neutralize() {
        rightForward.low();
        rightBackward.low();
        leftBackward.low();
        leftForward.low();
    }

}
