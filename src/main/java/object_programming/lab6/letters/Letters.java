package object_programming.lab6.letters;

import java.util.ArrayList;
import java.util.List;

public class Letters {

    private List<Thread> threads = new ArrayList<>();

    public Letters(String text) {
        for (char character : text.toCharArray()) {
            threads.add(createThread(character));
        }
    }

    private Thread createThread(char letter){
        return new LetterThread(letter, "Thread " + letter);
    }

    public List<Thread> getThreads() {
        return threads;
    }
}
