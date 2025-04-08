package SearchFile;

import java.io.*;
import java.util.concurrent.Semaphore;

public class Search {

    private File f;
    private Semaphore sem = new Semaphore(2);

    private String word;

    public Search(String word, File file) {
        this.f = file;
        this.word = word;
    }

    public File getF() {
        return f;
    }

    public void setF(File f) {
        this.f = f;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void searchFile() throws IOException {
        try {
            sem.acquire();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

            FileReader arq = new FileReader(getF());
            BufferedReader reader = new BufferedReader(arq);
            String line = reader.readLine();
            int ocurrency = 1;
            while (line != null){
                if (line.toLowerCase().contains(this.word.toLowerCase())){
                    System.out.println(getF().getName() + " - linha: " + ocurrency + " - " +
                    line);
                }
                line = reader.readLine();
                ocurrency++;
            }

        sem.release();
    }



}
