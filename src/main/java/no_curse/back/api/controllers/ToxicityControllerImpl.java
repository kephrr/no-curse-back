package no_curse.back.api.controllers;

import lombok.RequiredArgsConstructor;
import no_curse.back.api.dto.response.rest.RestResponseDto;
import no_curse.back.api.dto.response.rest.ToxicityProfileDto;
import no_curse.back.data.entities.ToxicityProfile;
import no_curse.back.services.ToxicityProfileService;
import no_curse.back.services.UserAccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ToxicityControllerImpl implements ToxicityController {
    private final UserAccountService userAccountService;
    @Override
    public Map<Object, Object> getProfiles(int page, int size) {
        Page<ToxicityProfileDto> profiles = userAccountService.findAll(PageRequest.of(page, size)).map(ToxicityProfileDto::toDto);
        return RestResponseDto.response(
                profiles.getContent(),
                new int[profiles.getTotalPages()],
                page,
                profiles.getTotalElements(),
                profiles.getTotalPages(),
                HttpStatus.OK
        );
    }
}
