package cl.epv._it.musicalstylessurvey.back.repository;

import cl.epv._it.musicalstylessurvey.back.model.MusicStyleSummary;
import cl.epv._it.musicalstylessurvey.back.model.UserMusicPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserMusicPreferenceRepository extends JpaRepository<UserMusicPreference, Integer> {

    @Query("SELECT new cl.epv._it.musicalstylessurvey.back.model.MusicStyleSummary(ms.name, COUNT(ump.id.styleId)) " +
            "FROM MusicStyle ms " +
            "LEFT JOIN UserMusicPreference ump ON ms.id = ump.id.styleId " +
            "GROUP BY ms.name")
    List<MusicStyleSummary> findAllMusicStyleSummary();
}
