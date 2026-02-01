package by.javaguru.jdmik12.accountingservice.api.exception;

import java.time.ZonedDateTime;

public record ErrorResponse(int statusCode, String message, ZonedDateTime timeStamp) {
}
