import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppointmentManager {

    public static final LocalTime START = LocalTime.of(8, 0);
    public static final LocalTime END   = LocalTime.of(16, 0);
    public static final int INTERVAL_MINUTES = 30;

    private final List<Appointment> appointments = new ArrayList<>();

    public static List<LocalTime> generateSlots(LocalTime start, LocalTime end, int stepMinutes) {
        List<LocalTime> slots = new ArrayList<>();
        LocalTime t = start;
        while (t.isBefore(end)) {
            slots.add(t);
            t = t.plusMinutes(stepMinutes);
        }
        return slots;
    }

    public String addAppointment(Appointment appointment) {
        if (appointment == null) {
            return "ERROR: Appointment cannot be null.";
        }
        for (Appointment existing : appointments) {
            if (existing.getProfessional().equals(appointment.getProfessional())
                    && existing.getTime().equals(appointment.getTime())) {
                return "ERROR: " + appointment.getProfessional().getName()
                        + " is already booked at " + appointment.getTime() + ".";
            }
        }
        appointments.add(appointment);
        return "SUCCESS: Appointment added for " + appointment.getPatient().getName()
                + " at " + appointment.getTime() + ".";
    }

    public List<Appointment> getByProfessionalId(String id) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getProfessional().getId().equals(id)) {
                result.add(a);
            }
        }
        return result;
    }

    public List<Appointment> getByPatientPhone(String phone) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getPatient().getMobile().equals(phone)) {
                result.add(a);
            }
        }
        return result;
    }

    // Sort by appointment time using a Comparator (no interface implementation needed)
    public List<Appointment> getAllSorted() {
        List<Appointment> copy = new ArrayList<>(appointments);
        copy.sort(Comparator.comparing(Appointment::getTime));
        return copy;
    }

    public String cancelByIdAndTime(String id, LocalTime time) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getProfessional().getId().equals(id) && a.getTime().equals(time)) {
                appointments.remove(i);
                return "SUCCESS: Cancelled appointment for " + a.getPatient().getName()
                        + " at " + time + ".";
            }
        }
        return "ERROR: No appointment found for professional " + id + " at " + time + ".";
    }

    public String cancelByPatientPhone(String phone) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getPatient().getMobile().equals(phone)) {
                appointments.remove(i);
                return "SUCCESS: Cancelled appointment for " + a.getPatient().getName() + ".";
            }
        }
        return "ERROR: No appointment found for phone " + phone + ".";
    }
}

