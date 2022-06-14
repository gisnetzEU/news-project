package io.company.news;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NoticiaRepository extends CrudRepository <Noticia, Long> {
    //
    Optional<Noticia> findNoticiaByTitle(String title);

    List<Noticia> findByTitle(String title);
    Optional<Noticia> deleteNoticiaByTitle(String title);

}

