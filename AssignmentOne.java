import java.time.LocalTime;

public class AssignmentOne {

    public static void main(String[] args) {

        System.out.println("========== PART 3: Health Professionals ==========");

        HealthProfessional[] staff = {
            new GeneralPractitioner("1001", "Dr. Smith", "Room 1"),
            new GeneralPractitioner("1002", "Dr. Jones", "Room 2"),
            new GeneralPractitioner("1003", "Dr. Lee",   "Room 3"),
            new Specialist("2001", "Dr. Patel", "Cardiology"),
            new Specialist("2002", "Dr. Chen",  "Radiology"),
            new Nurse("3001", "Nurse Kim", "Morning"),
            new Dietitian("4001", "Ms. Green", "Diabetes")
        };

        for (HealthProfessional hp : staff) {
            System.out.println(hp);
        }

        System.out.println("\n========== PART 6: Appointment System ==========");

        AppointmentManager manager = new AppointmentManager();

        Patient alice = new Patient("Alice", "0411111111");
        Patient bob   = new Patient("Bob",   "0422222222");
        Patient carol = new Patient("Carol", "0433333333");

        HealthProfessional gp    = staff[0];
        HealthProfessional spec  = staff[3];
        HealthProfessional nurse = staff[5];

        System.out.println(manager.addAppointment(new Appointment(alice, gp, LocalTime.of(9, 0))));
        System.out.println(manager.addAppointment(new Appointment(bob, gp, LocalTime.of(9, 30))));
        System.out.println(manager.addAppointment(new Appointment(carol, spec, LocalTime.of(10, 0))));
        System.out.println(manager.addAppointment(new Appointment(alice, nurse, LocalTime.of(11, 0))));

        System.out.println("\n-- Attempt double booking (error case) --");
        System.out.println(manager.addAppointment(new Appointment(carol, gp, LocalTime.of(9, 0))));

        System.out.println("\n-- All appointments (sorted by time) --");
        for (Appointment a : manager.getAllSorted()) {
            System.out.println(a);
        }

        System.out.println("\n-- Filter by professional ID 1001 --");
        for (Appointment a : manager.getByProfessionalId("1001")) {
            System.out.println(a);
        }

        System.out.println("\n-- Filter by patient phone 0411111111 --");
        for (Appointment a : manager.getByPatientPhone("0411111111")) {
            System.out.println(a);
        }

        System.out.println("\n-- Cancel GP 1001 at 09:00 --");
        System.out.println(manager.cancelByIdAndTime("1001", LocalTime.of(9, 0)));

        System.out.println("\n-- Cancel non-existent appointment (error case) --");
        System.out.println(manager.cancelByIdAndTime("9999", LocalTime.of(9, 0)));

        System.out.println("\n-- Cancel by patient phone 0422222222 --");
        System.out.println(manager.cancelByPatientPhone("0422222222"));

        System.out.println("\n-- Final list after cancellations --");
        for (Appointment a : manager.getAllSorted()) {
            System.out.println(a);
        }
    }
}
