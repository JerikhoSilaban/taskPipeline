package core;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MyIo {
    public void copyIO(@NotNull Path inputPath) throws IOException {
        if (inputPath.toFile().exists()) {
            Path outputPath = Paths.get("/home/jerikho/IdeaProjects/taskPipeline/src/main/resources/output.txt");

            try (BufferedReader bufferedReader = Files.newBufferedReader(inputPath);
                 BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath);
                 Scanner scanner = new Scanner(bufferedReader);
                 PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    line = line.replace("/ ", "\n");
                    printWriter.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("File telah disalin ke direktori: " + outputPath);
        } else {
            System.out.println("Path yang diberikan tidak benar.");
        }
    }
}
