package org.example.thejobseeking.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "cant be null")
    @Column(columnDefinition = "int not null")
    private Integer user_id;

    @NotNull(message = "cant be null")
    @Column(columnDefinition = "int not null")
    private Integer jobPost_id;

}
