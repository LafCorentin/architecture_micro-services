package com.logevent;

import org.springframework.web.bind.annotation.*;

public class LogEvent extends ApplicationEvent {
	private String message;
	 
    public CustomSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
