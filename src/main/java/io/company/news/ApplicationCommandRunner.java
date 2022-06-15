package io.company.news;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


@Component
public class ApplicationCommandRunner implements CommandLineRunner {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    NoticiaService noticiaService;

    @Override
    public void run(String... args) throws Exception {

        Scanner reader = new Scanner(System.in);
        //createNoticias();
        //createFakerNoticias();
        //createOneNoticia(reader);

    }

    public void createNoticias() {
        logger.info("Welcome to the createNoticias");
        // String title, String author, String content, Date postedDate, String iSBN
        Noticia noticia1 = new Noticia("Transgourmet impulsa el delivery de distribución a hosteleros en Barcelona", "Restauración News", "Transgourmet Ibérica, referente en la distribución alimentaria, amplía su apuesta por la hostelería del Área Metropolitana de Barcelona, impulsando su nuevo servicio de entrega a domicilio exclusivo para el sector.", new Date(2022, 06, 13), "https://restauracionnews.com/2022/06/transgourmet-delivery-distribucion-hosteleros-barcelona/");
        Noticia noticia2 = new Noticia("Chapuza: el nuevo Bicing metropolitano será incompatible con el Bicing de Barcelona", "David Fernández", "Tampoco dispondrá de sistema tarifario integrado, por lo que los interesados deberán pagar por los dos servicios", new Date(2022 - 06 - 12), "https://www.larazon.es/cataluna/20220612/ovda7tlpwreqxmraglyxi2t624.html");
        Noticia noticia3 = new Noticia("Barcelona afronta una noche tropical", "Cronica global", "Protección Civil ha activado la alerta por temperaturas inusualmente altas a partir de mañana lunes, mientras el riesgo de incendios forestales se dispara", new Date(1987 - 06 - 12), "https://cronicaglobal.elespanol.com/vida/calor-extremo-lleida-rondara-40-grados-barcelona-afronta-noche-tropical_686426_102.html");
        Noticia noticia4 = new Noticia("Astraseneca aporta 6 millones para la investigación del cáncer en Vall D´Hebrón", "Maria Teresa Coca", "The new Barcelona Post", new Date(1987 - 06 - 16), "https://www.thenewbarcelonapost.com/astrazeneca-aporta-6-millones-para-la-investigacion-del-cancer-en-vall-dhebron/");
        //to repo-DB via noticiaService
        noticiaService.createNoticia(noticia1);
        noticiaService.createNoticia(noticia2);
        noticiaService.createNoticia(noticia3);
        noticiaService.createNoticia(noticia4);

        logger.info("finishing createNoticias ...");
    }

    public void createFakerNoticias() {
        logger.info("Welcome to the createFakerNoticias");
        logger.info("finishing createFakerNoticias ...");
    }

    public void createOneNoticia(Scanner reader) throws ParseException {

        logger.info("Welcome to the createNoticia");

        System.out.println("Title? ");
        String title = reader.nextLine();
        System.out.println("Author? ");
        String author = reader.nextLine();
        System.out.println("Content? ");
        String content = reader.nextLine();
        System.out.println("Posted Date? ");
        String TextDate = reader.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date postedDate = sdf.parse(TextDate);

        System.out.println("Noticia's link? ");
        String noticiaLink = reader.next();

        noticiaService.createNoticia(new Noticia(title, author, content, postedDate, noticiaLink));

        logger.info("noticiaService called with new noticia ...");
        logger.info("finishing createNoticia ...");
    }

}

