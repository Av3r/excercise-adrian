package object_programming_2.lab7.stream_challenge.service;

import object_programming_2.lab7.stream_challenge.model.Worker;

import java.io.IOException;
import java.util.List;

public interface WorkerService {

    List<Worker> findAll() throws IOException;

    List<Worker> findTop10TheRichestMaleWorkers() throws IOException;

}
