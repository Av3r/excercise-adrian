package object_programming_2.lab7.stream_challenge.converter;

import object_programming_2.lab7.stream_challenge.model.GenderType;
import object_programming_2.lab7.stream_challenge.model.Worker;

import java.util.Scanner;

public class WorkerConverter {

    private static final String DELIMITER = ";";

    public Worker convert(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(DELIMITER);

        int id = scanner.nextInt();
        String firstName = scanner.next();
        String lastName = scanner.next();
        String email = scanner.next();
        String userName = scanner.next();
        GenderType gender = GenderType.fromLetter(scanner.next());
        long salary = scanner.nextLong();

        return new Worker(
                id,
                firstName,
                lastName,
                email,
                userName,
                gender,
                salary
        );

    }
}
