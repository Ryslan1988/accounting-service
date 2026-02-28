package by.javaguru.jdmik12.accountingservice.listener;

import by.javaguru.jdmik12.accountingservice.service.AccountingService;
import by.javaguru.jdmik12.common.accounting.message.command.AllocateBudgetCommand;
import by.javaguru.jdmik12.common.accounting.message.event.AllocateBudgetEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
@KafkaListener(topics = "${integration.kafka.producer.accounting.topic.name}", containerFactory = "kafkaListenerContainerFactory")
public class AccountingCommandHandler {
    private final AccountingService accountingService;
    private final AllocateProducerClient allocateProducerClient;

    @KafkaHandler
    public void handleAllocatedCommand(
            @Payload AllocateBudgetCommand allocateBudgetCommand,
            @Header(KafkaHeaders.RECEIVED_KEY) String messageKey,
            @Header(KafkaHeaders.REPLY_TOPIC) String replayTopic) throws IOException {

        log.debug("Receiver allocateCommand with key {} {}", messageKey, allocateBudgetCommand);
        AllocateBudgetEvent allocateBudgetEvent = accountingService.getMockJsonById(allocateBudgetCommand.requestId());
        log.debug("Processed allocateCommand with key {}", messageKey);

        allocateProducerClient.sendMessage(messageKey, replayTopic, allocateBudgetEvent);
    }
}

