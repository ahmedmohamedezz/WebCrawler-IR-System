package Sources;

public class SourceRecord {
    final private int id;
    final private String location;
    final private String title;
    private int length;
    final private String[] words;

    public SourceRecord(int id, String title, String location, String[] words) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.words = words;
        this.length = words.length;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String[] getWords() {
        return words;
    }

    public void printWords() {
        for (int i = 0; i < words.length; ++i) {
            System.out.print(words[i]);
            if (i < words.length - 1)
                System.out.print(", ");
        }
    }
}
