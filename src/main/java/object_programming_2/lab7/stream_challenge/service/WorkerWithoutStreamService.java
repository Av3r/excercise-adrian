package object_programming_2.lab7.stream_challenge.service;

import object_programming_2.lab7.stream_challenge.model.Worker;
import object_programming_2.lab7.stream_challenge.repository.CsvWorkerRepository;
import object_programming_2.lab7.stream_challenge.repository.WorkerRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class WorkerWithoutStreamService implements WorkerService {

    private WorkerRepository workerRepository;

    public WorkerWithoutStreamService(Path filePath) {
        workerRepository = new CsvWorkerRepository(filePath);
    }

    @Override
    public List<Worker> findAll() throws IOException {
        return workerRepository.findAll();
    }

    @Override
    public List<Worker> findTop10TheRichestMaleWorkers() {
        //TODO
        throw new NotImplementedException();
    }

}
