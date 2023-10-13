package core;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class myMain {
    public static void main(String[] args) {
        LocalDateTime initiateDateTime = LocalDateTime.now();

        Path inputPath = Paths.get("/home/jerikho/IdeaProjects/taskPipeline/src/main/resources/dummy.txt");

        myIO theIO = new myIO();

        try {
            theIO.copyIO(inputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Duration difference = Duration.between(initiateDateTime, LocalDateTime.now());
        long milliseconds = difference.toMillis();

        System.out.println("Total waktu: " + milliseconds + " milliseconds");
    }
}