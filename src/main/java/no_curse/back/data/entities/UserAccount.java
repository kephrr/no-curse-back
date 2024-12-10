package no_curse.back.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="user-account")
public class UserAccount extends AbstractEntity{
    private String name;
    @Column(unique=true)
    private String pseudo;
    private int followers;
    private int following;
    private int totalTweets;
    private int totalInsults;
    @OneToOne
    private ToxicityProfile toxicityProfile;
    @OneToMany
    private List<ToxicityProfile> profilesSaved;
}
