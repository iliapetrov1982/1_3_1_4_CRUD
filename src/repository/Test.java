package repository;

import java.io.*;
import java.util.ArrayList;

public class Test {
    private String inFileName;
    private String outFileName;

    public Test(String inFileName, String outFileName) {
        this.inFileName = inFileName;
        this.outFileName = outFileName;
    }

    public void read() {
        try (BufferedReader in  = new BufferedReader(new FileReader(inFileName));
             PrintWriter out = new PrintWriter(new FileWriter(outFileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
