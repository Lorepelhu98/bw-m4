package it.epicode.trasporti;

import it.epicode.trasporti.dao.CardDaoImpl;
import it.epicode.trasporti.dao.StoreDaoImpl;
import it.epicode.trasporti.dao.TravelDocumentDaoImpl;
import it.epicode.trasporti.dao.UserDaoImpl;
import it.epicode.trasporti.entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {

    public static void main(String[] args) throws ParseException {

        UserDaoImpl user = new UserDaoImpl();
        StoreDaoImpl store = new StoreDaoImpl();
        TravelDocumentDaoImpl document = new TravelDocumentDaoImpl();
        CardDaoImpl card = new CardDaoImpl();

        User user1 = new User("Mario","Rossi");
        User user2 = new User("Giulia", "Bianchi");
        User user3 = new User("Riccardo", "Giallo");

        //user.save(user1);
        //user.save(user2);
        //user.save(user3);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dataCreazione1 = sdf.parse("03-05-2024");
        Date dataCreazione2 = sdf.parse("05-05-2024");
        Date dataCreazione3 = sdf.parse("01-04-2024");
        TravelDocument document1 = new Ticket(dataCreazione1,3L);
        TravelDocument document2 = new WeeklyPass(dataCreazione2, 3L, card.findCardById(1L));
        TravelDocument document3 = new MonthlyPass(dataCreazione3, 4L , card.findCardById(2L));
        //document.save(document1);
        //document.save(document2);
        //document.save(document3);

        Card card1 = new Card(user.findUserById(1L));
        Card card2 = new Card(user.findUserById(2L));
        Card card3 = new Card(user.findUserById(3L));
        //card.save(card1);
        //card.save(card2);
        //card.save(card3);

    }//

}
