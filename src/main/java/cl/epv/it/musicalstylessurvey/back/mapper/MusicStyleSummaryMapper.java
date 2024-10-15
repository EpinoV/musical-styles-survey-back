package cl.epv.it.musicalstylessurvey.back.mapper;

import cl.epv.it.musicalstylessurvey.back.dto.MusicStyleSummaryDTO;
import cl.epv.it.musicalstylessurvey.back.model.MusicStyleSummary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class MusicStyleSummaryMapper {
    public static final MusicStyleSummaryMapper INSTANCE = Mappers.getMapper(MusicStyleSummaryMapper.class);

    @Mapping(target = "musicStyleName", source = "musicStyleName")
    @Mapping(target = "summaryOfVotes", source = "summaryOfVotes")
    public abstract MusicStyleSummaryDTO entityToDTO(MusicStyleSummary entity);

    @Mapping(target = "musicStyleName", source = "musicStyleName")
    @Mapping(target = "summaryOfVotes", source = "summaryOfVotes")
    public abstract MusicStyleSummary dtoToEntity(MusicStyleSummaryDTO dto);

    public abstract List<MusicStyleSummaryDTO> entityListToDTOList(List<MusicStyleSummary> entityList);

    public abstract List<MusicStyleSummary> dtoListToEntityList(List<MusicStyleSummaryDTO> dtoList);
}
