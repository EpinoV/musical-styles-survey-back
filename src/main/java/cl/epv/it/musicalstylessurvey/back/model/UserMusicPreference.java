package cl.epv.it.musicalstylessurvey.back.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USER_MUSIC_PREFERENCE")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMusicPreference {
    @EmbeddedId
    private UserMusicPreferenceId id;
}
