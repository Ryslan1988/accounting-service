package by.javaguru.jdmk13.accountingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountingRequestDto {
    private long requestId;
    private String type;
    private double budget;
}
