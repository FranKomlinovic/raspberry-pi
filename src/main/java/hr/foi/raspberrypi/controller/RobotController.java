package hr.foi.raspberrypi.controller;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import hr.foi.raspberrypi.config.KeyboardConfig;
import hr.foi.raspberrypi.robot.Robotic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RobotController implements NativeKeyListener {

    private final Map<String, Runnable> map;
    private final Robotic robotic;

    @Autowired
    public RobotController(final KeyboardConfig config, final Robotic robotic) throws NativeHookException {
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(this);
        map = new HashMap<>();
        map.put(config.getForward(), robotic::forward);
        map.put(config.getBackward(), robotic::backward);
        map.put(config.getLeft(), robotic::left);
        map.put(config.getRight(), robotic::right);
        this.robotic = robotic;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        map.getOrDefault(NativeKeyEvent.getKeyText(e.getKeyCode()), () -> {
        }).run();
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        robotic.neutralize();
    }
}
