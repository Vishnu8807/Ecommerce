package dev.vishnu.productservice.inheritanceDemo.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ms_TA")
@Getter
@Setter
public class TA extends User{
    private double avgRating;
}
