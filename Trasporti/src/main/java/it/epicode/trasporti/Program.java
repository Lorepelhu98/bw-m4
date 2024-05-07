package it.epicode.trasporti;

import it.epicode.trasporti.dao.*;
import it.epicode.trasporti.entities.*;
import it.epicode.trasporti.entities.tranports.Bus;
import it.epicode.trasporti.entities.tranports.Maintenance;
import it.epicode.trasporti.entities.tranports.Tram;
import it.epicode.trasporti.entities.tranports.Vehicle;
import it.epicode.trasporti.entities.travel_documents.MonthlyPass;
import it.epicode.trasporti.entities.travel_documents.Ticket;
import it.epicode.trasporti.entities.travel_documents.TravelDocument;
import it.epicode.trasporti.entities.travel_documents.WeeklyPass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Program {

    public static void main(String[] args) throws ParseException {

        UserDaoImpl user = new UserDaoImpl();
        StoreDaoImpl store = new StoreDaoImpl();
        TravelDocumentDaoImpl document = new TravelDocumentDaoImpl();
        CardDaoImpl card = new CardDaoImpl();
        VehicleDaoImpl transport = new VehicleDaoImpl();
        MaintenanceDaoImpl maintenance = new MaintenanceDaoImpl();


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
        TravelDocument document2 = new WeeklyPass(dataCreazione2, 3L, user.findUserById(1L));
        TravelDocument document3 = new MonthlyPass(dataCreazione3, 4L , user.findUserById(2L));
        //document.save(document1);
        //document.save(document2);
        //document.save(document3);

        Card card1 = new Card(user.findUserById(1L));
        Card card2 = new Card(user.findUserById(2L));
        Card card3 = new Card(user.findUserById(3L));
        //card.save(card1);
        //card.save(card2);
        //card.save(card3);

        Vehicle transport1 = new Bus();
        Vehicle transport2 = new Tram();
        Vehicle transport3 = new Bus();
        //transport.save(transport1);
        //transport.save(transport2);
        //transport.save(transport3);

        Maintenance maintenance1 = new Maintenance(transport.findTransportById(3L), LocalDate.now());
        //maintenance.save(maintenance1);
    }

}
