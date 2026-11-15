    import java.time.DayOfWeek;
    import java.util.EnumSet;

public abstract class HealthProfessional {

    private final String id;
    private final String name;
    private final EnumSet<DayOfWeek> availableDays;

    public HealthProfessional(String id, String name, EnumSet<DayOfWeek> availableDays) {
        if (id == null || !id.matches("\\d+")) {
            throw new IllegalArgumentException("ID must contain digits only.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (availableDays == null || availableDays.isEmpty()) {
            throw new IllegalArgumentException("Available days cannot be empty.");
        }
        this.id = id;
        this.name = name;
        this.availableDays = EnumSet.copyOf(availableDays);
    }

    public HealthProfessional(String id, String name) {
        this(id, name, EnumSet.range(DayOfWeek.MONDAY, DayOfWeek.FRIDAY));
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public EnumSet<DayOfWeek> getAvailableDays() { return EnumSet.copyOf(availableDays); }

    public abstract String getRole();

    @Override
    public String toString() {
        return String.format("[%s] %s (%s) | Available: %s",
                id, name, getRole(), availableDays);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HealthProfessional other = (HealthProfessional) obj;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

