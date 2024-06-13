package Views;

import Indices.*;
import Controllers.SourceRecordController;

public class Main {
    public static void main(String[] args) {
        InvertedIndex invertedIndex = new InvertedIndex();

        // check the 'documents' directory, and the files inside it
        String documentsPath = "documents/";

        invertedIndex.build(SourceRecordController.fetchSources(documentsPath));

        invertedIndex.printIndex();
    }
}