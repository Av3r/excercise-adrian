package object_programming.lab2.words;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String filePath = System.getProperty("user.home") + "/textforwords.txt";
        CountWords cw = new CountWords(filePath);
        List<String> result = cw.getResult();
        for(String wordRes : result){
            System.out.println(wordRes);
        }
    }

}
