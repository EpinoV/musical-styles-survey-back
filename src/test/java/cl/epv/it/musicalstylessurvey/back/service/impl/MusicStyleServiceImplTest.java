package cl.epv.it.musicalstylessurvey.back.service.impl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import cl.epv.it.musicalstylessurvey.back.dto.AddUserResponse;
import cl.epv.it.musicalstylessurvey.back.dto.MusicStyleDTO;
import cl.epv.it.musicalstylessurvey.back.dto.MusicStyleSummaryDTO;
import cl.epv.it.musicalstylessurvey.back.dto.UserMusicPreferenceDTO;
import cl.epv.it.musicalstylessurvey.back.model.MusicStyle;
import cl.epv.it.musicalstylessurvey.back.model.MusicStyleSummary;
import cl.epv.it.musicalstylessurvey.back.model.UserMusicPreference;
import cl.epv.it.musicalstylessurvey.back.model.UserMusicPreferenceId;
import cl.epv.it.musicalstylessurvey.back.repository.MusicStyleRepository;
import cl.epv.it.musicalstylessurvey.back.repository.UserMusicPreferenceRepository;
import cl.epv.it.musicalstylessurvey.back.service.MusicStyleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MusicStyleServiceImplTest {

    private MusicStyleService musicStyleService;

    @Mock
    private MusicStyleRepository musicStyleRepository;

    @Mock
    private UserMusicPreferenceRepository userMusicPreferenceRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        musicStyleService = new MusicStyleServiceImpl(musicStyleRepository, userMusicPreferenceRepository);
    }

    @Test
    public void testGetAllMusicStyles() {
        // Datos de prueba
        List<MusicStyle> mockMusicStyles = Arrays.asList(
                new MusicStyle(1, "Rock"),
                new MusicStyle(2, "Pop")
        );

        when(musicStyleRepository.findAll()).thenReturn(mockMusicStyles);

        List<MusicStyleDTO> result = musicStyleService.getAllMusicStyles();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Rock", result.get(0).getName());
    }

    @Test
    public void testAddUserMusicPreference() {
        UserMusicPreference model = new UserMusicPreference( new UserMusicPreferenceId("user@example.com", 1L));
        UserMusicPreferenceDTO dto = new UserMusicPreferenceDTO("1", "user@example.com");

        when(userMusicPreferenceRepository.saveAndFlush(model)).thenReturn(model);

        AddUserResponse dtoResponse = musicStyleService.addUserMusicPreference(dto);

        assertNotNull(dtoResponse);
    }

    @Test
    public void testGetAllMusicStyleSummary() {
        List<MusicStyleSummary> mockSummary = Arrays.asList(
                MusicStyleSummary.builder().musicStyleName("Rock").summaryOfVotes(10L).build(),
                MusicStyleSummary.builder().musicStyleName("Pop").summaryOfVotes(20L).build()
        );

        when(userMusicPreferenceRepository.findAllMusicStyleSummary()).thenReturn(mockSummary);

        List<MusicStyleSummaryDTO> result = musicStyleService.getAllMusicStyleSummary();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(10, result.get(0).getSummaryOfVotes());
    }

}