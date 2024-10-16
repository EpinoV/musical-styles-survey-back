package cl.epv.it.musicalstylessurvey.back.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicStyleSummary {
    private String musicStyleName;
    private Long summaryOfVotes;
}
