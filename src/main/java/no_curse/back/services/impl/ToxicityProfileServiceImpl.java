package no_curse.back.services.impl;

import lombok.RequiredArgsConstructor;
import no_curse.back.data.entities.ToxicityProfile;
import no_curse.back.data.repositories.ToxicityProfileRepository;
import no_curse.back.services.ToxicityProfileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ToxicityProfileServiceImpl implements ToxicityProfileService {
    private final ToxicityProfileRepository toxicityProfileRepository;
    @Override
    public ToxicityProfile save(ToxicityProfile data) {
        return toxicityProfileRepository.save(data);
    }

    @Override
    public Page<ToxicityProfile> findAll(Pageable pageable) {
        return toxicityProfileRepository.findAll(pageable);
    }

    @Override
    public List<ToxicityProfile> findAll() {
        return toxicityProfileRepository.findAll();
    }

    @Override
    public Optional<ToxicityProfile> show(Long dataID) {
        return toxicityProfileRepository.findById(dataID);
    }
}
