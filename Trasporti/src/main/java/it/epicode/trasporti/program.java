package it.epicode.trasporti;

import it.epicode.trasporti.dao.CardDaoImpl;
import it.epicode.trasporti.dao.StoreDaoImpl;
import it.epicode.trasporti.dao.TravelDocumentDaoImpl;
import it.epicode.trasporti.dao.UserDaoImpl;
import it.epicode.trasporti.entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class program {

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
        TravelDocument document1 = new Ticket(dataCreazione1,3L);
        //document.save(document1);

        Card card1 = new Card(user.findUserById(1L));

        //card.save(card1);

    }

}
