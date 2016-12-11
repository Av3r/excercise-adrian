package object_programming_2.lab7.stream_challenge.repository;

import object_programming_2.lab7.stream_challenge.converter.WorkerConverter;
import object_programming_2.lab7.stream_challenge.model.Worker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvWorkerRepository implements WorkerRepository {

    private static final int HEADER_ROWS_COUNT = 1;

    private WorkerConverter converter = new WorkerConverter();
    private Path filePath;

    public CsvWorkerRepository(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Worker> findAll() throws IOException {
        return Files.readAllLines(filePath).stream()
                .skip(HEADER_ROWS_COUNT)
                .map(converter::convert)
                .collect(Collectors.toList());
    }

}
