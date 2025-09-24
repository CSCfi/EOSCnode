package fi.csc.data.eosc.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@org.hibernate.annotations.Immutable
@Entity
@Table(name = "purpose")
public class Purpose extends PanacheEntityBase {
    @Id
    @Column(name = "id", nullable = false)
    public int id;
    public String en;
    public String fi;
}
