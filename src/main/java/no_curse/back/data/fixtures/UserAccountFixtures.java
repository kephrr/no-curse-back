package no_curse.back.data.fixtures;

import lombok.RequiredArgsConstructor;
import no_curse.back.data.entities.UserAccount;
import no_curse.back.data.repositories.UserAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
@RequiredArgsConstructor
public class UserAccountFixtures implements CommandLineRunner {
    private final UserAccountRepository userAccountRepository;
    @Override
    public void run(String... args) throws Exception {
        String[] names = {"LAND OF WANO","Kreatiive_","RYO Sensei","GOJI","TTFL"};
        String[] pseudos = {"Wano_Kuni","kephrr","RyoSenseiTV","GojiYouTube","TrashTalk_fr"};
        int[] followers = {4050,385,270000,39840,100000};
        int[] following = {125,200,530,827,110};
        int[] tweetsTotal = {1203,10000,1234,10830,103874};
        int[] totalInsults = {400,134,32,42,9};

        for (int i = 0; i < names.length; i++) {
            UserAccount userAccount = new UserAccount();
            userAccount.setName(names[i]);
            userAccount.setPseudo(pseudos[i]);
            userAccount.setFollowers(followers[i]);
            userAccount.setFollowing(following[i]);
            userAccount.setTotalTweets(tweetsTotal[i]);
            userAccount.setTotalInsults(totalInsults[i]);
            userAccountRepository.save(userAccount);
        }
    }
}
