package by.javaguru.jdmk13.accountingservice.service.impl;

import by.javaguru.jdmk13.accountingservice.model.AccountingRequestDto;
import by.javaguru.jdmk13.accountingservice.model.AccountingResponseDto;
import by.javaguru.jdmk13.accountingservice.service.AccountingService;
import by.javaguru.jdmk13.accountingservice.utils.JsonInputProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AccountingServiceImpl implements AccountingService {
    private final JsonInputProcess jsonInputProcess;

    @Override
    public AccountingResponseDto getMockJsonById(AccountingRequestDto requestDto) throws IOException {
        return jsonInputProcess.jsonFileProcessUpdater(requestDto.getRequestId());
    }

}
