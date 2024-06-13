package PostingLists;

import PostingNodes.InvertedNode;

import java.util.ArrayList;

/*
 * this class represents the base type for all posting lists, and contains the minimal structure of any posting list.
 */
public class InvertedPostingList {
    protected InvertedNode head;
    protected int documentFreq;

    public InvertedPostingList() {
        head = null;
        documentFreq = 0;
    }

    public int getDocumentFreq() {
        return documentFreq;
    }

    public boolean hasDocument(int docId) {
        /*
         * returns true if key 'docId' is found, false otherwise
         * check if the list contains a node with 'docId'
         * O(n) time complexity
         */

        InvertedNode cur = head;

        while (cur != null) {
            if (cur.getDocId() == docId)
                return true;

            cur = cur.getNext();
        }
        return false;
    }

    public void insertDocument(int docId) {
        /*
         * 'docId' to be inserted
         * if key is NOT found => add new node
         * if the key is found => increment documentTermFreq, and WILL NOT add a new node
         * O(n) time complexity
         */
        documentFreq++;
        if (head == null) {
            head = new InvertedNode(docId);
        } else {
            InvertedNode cur = head;
            InvertedNode prev = null;

            while (cur != null) {
                if (cur.getDocId() == docId) {
                    cur.incrementDocumentTermFreq();
                    return;
                }
                prev = cur;
                cur = cur.getNext();
            }

            prev.setNext(new InvertedNode(docId));
        }
    }

    public ArrayList<Integer> getDocs() {
        ArrayList<Integer> docs = new ArrayList<>();
        InvertedNode cur = head;

        while (cur != null) {
            docs.add(cur.getDocId());
            cur = cur.getNext();
        }

        return docs;
    }

    public void printDocs() {
        ArrayList<Integer> docs = getDocs();

        for (int i = 0; i < docs.size(); ++i) {
            System.out.print(docs.get(i));
            if (i < docs.size() - 1)
                System.out.print(", ");
        }

        System.out.println();
    }

    public void printDetails() {
        InvertedNode cur = head;
        while (cur != null) {
            System.out.printf(" --> in doc %d, with %d occurrences%n", cur.getDocId(), cur.getDocumentTermFreq());
            cur = cur.getNext();
        }
    }
}
