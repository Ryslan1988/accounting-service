package by.javaguru.jdmik12.accountingservice.service.impl;

import by.javaguru.jdmik12.accountingservice.model.message.event.AllocateBudgetEvent;
import by.javaguru.jdmik12.accountingservice.service.AccountingService;
import by.javaguru.jdmik12.accountingservice.utils.JsonInputProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountingServiceImpl implements AccountingService {
    private final JsonInputProcess jsonInputProcess;

    @Override
    public AllocateBudgetEvent getMockJsonById(long requestId) {
        return jsonInputProcess.jsonFileProcessUpdaterFromMongo(requestId);
    }

}
