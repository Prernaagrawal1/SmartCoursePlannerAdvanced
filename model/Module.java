
import java.time.LocalDate;

public class Module {
    private String name;
    private boolean isCompleted;
    private LocalDate deadline;

    public Module(String name, LocalDate deadline) {
        this.name = name;
        this.deadline = deadline;
        this.isCompleted = false;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    public boolean isOverdue() {
        return !isCompleted && deadline.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return name + " | Due: " + deadline + " | " + (isCompleted ? "✔ Completed" : (isOverdue() ? "⚠ Overdue" : "Pending"));
    }
}
