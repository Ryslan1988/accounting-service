package by.javaguru.jdmik12.accountingservice.utils;

import by.javaguru.jdmik12.accountingservice.model.entity.User;
import by.javaguru.jdmik12.accountingservice.model.message.event.AllocateBudgetEvent;
import by.javaguru.jdmik12.accountingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class JsonInputProcess {
    private final UserRepository userRepository;
    private final Random random = new Random();

    public AllocateBudgetEvent jsonFileProcessUpdaterFromMongo(long id) {
        List<User> byRequestId = userRepository.findByRequestId(String.valueOf(id));

        if (byRequestId.isEmpty()) {
            User user = User.builder()
                    .id(String.valueOf(random.nextInt(1000001)))
                    .requestId(String.valueOf(id))
                    .allocated(String.valueOf(Math.random() < 0.5))
                    .build();
            userRepository.save(user);

            return AllocateBudgetEvent.builder()
                    .withId(user.getId())
                    .withRequestId(user.getRequestId())
                    .withAllocated(user.getAllocated())
                    .build();
        } else {
            User firstUser = byRequestId.stream().findFirst().get();
            return AllocateBudgetEvent.builder()
                    .withId(firstUser.getId())
                    .withRequestId(firstUser.getRequestId())
                    .withAllocated(firstUser.getAllocated())
                    .build();
        }

    }
}
