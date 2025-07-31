package in.hello.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Student belongs to one school
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    // Student belongs to one class
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classroom classroom;
}