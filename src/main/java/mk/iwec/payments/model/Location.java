package mk.iwec.payments.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Customer> customers;

    @PrePersist
    protected void onCreate() {
        this.created = LocalDateTime.now(ZoneOffset.UTC);
    }

}
