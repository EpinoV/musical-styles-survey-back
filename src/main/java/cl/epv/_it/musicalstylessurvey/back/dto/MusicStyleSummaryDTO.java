package cl.epv._it.musicalstylessurvey.back.dto;

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
