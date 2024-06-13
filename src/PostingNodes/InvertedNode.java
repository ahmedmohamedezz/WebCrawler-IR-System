package PostingNodes;

/**
 * Each Node represents document, in which the term appeared.
 */
public class InvertedNode {
    // document identifier for term
    // once assigned => never changes => declared final
    protected final int docId;

    // dtf => frequency of 'term' in this document 'docId'
    protected int documentTermFreq;

    protected InvertedNode next;   // reference to the next node

    public InvertedNode(int docId) {
        this.docId = docId;
        documentTermFreq = 1;
        next = null;
    }

    public int getDocId() {
        return docId;
    }

    public int getDocumentTermFreq() {
        return documentTermFreq;
    }

    public void setDocumentTermFreq(int documentTermFreq) {
        this.documentTermFreq = documentTermFreq;
    }

    public void incrementDocumentTermFreq() {
        setDocumentTermFreq(getDocumentTermFreq() + 1);
    }

    public InvertedNode getNext() {
        return next;
    }

    public void setNext(InvertedNode next) {
        this.next = next;
    }
}
