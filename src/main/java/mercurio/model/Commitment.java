package mercurio.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;


@MappedSuperclass
public abstract class Commitment  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate deadline;
    private String description;

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if (Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;

        Commitment that = (Commitment) o;

        return id != null && id.equals(that.id);
    }

//    Tem a ver com o que o Hibernate faz com os seus proxyes
    @Override
    public final int hashCode() {
        return Hibernate.getClass(this).hashCode();
    }
}
