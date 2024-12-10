package no_curse.back.data.fixtures;

import lombok.RequiredArgsConstructor;
import no_curse.back.data.entities.ToxicityProfile;
import no_curse.back.data.entities.UserAccount;
import no_curse.back.data.repositories.UserAccountRepository;
import no_curse.back.services.ToxicityProfileService;
import no_curse.back.services.ToxicityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
@RequiredArgsConstructor
public class ToxicityProfileFixtures implements CommandLineRunner {
    private final UserAccountRepository userAccountRepository;
    private final ToxicityProfileService toxicityProfileService;
    private final ToxicityService toxicityService;
    @Override
    public void run(String... args) throws Exception {
        List<UserAccount> users = userAccountRepository.findAllByIsActivedTrue();
        for (UserAccount user : users) {
            int totalInsults = user.getTotalInsults();
            int totalTweets = user.getTotalTweets();

            ToxicityProfile profile = new ToxicityProfile();
            double score = toxicityService.calculateToxicityScore(user);
            double rate = (double) totalInsults / totalTweets;

            profile.setScore(score);
            profile.setToxicityRate(rate*100);

            int level = toxicityService.getToxicityLevel(profile);
            profile.setToxicityLevel(level);

            toxicityProfileService.save(profile);
            user.setToxicityProfile(profile);
            userAccountRepository.save(user);
        }
    }
}














