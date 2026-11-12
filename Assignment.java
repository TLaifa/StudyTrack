package studytrack;

import java.time.LocalDate;

public final class Assignment extends StudyItem {
    private final double estimatedHours;
    public Assignment(String id, String title, String course, LocalDate dueDate, double estimatedHours) {
        super(id, title, course, dueDate);
        if (!Double.isFinite(estimatedHours) || estimatedHours < 0) throw new IllegalArgumentException("estimatedHours must be a non-negative number");
        this.estimatedHours = estimatedHours;
    }
    public double getEstimatedHours() { return estimatedHours; }
    @Override public String getDetails() { return "Estimated work: " + estimatedHours + " hours"; }
}
