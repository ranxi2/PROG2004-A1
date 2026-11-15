public class Patient {

    private final String name;
    private final String mobile;

    public Patient(String name, String mobile) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        if (mobile == null || !mobile.matches("\\d{8,15}")) {
            throw new IllegalArgumentException("Mobile must be 8-15 digits.");
        }
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() { return name; }
    public String getMobile() { return mobile; }

    @Override
    public String toString() {
        return name + " (mobile: " + mobile + ")";
    }
}