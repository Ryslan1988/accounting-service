package by.javaguru.jdmik12.accountingservice.api.controllers;

import by.javaguru.jdmik12.accountingservice.service.impl.AccountingServiceImpl;
import by.javaguru.jdmik12.accountingservice.model.AccountingRequestDto;
import by.javaguru.jdmik12.accountingservice.model.AccountingResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Tag(name = "Allocated budget")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/accounting/allocation")
@Slf4j
public class AccountingApiController {

    private final AccountingServiceImpl accountingService;

    @Operation(summary = "Get allocated budget")
    @ApiResponse(
            responseCode = "201",
            description = "CREATED",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "400", description = "BAD REQUEST - Invalid input data")
    @PostMapping
    public ResponseEntity<AccountingResponseDto> allocation(@RequestBody AccountingRequestDto requestDto) throws IOException {
        log.debug("Received allocation request: {}", requestDto);
        AccountingResponseDto accountingResponseDto = accountingService.getMockJsonById(requestDto);
        log.debug("Response allocation request: {}", accountingResponseDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(accountingResponseDto);
    }

}
