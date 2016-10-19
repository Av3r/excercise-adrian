package object_programming.lab6.string_tasks;

public class StringTask implements Runnable {

    private String text;
    private int count;
    private TaskState taskState;
    private String result;
    private boolean done;
    private boolean interrupted;

    public StringTask(String text, int count) {
        this.text = text;
        this.count = count;
        this.taskState = TaskState.CREATED;
        this.result = "";
        this.done = false;
        this.interrupted = false;
    }

    @Override
    public void run() {
        taskState = TaskState.RUNNING;
        for (int i = 0; i < count; i++) {
            if (!interrupted) {
                result += text;
            } else {
                taskState = TaskState.ABORTED;
                done = true;
                return;
            }
        }
        taskState = TaskState.READY;
        done = true;
    }

    public TaskState getState() {
        return taskState;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void abort() {
        interrupted = true;
    }

    public boolean isDone() {
        return done;
    }

    public String getResult() {
        return result;
    }
}
