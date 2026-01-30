package by.javaguru.jdmk13.accountingservice.service.impl;

import by.javaguru.jdmk13.accountingservice.model.AccountingRequestDto;
import by.javaguru.jdmk13.accountingservice.model.AccountingResponseDto;
import by.javaguru.jdmk13.accountingservice.service.AccountingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountingServiceImpl implements AccountingService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public AccountingResponseDto getMockJsonById(AccountingRequestDto requestDto) throws IOException {
        return jsonFileUpdater(requestDto.getRequestId());

    }

    private AccountingResponseDto jsonFileUpdater(long id) throws IOException {
        Random random = new Random();
        String filePath = "src/main/resources/data.json";
        String readString = Files.readString(Paths.get(filePath));
        if (StringUtils.isBlank(readString)) {
            AccountingResponseDto accountingResponseDto = new AccountingResponseDto(
                    random.nextInt(101), id, Math.random() < 0.5);
            objectMapper.writeValue(new File(filePath), List.of(accountingResponseDto));
            return accountingResponseDto;
        }
        List<AccountingResponseDto> accountingResponseDtos = List.of(objectMapper.readValue(readString, AccountingResponseDto[].class));

        for (AccountingResponseDto responseDto : accountingResponseDtos) {
            if (responseDto.getRequestId() == id) {
                return responseDto;
            }
        }

        AccountingResponseDto accountingResponseDto = new AccountingResponseDto(
                random.nextInt(101), id, Math.random() < 0.5);
        List<AccountingResponseDto> resList = new ArrayList<>(accountingResponseDtos);
        resList.add(accountingResponseDto);

        objectMapper.writeValue(new File(filePath), resList);

        return accountingResponseDto;
    }
}
