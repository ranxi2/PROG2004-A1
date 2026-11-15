import java.time.LocalTime;

public class Appointment {

    private final Patient patient;
    private final HealthProfessional professional;
    private final LocalTime time;

    public Appointment(Patient patient, HealthProfessional professional, LocalTime time) {
        if (patient == null || professional == null || time == null) {
            throw new IllegalArgumentException("Patient, professional and time are all required.");
        }
        this.patient = patient;
        this.professional = professional;
        this.time = time;
    }

    public Patient getPatient() { return patient; }
    public HealthProfessional getProfessional() { return professional; }
    public LocalTime getTime() { return time; }

    @Override
    public String toString() {
        return String.format("%s | Patient: %s | Professional: %s",
                time, patient, professional);
    }
}
