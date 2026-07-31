package mercurio.model.enums;

public enum Status {
    GUARANTEED(0L, "GUARANTEED"),
    NEED_GRADE(1L, "NEED_GRADE"),
    FIFTY_FIFTY(2L, "FIFTY_FIFTY");

    private final Long id;
    private final String description;

    private Status(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return this.description;
    }

    public static Status of(Long id) {
        if (id == null)
            return null;

        for (Status s : values()) {
            if(s.getId().equals(id))
                return s;
        }

        return null; // TODO maybe a exception match here..
    }
}
