package object_programming_2.lab7.stream_challenge.service;

import object_programming_2.lab7.stream_challenge.model.Worker;
import object_programming_2.lab7.stream_challenge.repository.CsvWorkerRepository;
import object_programming_2.lab7.stream_challenge.repository.WorkerRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static object_programming_2.lab7.stream_challenge.model.GenderType.MALE;

public class WorkerStreamService implements WorkerService {

    private static final int TOP_TEN = 10;

    private WorkerRepository workerRepository;

    public WorkerStreamService(Path filePath) {
        workerRepository = new CsvWorkerRepository(filePath);
    }

    @Override
    public List<Worker> findAll() throws IOException {
        return workerRepository.findAll();
    }

    @Override
    public List<Worker> findTop10TheRichestMaleWorkers() throws IOException {
        return workerRepository.findAll().stream()
                .filter(worker -> worker.getGenderType() == MALE)
                .sorted(Comparator.comparing(Worker::getSalary).reversed())
                .limit(TOP_TEN)
                .collect(Collectors.toList());

    }

}
