package object_programming_2.lab7.stream_challenge;

import object_programming_2.lab7.stream_challenge.model.Worker;
import object_programming_2.lab7.stream_challenge.service.WorkerService;
import object_programming_2.lab7.stream_challenge.service.WorkerStreamService;
import object_programming_2.lab7.stream_challenge.service.WorkerWithoutStreamService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String WORKERS_FILENAME = "workers.csv";
    private static final String USER_HOME = "user.home";

    public static void main(String[] args) throws IOException {
        String home = System.getProperty(USER_HOME);
        Path filePath = Paths.get(home + File.separator + WORKERS_FILENAME);

        WorkerService workerStreamService = new WorkerStreamService(filePath);
        WorkerService workerWithoutStreamService = new WorkerWithoutStreamService(filePath);

        System.out.println("Top 10 workers using stream");
        findTop10(workerStreamService);

        System.out.println("Top 10 workers without using stream");
        findTop10(workerWithoutStreamService);
    }

    private static void findTop10(WorkerService workerService) throws IOException {
        long start = System.currentTimeMillis();

        List<Worker> workers = workerService.findTop10TheRichestMaleWorkers();
        workers.forEach(System.out::println);

        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println(String.format("Execution took: %d[s] ", TimeUnit.MILLISECONDS.toSeconds(total)));
        System.out.println("***************************************");
    }


}
