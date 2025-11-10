package com.example.jobtrackr.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity @Table(name = "applications")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 120)
    private String company;

    @NotBlank @Size(max = 120)
    private String role;

    @Size(max = 80)
    private String source; // LinkedIn, Referral, etc

    @PastOrPresent
    private LocalDate appliedOn;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status = ApplicationStatus.APPLIED;

    @Size(max = 2000)
    private String notes;
}
