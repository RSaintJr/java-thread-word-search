package SearchFile;

import java.io.File;
import java.io.IOException;

public class ThreadA implements Runnable{
    private final Search search;

    public ThreadA(String word, File file) {
        this.search = new Search(word, file);
    }

    @Override
    public void run() {
        try {
            search.searchFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
