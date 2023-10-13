package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class myIO {
    public void copyIO(Path inputPath) throws IOException {
        if (inputPath.toFile().exists()) {
            Path outputPath = Paths.get("/home/jerikho/IdeaProjects/taskPipeline/src/main/resources/output.txt");

            try (Scanner scanner = new Scanner(Files.newBufferedReader(inputPath));
                 PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(outputPath))){

                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    line = line.replace("| ", "\n");

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
