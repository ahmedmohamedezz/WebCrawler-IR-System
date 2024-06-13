package Controllers;

import Sources.SourceRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SourceRecordController {
    static int curId = 1;

    public static ArrayList<SourceRecord> fetchSources(String documentsPath) {
        ArrayList<SourceRecord> sourceRecords = new ArrayList<>();
        // get list of documents
        String[] files = new File(documentsPath).list();

        // append file location to file name
        for (int i = 0; i < files.length; ++i) {
            String location = documentsPath + files[i];
            Path filePath = Paths.get(location);
            try {
                String content = Files.readString(filePath);
                String[] words = content.split("\\W+");
                sourceRecords.add(new SourceRecord(curId++, files[i], location, words));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return sourceRecords;
    }
}
