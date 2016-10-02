package object_programming.lab6.letters;

public class LetterThread extends Thread {

    private char letter;
    private boolean interrupted = false;

    public LetterThread(char letter, String threadName) {
        super(threadName);
        this.letter = letter;
    }

    @Override
    public void run() {
        while (!interrupted) {
            try {
                System.out.print(letter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void interrupt() {
        this.interrupted = true;
    }
}
