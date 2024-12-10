package no_curse.back.api.dto.response.rest;

import lombok.*;
import no_curse.back.data.entities.ToxicityProfile;
import no_curse.back.data.entities.UserAccount;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToxicityProfileDto {
    private Long id;
    private String name;
    private String pseudo;
    private int followers;
    private int following;
    private int totalTweets;
    private int totalInsults;
    private double score;
    private double rate;
    private int level;

    public static ToxicityProfileDto toDto(UserAccount user) {
        return ToxicityProfileDto.builder()
                .id(user.getId())
                .name(user.getName())
                .pseudo(user.getPseudo())
                .followers(user.getFollowers())
                .following(user.getFollowing())
                .totalTweets(user.getTotalTweets())
                .totalInsults(user.getTotalInsults())
                .score(user.getToxicityProfile().getScore())
                .rate(user.getToxicityProfile().getToxicityRate())
                .level(user.getToxicityProfile().getToxicityLevel())
                .build();
    }










}
