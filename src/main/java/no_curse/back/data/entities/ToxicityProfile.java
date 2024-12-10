package no_curse.back.data.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="toxicity-profile")
public class ToxicityProfile extends AbstractEntity{
    private double score;
    private double toxicityRate;
    private int toxicityLevel;
}
