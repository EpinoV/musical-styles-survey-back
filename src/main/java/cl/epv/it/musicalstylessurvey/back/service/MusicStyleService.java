package cl.epv.it.musicalstylessurvey.back.service;

import cl.epv.it.musicalstylessurvey.back.dto.AddUserResponse;
import cl.epv.it.musicalstylessurvey.back.dto.MusicStyleDTO;
import cl.epv.it.musicalstylessurvey.back.dto.MusicStyleSummaryDTO;
import cl.epv.it.musicalstylessurvey.back.dto.UserMusicPreferenceDTO;

import java.util.List;

public interface MusicStyleService {

    /**
     *
     * @return
     */
    List<MusicStyleDTO> getAllMusicStyles();

    /**
     *
     * @param userMusicPreferenceDTO
     * @return
     */
    AddUserResponse addUserMusicPreference(UserMusicPreferenceDTO userMusicPreferenceDTO);

    /**
     *
     * @return
     */
    List<MusicStyleSummaryDTO> getAllMusicStyleSummary();
}
