package object_programming_2.lab7.stream_challenge.service;

import object_programming_2.lab7.stream_challenge.model.Worker;
import object_programming_2.lab7.stream_challenge.repository.CsvWorkerRepository;
import object_programming_2.lab7.stream_challenge.repository.WorkerRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static object_programming_2.lab7.stream_challenge.model.GenderType.MALE;

public class WorkerWithoutStreamService implements WorkerService {

    private static final int TOP_TEN = 10;
    private WorkerRepository workerRepository;

    public WorkerWithoutStreamService(Path filePath) {
        workerRepository = new CsvWorkerRepository(filePath);
    }

    @Override
    public List<Worker> findAll() throws IOException {
        return workerRepository.findAll();
    }

    @Override
    public List<Worker> findTop10TheRichestMaleWorkers() throws IOException {
        List<Worker> workers = findAll();
        List<Worker> men = findOnlyMen(workers);
        return findTop10TheRichestWorkers(men);
    }

    private List<Worker> findOnlyMen(List<Worker> workers) {
        List<Worker> men = new ArrayList<>();
        for (Worker worker : workers) {
            if (worker.getGenderType() == MALE) {
                men.add(worker);
            }
        }
        return men;
    }

    private List<Worker> findTop10TheRichestWorkers(List<Worker> workers) {
        Collections.sort(workers, (w1, w2) -> new Long(w2.getSalary()).compareTo(w1.getSalary()));

        List<Worker> top10 = new ArrayList<>();
        int i = 0;
        for (Worker worker : workers) {
            if (i == TOP_TEN) {
                break;
            }
            top10.add(worker);
            i++;
        }

        return top10;
    }

}
