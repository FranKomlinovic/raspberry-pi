package hr.foi.raspberrypi.robot;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import hr.foi.raspberrypi.config.RaspberryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.pi4j.io.gpio.RaspiPin.getPinByName;

@Component
@Profile("prod")
public class RaspberryPiRobot implements Robotic {
    private final GpioController gpio;
    private final GpioPinDigitalOutput rightBackward;
    private final GpioPinDigitalOutput rightForward;
    private final GpioPinDigitalOutput leftBackward;
    private final GpioPinDigitalOutput leftForward;

    @Autowired
    public RaspberryPiRobot(final RaspberryConfig raspberryConfig) {
        // create gpio controller
        this.gpio = GpioFactory.getInstance();

        rightForward = createGPIO(raspberryConfig.getRightForward(), "rightForward");
        rightBackward = createGPIO(raspberryConfig.getRightBackward(), "rightBackward");
        leftForward = createGPIO(raspberryConfig.getLeftForward(), "leftForward");
        leftBackward = createGPIO(raspberryConfig.getLeftBackward(), "leftBackward");
    }

    @Override
    public void forward() {
        System.out.println("Moving raspberry forward");
        rightForward.high();
        leftForward.high();
    }

    @Override
    public void backward() {
        System.out.println("Moving raspberry backward");
        rightBackward.high();
        leftBackward.high();
    }

    @Override
    public void left() {
        System.out.println("Moving raspberry left");
        leftBackward.high();
        rightForward.high();
    }

    @Override
    public void right() {
        System.out.println("Moving raspberry right");
        rightBackward.high();
        leftForward.high();
    }

    @Override
    public void neutralize() {
        System.out.println("Neutralizing raspberry");
        rightForward.low();
        rightBackward.low();
        leftBackward.low();
        leftForward.low();
    }

    private GpioPinDigitalOutput createGPIO(Integer pinNumber, String position) {
        return gpio.provisionDigitalOutputPin(getPinByName("GPIO " + pinNumber), position, PinState.LOW);
    }

}
