package by.javaguru.jdmik12.accountingservice.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Builder
@Getter
public class User {
    @Id
    private String id;
    private String requestId;
    private String allocated;
}
