package by.javaguru.jdmik12.accountingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountingResponseDto {
    private long id;
    private long requestId;
    private boolean allocated;
}
