package by.javaguru.jdmik12.accountingservice.model.message.event;

import by.javaguru.jdmik12.accountingservice.model.message.KafkaMessage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder(setterPrefix = "with")
public record AllocateBudgetEvent(String id, String requestId, String allocated) implements KafkaMessage {
}
