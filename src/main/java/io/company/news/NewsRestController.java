package io.company.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class NewsRestController {
    //here we are creating our end-point rest API
    @Autowired
    NoticiaService noticiaservice;

    //CRUD: read
    @GetMapping("noticias")
    public Iterable<Noticia> getAllNoticias() {
        //
        return noticiaservice.getAllNoticias();
    }

    @GetMapping("search")
    public List<Noticia> search(String title) {
        //
        return noticiaservice.findByTitle(title);
    }

    //CRUD: read, find one noticia by id
    @GetMapping("getNoticia")
    public Noticia findNoticiaById(Long id){
        //
        Optional<Noticia> noticiaFound = noticiaservice.findNoticiaById(id);
        if (noticiaFound.isPresent()) return  noticiaFound.get();

        return null;
    }

    //CRUD: create
    @PostMapping(path="addNoticia", consumes = "application/JSON")
    public Noticia addNoticia(@RequestBody Noticia noticia){
        //
        Noticia noticiaCreated = noticiaservice.createNoticia(noticia);
        return noticiaCreated ;
    }

    //CRUD: delete
    @DeleteMapping("deleteNoticia")
    public ResponseEntity<Noticia> deleteNoticia (@RequestParam Long id) {
        //
        HttpHeaders headers = new HttpHeaders();
        headers.add("operation","deleteNoticia");
        headers.add("version","api 1.0");

        Optional<Noticia> noticiaFound  = noticiaservice.findNoticiaById(id);
        boolean isNoticia = noticiaFound.isPresent();
        if(isNoticia) {
            //Optional<Noticia> deletedNoticia = noticiaservice.deleteNoticiaById(id);
            noticiaservice.deleteNoticiaById(id);
            headers.add("operationStatus","deleted");
            return  ResponseEntity.accepted().headers(headers).body(noticiaFound.get());
        } else return ResponseEntity.accepted().body(null);


    }

    //CRUD: update
    @PutMapping("/updateNoticia/{id}")
    public ResponseEntity<Noticia> updateNoticia (@PathVariable Long id, @RequestBody Noticia dataNoticia) {

        Optional<Noticia> noticiaFound = noticiaservice.findNoticiaById(id);

        if (noticiaFound.isPresent()) {
            Noticia noticiaToUpdate = noticiaFound.get();
            //
            if  (dataNoticia.getTitle() != null) {
                noticiaToUpdate.setTitle(dataNoticia.getTitle());
            }

            Noticia noticiaUpdated = noticiaservice.updateNoticia(noticiaToUpdate);
            return ResponseEntity.accepted().body(noticiaUpdated);
        } else
            return ResponseEntity.accepted().body(null);

    }

    //CRUD: delete noticia by title
    @DeleteMapping("deleteNoticiaByTitle")
    public ResponseEntity<Noticia> deleteNoticiaByTitle (@RequestParam String title) {
        //
        HttpHeaders headers = new HttpHeaders();
        headers.add("operation","deleteNoticiaByTitle");
        headers.add("version","api 1.0");

        //findNoticiaByTitle(String title)
        //deleteNoticiaByTitle(String title)

        return null;

    }


}
