package by.javaguru.jdmik12.accountingservice.service;


import by.javaguru.jdmik12.accountingservice.model.message.event.AllocateBudgetEvent;

import java.io.IOException;

public interface AccountingService {

    AllocateBudgetEvent getMockJsonById(long requestId) throws IOException;

}