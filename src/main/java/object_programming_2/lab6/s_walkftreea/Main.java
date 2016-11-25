package object_programming_2.lab6.s_walkftreea;

public class Main {

    public static void main(String[] args) {
        String dirName = System.getProperty("user.home")+"/UTP6dir";
        String resultFileName = "UTP6res.txt";
        Futil.processDir(dirName, resultFileName);
    }

}
