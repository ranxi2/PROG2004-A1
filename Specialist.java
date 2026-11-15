// ---------- Specialist ----------
import java.time.DayOfWeek;
import java.util.EnumSet;

public class Specialist extends HealthProfessional {

    private final String specialty;

    public Specialist(String id, String name, EnumSet<DayOfWeek> days, String specialty) {
        super(id, name, days);
        this.specialty = specialty;
    }

    public Specialist(String id, String name, String specialty) {
        super(id, name);
        this.specialty = specialty;
    }

    public String getSpecialty() { return specialty; }

    public void referPatient(String patientName) {
        System.out.println(getName() + " refers " + patientName + " to another specialist.");
    }

    @Override
    public String getRole() { return "Specialist"; }

    @Override
    public String toString() { return super.toString() + " | Specialty: " + specialty; }
} 