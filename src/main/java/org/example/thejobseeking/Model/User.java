package org.example.thejobseeking.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "cant be empty")
    @Size(min = 5, message = "Name must be at least 5 characters long")
    @Pattern(regexp = "[a-zA-Z]+", message = "Name must contain only characters")
    @Column(columnDefinition ="varchar(5) check (length(name)>5) not null" )
    private String name;

    @NotEmpty(message = "Email can't be empty")
    @Email
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotEmpty(message = "Password can't be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;

    @NotNull(message = "Age can't be null")
    @Min(value = 22, message = "Age must be more than 21")
    @Column(columnDefinition = "int not null check (length(age)>22) ")
    private Integer age;

    @NotNull(message = "Role can't be null")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$", message = "Role must be either 'JOB_SEEKER' or 'EMPLOYER'")
    @Column(columnDefinition = "varchar(10) not null  check(role='Job_seeker' or role='employer')")
    private String role;
}
