package fi.csc.data.eosc.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@org.hibernate.annotations.Immutable
@Entity
@Table(name = "EOSC_node")
public class EOSCNodes extends PanacheEntityBase {
    @Id
    @Column(name = "id", nullable = false)
    public Integer eid;
    public String en;
    public String fi;
}
