package dev.vishnu.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
//    @GenericGenerator(name = "customGenerator", strategy = "uuid2")
//    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
}
