// ---------- Nurse ----------
import java.time.DayOfWeek;
import java.util.EnumSet;

public class Nurse extends HealthProfessional {

    private final String shift;

    public Nurse(String id, String name, EnumSet<DayOfWeek> days, String shift) {
        super(id, name, days);
        this.shift = shift;
    }

    public Nurse(String id, String name, String shift) {
        super(id, name);
        this.shift = shift;
    }

    public String getShift() { return shift; }

    public void takeBloodSample(String patientName) {
        System.out.println(getName() + " takes a blood sample from " + patientName + ".");
    }

    @Override
    public String getRole() { return "Nurse"; }

    @Override
    public String toString() { return super.toString() + " | Shift: " + shift; }
}

