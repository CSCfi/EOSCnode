package fi.csc.data.eosc.model;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@org.hibernate.annotations.Immutable
@Entity
@Table(name = "customer_segment")
public class EndUserGroups  extends PanacheEntityBase {
     @Id
    //@Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "en")
    public String en;

    public String fi;
}
