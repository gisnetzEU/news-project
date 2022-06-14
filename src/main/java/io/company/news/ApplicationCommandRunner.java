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

        public void createNoticias(){
            logger.info("Welcome to the createNoticias");
            // String title, String author, String content, Date postedDate, String iSBN
            Noticia noticia1 = new Noticia("Anna Karenina", "Tolstoy", "CNN", new Date(2022, 5, 15), "BR5GV-5-ERG5-6567");
            Noticia noticia2 = new Noticia("To the lighthouse", "V Wolf", "BBC", new Date(1987-07-30), "56756-DFG2T-554");
            Noticia noticia3 = new Noticia("Orlando", "Virginia Wolf", "New York Times", new Date(1987-07-30), "4455645-GWR-456");
            Noticia noticia4 = new Noticia("In Search of Lost Time", "Marcel Proust", "El Pais", new Date(1987-07-30), "4455645-GW1R-456");
            //to repo-DB via noticiaService
            noticiaService.createNoticia(noticia1);
            noticiaService.createNoticia(noticia2);
            noticiaService.createNoticia(noticia3);
            noticiaService.createNoticia(noticia4);

            logger.info("finishing createNoticias ...");


        }

        public void createFakerNoticias(){
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

            System.out.println("ISBN? ");
            String isbn = reader.next();

            noticiaService.createNoticia(new Noticia(title, author, content, postedDate, isbn));

            logger.info("noticiaService called with new noticia ...");
            logger.info("finishing createNoticia ...");
        }

    }

