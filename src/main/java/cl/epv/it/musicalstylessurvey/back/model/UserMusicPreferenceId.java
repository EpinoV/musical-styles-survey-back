package cl.epv.it.musicalstylessurvey.back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
public class UserMusicPreferenceId {
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "STYLE_ID")
    private Long styleId;
}