package dev.vishnu.productservice.inheritanceDemo.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ms_student")
@Getter
@Setter
public class Student extends User{
    private double attendance;
}
