package cl.epv._it.musicalstylessurvey.back.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicStyleDTO implements Serializable {
    private int id;
    private String name;
}
