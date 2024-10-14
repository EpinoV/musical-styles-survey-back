package cl.epv._it.musicalstylessurvey.back.mapper;

import cl.epv._it.musicalstylessurvey.back.dto.UserMusicPreferenceDTO;
import cl.epv._it.musicalstylessurvey.back.model.UserMusicPreference;
import cl.epv._it.musicalstylessurvey.back.model.UserMusicPreferenceId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class UserMusicPreferenceMapper {
    public static final UserMusicPreferenceMapper INSTANCE = Mappers.getMapper(UserMusicPreferenceMapper.class);

    @Mapping(target = "styleId", source = "id.styleId")
    @Mapping(target = "email", source = "id.email")
    public abstract UserMusicPreferenceDTO entityToDTO(UserMusicPreference entity);

    @Mapping(target = "id.styleId", source = "styleId")
    @Mapping(target = "id.email", source = "email")
    public abstract UserMusicPreference dtoToEntity(UserMusicPreferenceDTO dto);

    /*
    // Mapeo personalizado para extraer el email del embeddedId
    protected String extractEmail(UserMusicPreferenceId id) {
        return id != null ? id. : null;
    }

    // Mapeo personalizado para extraer el styleId del embeddedId
    protected Long extractStyleId(UserMusicPreferenceId id) {
        return id != null ? id.getStyleId() : null;
    }
*/
    public abstract List<UserMusicPreferenceDTO> entityListToDTOList(List<UserMusicPreference> entityList);

    public abstract List<UserMusicPreference> dtoListToEntityList(List<UserMusicPreferenceDTO> dtoList);
}
