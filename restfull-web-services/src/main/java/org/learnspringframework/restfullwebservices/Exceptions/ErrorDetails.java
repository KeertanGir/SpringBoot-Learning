package org.learnspringframework.restfullwebservices.Exceptions;

import java.time.LocalDate;

public class ErrorDetails {
//   timestamp
    private LocalDate timestamp;
//    message
    private String message;
//    details
    private String details;

    public ErrorDetails(LocalDate timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
