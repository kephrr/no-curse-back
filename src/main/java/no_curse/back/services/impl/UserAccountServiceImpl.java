package no_curse.back.services.impl;

import lombok.RequiredArgsConstructor;
import no_curse.back.data.entities.UserAccount;
import no_curse.back.data.repositories.UserAccountRepository;
import no_curse.back.services.UserAccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;
    @Override
    public UserAccount save(UserAccount data) {
        return userAccountRepository.save(data);
    }

    @Override
    public Page<UserAccount> findAll(Pageable pageable) {
        return userAccountRepository.findAll(pageable);
    }

    @Override
    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();
    }

    @Override
    public Optional<UserAccount> show(Long dataID) {
        return userAccountRepository.findById(dataID);
    }
}
