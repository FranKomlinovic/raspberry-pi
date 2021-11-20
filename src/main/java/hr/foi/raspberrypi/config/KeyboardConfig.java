package hr.foi.raspberrypi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "keyboard")
public class KeyboardConfig {
    private String forward;
    private String backward;
    private String left;
    private String right;

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = capitalizeFirst(forward);
    }

    public String getBackward() {
        return backward;
    }

    public void setBackward(String backward) {
        this.backward = capitalizeFirst(backward);
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = capitalizeFirst(left);
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = capitalizeFirst(right);
    }

    private String capitalizeFirst(final String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
