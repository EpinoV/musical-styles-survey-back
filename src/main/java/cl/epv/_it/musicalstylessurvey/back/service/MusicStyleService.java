package cl.epv._it.musicalstylessurvey.back.service;

import cl.epv._it.musicalstylessurvey.back.dto.AddUserResponse;
import cl.epv._it.musicalstylessurvey.back.dto.MusicStyleDTO;
import cl.epv._it.musicalstylessurvey.back.dto.MusicStyleSummaryDTO;
import cl.epv._it.musicalstylessurvey.back.dto.UserMusicPreferenceDTO;

import java.util.List;

public interface MusicStyleService {

    List<MusicStyleDTO> getAllMusicStyles();

    AddUserResponse addUserMusicPreference(UserMusicPreferenceDTO userMusicPreferenceDTO);

    List<MusicStyleSummaryDTO> getAllMusicStyleSummary();
}
