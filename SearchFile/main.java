package SearchFile;

import java.io.File;

public class main {
    public static void main(String[] args) {
        String keyword = "nelson";
        File files = new File("C:\\Users\\alunos\\IdeaProjects\\Threads\\src\\arquivosNomes");
        File[] arq = files.listFiles();

        assert arq != null;
        for (File file : arq){
            Thread thread = new Thread(new ThreadA(keyword, file));
            thread.start();
        }
    }
}
