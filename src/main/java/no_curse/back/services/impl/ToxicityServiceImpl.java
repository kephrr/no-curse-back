package no_curse.back.services.impl;

import no_curse.back.data.entities.ToxicityProfile;
import no_curse.back.data.entities.UserAccount;
import no_curse.back.services.ToxicityService;
import org.springframework.stereotype.Service;

@Service
public class ToxicityServiceImpl implements ToxicityService {
    @Override
    public double calculateToxicityScore(UserAccount userAccount) {
        int followers = userAccount.getFollowers();
        int following = userAccount.getFollowing();
        int totalTweets = userAccount.getTotalTweets();
        int totalInsults = userAccount.getTotalInsults();

        if (totalTweets == 0) {
            return 0;
        }
        double insultProportion = (double) totalInsults / totalTweets;
        double followersImpact = Math.log10(followers + 1);
        // double followerRatio = 1 + (followers*0.6) / (following*0.4 + 1);
        return insultProportion * followersImpact * 100;
    }

    @Override
    public int getToxicityLevel(ToxicityProfile profile) {
        double score = profile.getScore();
        if(score>10) return 5;
        if(score>5) return 4;
        if(score>3) return 3;
        if(score>2) return 2;
        return 1;
    }
}
