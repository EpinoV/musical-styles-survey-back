package cl.epv._it.musicalstylessurvey.back.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMusicPreferenceDTO {
    private String styleId;
    private String email;
}
