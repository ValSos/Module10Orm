package entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Column
    public String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
}
