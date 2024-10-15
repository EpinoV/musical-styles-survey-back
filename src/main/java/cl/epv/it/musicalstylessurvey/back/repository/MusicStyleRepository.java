package cl.epv.it.musicalstylessurvey.back.repository;

import cl.epv.it.musicalstylessurvey.back.model.MusicStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicStyleRepository extends JpaRepository<MusicStyle, Integer> {


}
