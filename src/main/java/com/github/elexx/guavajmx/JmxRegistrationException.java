package com.github.elexx.guavajmx;

/**
 * If anything went wrong during registration this exception gets thrown. Have a look at the {@link #getCause()} for a more detailed reason.
 */
public class JmxRegistrationException extends Exception {
    JmxRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
