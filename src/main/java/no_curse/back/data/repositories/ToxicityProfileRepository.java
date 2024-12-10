package no_curse.back.data.repositories;

import no_curse.back.data.entities.ToxicityProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToxicityProfileRepository extends JpaRepository<ToxicityProfile, Long> {
    Page<ToxicityProfile> findAllByIsActivedTrue(Pageable pageable);
}