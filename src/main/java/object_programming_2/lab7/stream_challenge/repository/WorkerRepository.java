package object_programming_2.lab7.stream_challenge.repository;

import object_programming_2.lab7.stream_challenge.model.Worker;

import java.io.IOException;
import java.util.List;

public interface WorkerRepository {

    List<Worker> findAll() throws IOException;

}
