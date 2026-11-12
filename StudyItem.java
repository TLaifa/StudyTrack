package studytrack;

import java.time.LocalDate;
import java.util.Objects;


public abstract class StudyItem {
    private final String id;
    private final String title;
    private final String course;
    private final LocalDate dueDate;
    private boolean complete;

    protected StudyItem(String id, String title, String course, LocalDate dueDate) {
        this.id = requireText(id, "id");
        this.title = requireText(title, "title");
        this.course = requireText(course, "course");
        this.dueDate = Objects.requireNonNull(dueDate, "dueDate cannot be null");
        this.complete = false;
    }

    private static String requireText(String value, String name) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException(name + " cannot be blank");
        return value.trim();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getCourse() { return course; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isComplete() { return complete; }
    public void markComplete() { complete = true; }
    public abstract String getDetails();
}
