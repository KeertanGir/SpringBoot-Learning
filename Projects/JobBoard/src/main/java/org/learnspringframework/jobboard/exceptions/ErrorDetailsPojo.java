package org.learnspringframework.jobboard.exceptions;

import java.time.LocalDate;

public class ErrorDetailsPojo {

    private String status;
    private String message;
    private LocalDate timestamp;
    private String details;

    public ErrorDetailsPojo(int status, String message, LocalDate timestamp, String details) {
        this.status = String.valueOf(status);
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }
}
