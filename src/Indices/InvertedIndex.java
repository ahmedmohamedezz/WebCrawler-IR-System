package Indices;


import PostingLists.InvertedPostingList;
import Sources.SourceRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvertedIndex {
    int noOfSources;
    // index index[temp] = posting list
    HashMap<String, InvertedPostingList> index;

    // sources (documents) used to build the index
    HashMap<Integer, SourceRecord> sources;


    public InvertedIndex() {
        index = new HashMap<>();
        sources = new HashMap<>();
    }

    private void processDocument(int docId, String[] words) {
        for (String word : words) {
            if (!index.containsKey(word))
                index.put(word, new InvertedPostingList());

            index.get(word).insertDocument(docId);
        }
    }

    public void build(ArrayList<SourceRecord> sourceRecords) {
        // store sources
        for (SourceRecord sourceRecord : sourceRecords) {
            sources.put(sourceRecord.getId(), sourceRecord);
            processDocument(sourceRecord.getId(), sourceRecord.getWords());
        }
    }

    public void printIndex() {
        System.out.printf("%-7s %-5s%n", "Term", "Collection Frequency");
        for (Map.Entry<String, InvertedPostingList> entry : index.entrySet()) {
            System.out.printf("%-7s %-5s%n", entry.getKey(), entry.getValue().getDocumentFreq());
            entry.getValue().printDetails();
            System.out.println();
        }
    }

}
