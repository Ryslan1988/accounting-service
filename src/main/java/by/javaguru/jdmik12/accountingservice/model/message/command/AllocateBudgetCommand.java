package by.javaguru.jdmik12.accountingservice.model.message.command;

import by.javaguru.jdmik12.accountingservice.model.message.KafkaMessage;
import by.javaguru.jdmik12.accountingservice.model.message.RequestType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder(setterPrefix = "with")
public record AllocateBudgetCommand(Long requestId, BigDecimal budget, RequestType type) implements KafkaMessage {
}
