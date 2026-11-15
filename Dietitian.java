// ---------- Dietitian ----------
import java.time.DayOfWeek;
import java.util.EnumSet;

public class Dietitian extends HealthProfessional {

    private final String dietFocus;

    public Dietitian(String id, String name, EnumSet<DayOfWeek> days, String dietFocus) {
        super(id, name, days);
        this.dietFocus = dietFocus;
    }

    public Dietitian(String id, String name, String dietFocus) {
        super(id, name);
        this.dietFocus = dietFocus;
    }

    public String getDietFocus() { return dietFocus; }

    public void createMealPlan(String patientName) {
        System.out.println(getName() + " creates a meal plan for " + patientName
                + " focusing on " + dietFocus + ".");
    }

    @Override
    public String getRole() { return "Dietitian"; }

    @Override
    public String toString() { return super.toString() + " | Focus: " + dietFocus; }
}

