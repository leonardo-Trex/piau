package mercurio.model.enums;

public enum Proficiency {
    KNOW_IT_WELL(0L, "KNOW_IT_WELL"),
    KNOW_NOTHING(1L, "KNOW_NOTHING"),
    SO_SO(2L, "SO_SO");

    private final Long id;
    private final String description;

    private Proficiency(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return this.description;
    }

    public static Proficiency of(Long id) {
        if (id == null)
            return null;

        for (Proficiency p : values()) {
            if(p.getId().equals(id))
                return p;
        }

        return null; // TODO maybe a exception match here..
    }
}
