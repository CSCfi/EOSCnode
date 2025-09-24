package fi.csc.data.eosc.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@org.hibernate.annotations.Immutable
@Entity
@Table(name = "accesstypes")
public class AccessTypes extends PanacheEntityBase
{
    @Column(name = "id", nullable = false)
    @Id
    public Integer aid;
    public String en;
    public String fi;
}

