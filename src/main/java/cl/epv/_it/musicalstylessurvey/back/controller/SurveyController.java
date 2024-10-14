package cl.epv._it.musicalstylessurvey.back.controller;

import cl.epv._it.musicalstylessurvey.back.dto.AddUserResponse;
import cl.epv._it.musicalstylessurvey.back.dto.MusicStyleDTO;
import cl.epv._it.musicalstylessurvey.back.dto.MusicStyleSummaryDTO;
import cl.epv._it.musicalstylessurvey.back.dto.UserMusicPreferenceDTO;
import cl.epv._it.musicalstylessurvey.back.service.MusicStyleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musical-styles-survey/api/v1")
@AllArgsConstructor
@Slf4j
public class SurveyController {

    private final MusicStyleService musicStyleService;

    @GetMapping(value = "/allMusicStyles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MusicStyleDTO>> allMusicStyles() {
        log.info("Todos los estilos musicales");

        List<MusicStyleDTO> result = musicStyleService.getAllMusicStyles();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/addUserPreference", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddUserResponse> addUserPreference(
            @Valid @RequestBody UserMusicPreferenceDTO userMusicPreference
    ){
        log.info("nuevo usuario y preferencia musical");

        AddUserResponse result = musicStyleService.addUserMusicPreference(userMusicPreference);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/voteResults", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MusicStyleSummaryDTO>> voteResults() {
        log.info("Resumen de las votaciones");

        List<MusicStyleSummaryDTO> result = musicStyleService.getAllMusicStyleSummary();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
