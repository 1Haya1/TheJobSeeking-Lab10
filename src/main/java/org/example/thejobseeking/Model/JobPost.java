package org.example.thejobseeking.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "cant be empty")
    @Size(min = 5, message = "must be at least 5 characters long")
    @Column(columnDefinition ="varchar(5) check (length(title)>5) not null" )
    private String title;

    @NotEmpty(message = "cant be empty")
    @Column(columnDefinition ="varchar(25) not null" )
    private String description;

    @NotEmpty(message = "cant be empty")
    @Column(columnDefinition ="varchar(15) not null" )
    private String location;


    @NotNull(message = "cant be null")
    @Column(columnDefinition = "int not null")
    @Positive
    private Integer salary;

   @NotNull
   @Column(columnDefinition = "Date")
    private LocalDate postingDate;


}
