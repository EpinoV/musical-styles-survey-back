package cl.epv.it.musicalstylessurvey.back.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicStyleSummaryDTO {
    private String musicStyleName;
    private int summaryOfVotes;
}
