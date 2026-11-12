package studytrack;

import java.time.LocalDate;

/** An exam item with study topics. */
public final class Exam extends StudyItem {
    private final String topics;
    public Exam(String id, String title, String course, LocalDate dueDate, String topics) {
        super(id, title, course, dueDate);
        if (topics == null || topics.isBlank()) throw new IllegalArgumentException("topics cannot be blank");
        this.topics = topics.trim();
    }
    public String getTopics() { return topics; }
    @Override public String getDetails() { return "Study topics: " + topics; }
}
