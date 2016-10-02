package object_programming.lab6.letters;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Letters letters = new Letters("ABCD");
        for (Thread t : letters.getThreads()) System.out.println(t.getName());

        letters.getThreads().forEach(Thread::start);

        Thread.sleep(5000);

        letters.getThreads().forEach(Thread::interrupt);

        System.out.println("\nProgram skończył działanie");
    }
}
