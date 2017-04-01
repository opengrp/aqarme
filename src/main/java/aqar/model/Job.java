package aqar.model;

import lombok.AccessLevel;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Setter(AccessLevel.PACKAGE)
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    String clientId;
    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "job_detail_id", unique = true, nullable = false, updatable = false)
    JobDetail jobDetail;
    @NotNull
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    private List<Advertise> advertise;
    private Boolean active = true;
    @NotNull
    String senders;

    public String clientId() {
        return clientId;
    }
}