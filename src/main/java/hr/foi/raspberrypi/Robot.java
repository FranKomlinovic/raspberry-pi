package hr.foi.raspberrypi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Robot {
    private GpioPinDigitalOutput rightBackward;
    private GpioPinDigitalOutput rightForward;
    private GpioPinDigitalOutput leftBackward;
    private GpioPinDigitalOutput leftForward;
    private GpioPinDigitalOutput rightIndicator;
    private GpioPinDigitalOutput leftIndicator;
    private GpioPinDigitalOutput lights;
    private boolean indicators;

    private GpioController gpio;

    public Robot() {
        gpio = GpioFactory.getInstance();
        rightBackward = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, "rightBackward", PinState.LOW);
        rightForward = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "rightForward", PinState.LOW);
        leftBackward = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "leftBackward", PinState.LOW);
        leftForward = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "leftForward", PinState.LOW);
    }

    public void forward() {
        rightForward.high();
        leftForward.high();
    }

    public void backward() {
        rightBackward.high();
        leftBackward.high();
    }

    public void left() {
        leftBackward.high();
        rightForward.high();
    }

    public void right() {
        rightBackward.high();
        leftForward.high();
    }

    public void neutralize() {
        rightForward.low();
        rightBackward.low();
        leftBackward.low();
        leftForward.low();
    }

    public void leftIndicator() {
        indicators = true;
        while (indicators) {
            try {
                leftIndicator.high();
                Thread.sleep(900);
                leftIndicator.low();
                Thread.sleep(900);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void rightIndicator() {
        indicators = true;
        while (indicators) {
            try {
                rightIndicator.high();
                Thread.sleep(900);
                rightIndicator.low();
                Thread.sleep(900);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void allIndicators() {
        indicators = true;
        while (indicators) {
            try {
                rightIndicator.high();
                leftIndicator.high();
                Thread.sleep(900);
                rightIndicator.low();
                leftIndicator.low();
                Thread.sleep(900);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void turnOffIndicators() {
        indicators = false;
    }

    public void turnOnLights() {
        lights.high();
    }

    public void turnOffLights() {
        lights.low();
    }

    public void turnOff() {
        gpio.shutdown();
    }
}
