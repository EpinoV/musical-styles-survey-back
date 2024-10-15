package cl.epv.it.musicalstylessurvey.back.service.impl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import cl.epv.it.musicalstylessurvey.back.dto.MusicStyleDTO;
import cl.epv.it.musicalstylessurvey.back.dto.MusicStyleSummaryDTO;
import cl.epv.it.musicalstylessurvey.back.dto.UserMusicPreferenceDTO;
import cl.epv.it.musicalstylessurvey.back.repository.MusicStyleRepository;
import cl.epv.it.musicalstylessurvey.back.repository.UserMusicPreferenceRepository;
import cl.epv.it.musicalstylessurvey.back.service.MusicStyleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

class MusicStyleServiceImplTest {

    //@Mock
    private MusicStyleService musicStyleService;

    @Mock
    private MusicStyleRepository musicStyleRepository;

    @Mock
    private UserMusicPreferenceRepository userMusicPreferenceRepository;

    @InjectMocks
    private MusicStyleServiceImpl musicStyleServiceImpl;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.initMocks(this);
        //musicStyleService = new MusicStyleServiceImpl(musicStyleRepository, userMusicPreferenceRepository);
    }

    @Test
    public void testGetAllMusicStyles() {
        // Datos de prueba simulados
        List<MusicStyleDTO> mockMusicStyles = Arrays.asList(
                new MusicStyleDTO(1, "Rock"),
                new MusicStyleDTO(2, "Pop")
        );

        // Configurar el comportamiento del mock
        when(musicStyleService.getAllMusicStyles()).thenReturn(mockMusicStyles);

        // Ejecutar el método a probar
        List<MusicStyleDTO> result = musicStyleServiceImpl.getAllMusicStyles();

        // Verificar los resultados
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Rock", result.get(0).getName());
    }

    @Test
    public void testAddUserMusicPreference() {
        // Crear un DTO de preferencia de usuario
        UserMusicPreferenceDTO preferenceDTO = new UserMusicPreferenceDTO("1", "user@example.com");

        // Ejecutar el método a probar
        assertDoesNotThrow(() -> musicStyleServiceImpl.addUserMusicPreference(preferenceDTO));

        // Verificar que el método fue llamado una vez
        verify(musicStyleService, times(1)).addUserMusicPreference(preferenceDTO);
    }

    @Test
    public void testGetAllMusicStyleSummary() {
        // Datos simulados para la prueba
        List<MusicStyleSummaryDTO> mockSummary = Arrays.asList(
                MusicStyleSummaryDTO.builder().musicStyleName("Rock").summaryOfVotes(10).build(),
                MusicStyleSummaryDTO.builder().musicStyleName("Pop").summaryOfVotes(20).build()
        );

        // Configurar el comportamiento del mock
        when(musicStyleService.getAllMusicStyleSummary()).thenReturn(mockSummary);

        // Ejecutar el método a probar
        List<MusicStyleSummaryDTO> result = musicStyleServiceImpl.getAllMusicStyleSummary();

        // Verificar los resultados
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(10, result.get(0).getSummaryOfVotes());
    }

}