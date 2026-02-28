package by.javaguru.jdmik12.accountingservice.utils;

import by.javaguru.jdmik12.accountingservice.model.AccountingResponseDto;
import by.javaguru.jdmik12.common.accounting.message.event.AllocateBudgetEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class JsonInputProcess {
    private final String FILE_PATCH = "src/main/resources/data.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Random random = new Random();

    public AllocateBudgetEvent jsonFileProcessUpdater(long id) throws IOException {
        String readString = Files.readString(Paths.get(FILE_PATCH));
        if (StringUtils.isBlank(readString)) {
            AccountingResponseDto accountingResponseDto = new AccountingResponseDto(
                    random.nextInt(101), id, Math.random() < 0.5);
            objectMapper.writeValue(new File(FILE_PATCH), List.of(accountingResponseDto));
            return AllocateBudgetEvent.builder()
                    .withRequestId(accountingResponseDto.getRequestId())
                    .withAllocated(accountingResponseDto.isAllocated())
                    .build();
        }
        List<AccountingResponseDto> accountingResponseDtoList = List.of(objectMapper.readValue(readString, AccountingResponseDto[].class));

        for (AccountingResponseDto responseDto : accountingResponseDtoList) {
            if (responseDto.getRequestId() == id) {
                return AllocateBudgetEvent.builder()
                        .withRequestId(responseDto.getRequestId())
                        .withAllocated(responseDto.isAllocated())
                        .build();
            }
        }

        AccountingResponseDto accountingResponseDto = new AccountingResponseDto(
                random.nextInt(101), id, Math.random() < 0.5);
        List<AccountingResponseDto> resList = new ArrayList<>(accountingResponseDtoList);
        resList.add(accountingResponseDto);

        objectMapper.writeValue(new File(FILE_PATCH), resList);

        return AllocateBudgetEvent.builder()
                .withRequestId(accountingResponseDto.getRequestId())
                .withAllocated(accountingResponseDto.isAllocated())
                .build();
    }
}
