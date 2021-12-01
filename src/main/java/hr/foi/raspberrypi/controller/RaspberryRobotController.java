package hr.foi.raspberrypi.controller;

import hr.foi.raspberrypi.config.KeyboardConfig;
import hr.foi.raspberrypi.robot.Robotic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

@Component
public class RaspberryRobotController implements KeyListener {

    private final Map<String, Runnable> map;
    private final Robotic robotic;

    @Autowired
    public RaspberryRobotController(final KeyboardConfig config, final Robotic robotic) throws InterruptedException {
        Frame f = new Frame();
        f.setVisible(true);
        f.addKeyListener(this);
        map = new HashMap<>();
        map.put(config.getForward(), robotic::forward);
        map.put(config.getBackward(), robotic::backward);
        map.put(config.getLeft(), robotic::left);
        map.put(config.getRight(), robotic::right);
        this.robotic = robotic;
        robotic.forward();
        Thread.sleep(500);
        robotic.neutralize();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        map.getOrDefault(KeyEvent.getKeyText(e.getKeyCode()), () -> {
        }).run();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        robotic.neutralize();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}