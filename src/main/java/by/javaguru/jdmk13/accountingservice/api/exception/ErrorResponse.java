package by.javaguru.jdmk13.accountingservice.api.exception;

import java.time.ZonedDateTime;

public record ErrorResponse(int statusCode, String message, ZonedDateTime timeStamp) {
}
