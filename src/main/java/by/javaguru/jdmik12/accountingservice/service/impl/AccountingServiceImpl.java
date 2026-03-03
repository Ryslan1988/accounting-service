package by.javaguru.jdmik12.accountingservice.service.impl;

import by.javaguru.jdmik12.accountingservice.service.AccountingService;
import by.javaguru.jdmik12.accountingservice.utils.JsonInputProcess;
import by.javaguru.jdmik12.common.accounting.message.event.AllocateBudgetEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AccountingServiceImpl implements AccountingService {
    private final JsonInputProcess jsonInputProcess;

    @Override
    public AllocateBudgetEvent getMockJsonById(long requestId) throws IOException {
        return jsonInputProcess.jsonFileProcessUpdater(requestId);
    }

}
