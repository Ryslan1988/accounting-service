package by.javaguru.jdmk13.accountingservice.service;

import by.javaguru.jdmk13.accountingservice.model.AccountingRequestDto;
import by.javaguru.jdmk13.accountingservice.model.AccountingResponseDto;

import java.io.IOException;

public interface AccountingService {

    AccountingResponseDto getMockJsonById(AccountingRequestDto requestDto) throws IOException;

}