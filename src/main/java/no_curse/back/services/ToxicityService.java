package no_curse.back.services;

import no_curse.back.data.entities.ToxicityProfile;
import no_curse.back.data.entities.UserAccount;

public interface ToxicityService {
    double calculateToxicityScore(UserAccount userAccount);
    int getToxicityLevel(ToxicityProfile profile);
}
