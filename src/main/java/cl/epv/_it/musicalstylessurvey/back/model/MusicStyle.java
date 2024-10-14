package cl.epv._it.musicalstylessurvey.back.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MUSIC_STYLE")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicStyle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STYLE_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
}
