// ---------- GeneralPractitioner ----------
import java.time.DayOfWeek;
import java.util.EnumSet;

public class GeneralPractitioner extends HealthProfessional {

    private final String clinicRoom;

    public GeneralPractitioner(String id, String name, EnumSet<DayOfWeek> days, String clinicRoom) {
        super(id, name, days);
        this.clinicRoom = clinicRoom;
    }

    public GeneralPractitioner(String id, String name, String clinicRoom) {
        super(id, name);
        this.clinicRoom = clinicRoom;
    }

    public String getClinicRoom() { return clinicRoom; }

    public void prescribe(String drug) {
        System.out.println(getName() + " prescribes " + drug + ".");
    }

    @Override
    public String getRole() { return "General Practitioner"; }

    @Override
    public String toString() { return super.toString() + " | Room: " + clinicRoom; }
}


