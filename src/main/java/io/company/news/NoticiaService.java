package io.company.news;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {

    @Autowired
    NoticiaRepository noticiaRepository;

    public Iterable<Noticia> getAllNoticias() {

       Iterable<Noticia> noticias = noticiaRepository.findAll();

        return noticias;
    }

    public Noticia createNoticia (Noticia noticia){

        Noticia noticiaCreated = noticiaRepository.save(noticia);

        return noticiaCreated;
    }

    public Optional<Noticia> findNoticiaById(Long id){

        return noticiaRepository.findById(id);
    }

    public Optional<Noticia> findNoticiaByTitle(String title){
        return noticiaRepository.findNoticiaByTitle(title);
    }

    public List<Noticia> findByTitle(String title){
        return noticiaRepository.findByTitle(title);
    }

    public Noticia deleteNoticiaByTitle(String title){
        //Find out IF this id-noticia IS in our DB
        Optional<Noticia> deletedNoticia = noticiaRepository.deleteNoticiaByTitle(title);
        //
        return null;
    }

    public void deleteNoticiaById(Long id){
        noticiaRepository.deleteById(id);
    }

    public Noticia updateNoticia (Noticia noticia){
        return noticiaRepository.save(noticia);
    }




}