package cl.epv.it.musicalstylessurvey.back.mapper;

import cl.epv.it.musicalstylessurvey.back.dto.MusicStyleDTO;
import cl.epv.it.musicalstylessurvey.back.model.MusicStyle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class MusicStyleMapper {
    public static final MusicStyleMapper INSTANCE = Mappers.getMapper(MusicStyleMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    public abstract MusicStyleDTO entityToDTO(MusicStyle entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    public abstract MusicStyle dtoToEntity(MusicStyleDTO dto);

    public abstract List<MusicStyleDTO> entityListToDTOList(List<MusicStyle> entityList);

    public abstract List<MusicStyle> dtoListToEntityList(List<MusicStyleDTO> dtoList);
}
