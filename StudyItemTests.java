package studytrack;

import java.time.LocalDate;

public final class StudyItemTests {
    private StudyItemTests() { }
    public static void main(String[] args) {
        LocalDate due = LocalDate.of(2026, 11, 20);
        StudyItem assignment = new Assignment("A1", "Arrays lab", "CISC 191", due, 2.5);
        StudyItem exam = new Exam("E1", "Java exam", "CISC 191", due, "inheritance, arrays");
        check(assignment.getTitle().equals("Arrays lab"), "assignment title");
        check(assignment.getDetails().contains("2.5"), "assignment details via superclass reference");
        check(exam.getDetails().contains("inheritance"), "exam details via superclass reference");
        assignment.markComplete();
        check(assignment.isComplete(), "mark complete");
        check(!exam.isComplete(), "new items start incomplete");
        expectInvalid(() -> new Assignment("A2", "Bad", "CISC 191", due, -1));
        expectInvalid(() -> new Exam("E2", "Bad", "CISC 191", due, " "));
        System.out.println("All StudyItem checks passed.");
    }
    private static void check(boolean condition, String label) {
        if (!condition) throw new AssertionError("Failed: " + label);
    }
    private static void expectInvalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Expected IllegalArgumentException");
    }
}
