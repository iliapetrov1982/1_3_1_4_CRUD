package main.java.com.iliapetrov.crud.repository.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

class IOUtils {
    static<T> void writeToFile(List<T> objects, String fileName) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (T object : objects) {
                out.print(object.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
