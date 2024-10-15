package cl.epv.it.musicalstylessurvey.back.service.impl;

import cl.epv.it.musicalstylessurvey.back.dto.AddUserResponse;
import cl.epv.it.musicalstylessurvey.back.dto.MusicStyleDTO;
import cl.epv.it.musicalstylessurvey.back.dto.MusicStyleSummaryDTO;
import cl.epv.it.musicalstylessurvey.back.dto.UserMusicPreferenceDTO;
import cl.epv.it.musicalstylessurvey.back.mapper.MusicStyleMapper;
import cl.epv.it.musicalstylessurvey.back.mapper.MusicStyleSummaryMapper;
import cl.epv.it.musicalstylessurvey.back.mapper.UserMusicPreferenceMapper;
import cl.epv.it.musicalstylessurvey.back.repository.MusicStyleRepository;
import cl.epv.it.musicalstylessurvey.back.repository.UserMusicPreferenceRepository;
import cl.epv.it.musicalstylessurvey.back.service.MusicStyleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
@Slf4j
public class MusicStyleServiceImpl implements MusicStyleService {
    private final MusicStyleRepository musicStyleRepository;
    private final UserMusicPreferenceRepository userMusicPreferenceRepository;

    @Override
    public List<MusicStyleDTO> getAllMusicStyles() {
        log.info("getAllMusicStyles");

        return Optional.of(
                        musicStyleRepository.findAll()
                )
                .map(MusicStyleMapper.INSTANCE::entityListToDTOList)
                .orElse(new ArrayList<>());
    }

    @Override
    public AddUserResponse addUserMusicPreference(UserMusicPreferenceDTO userMusicPreferenceDTO) {
        AtomicReference<UserMusicPreferenceDTO> dto = new AtomicReference<>();
        Optional.ofNullable(
                        UserMusicPreferenceMapper.INSTANCE.dtoToEntity(userMusicPreferenceDTO)
                )
                .ifPresent(etty -> {
                            dto.set(UserMusicPreferenceMapper.INSTANCE.entityToDTO(userMusicPreferenceRepository.saveAndFlush(etty)));
                        }
                );

        AddUserResponse response = new AddUserResponse();
        response.setStatusCode(0);
        response.setMessage("Ingreso exitoso");
        return response;

    }

    @Override
    public List<MusicStyleSummaryDTO> getAllMusicStyleSummary() {
        log.info("getAllMusicStyleSummary");

        return Optional.of(
                        userMusicPreferenceRepository.findAllMusicStyleSummary()
                )
                .map(MusicStyleSummaryMapper.INSTANCE::entityListToDTOList)
                .orElse(new ArrayList<>());
    }
}
