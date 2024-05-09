package it.epicode.trasporti;

import it.epicode.trasporti.dao.implementations.*;
import it.epicode.trasporti.entities.*;
import it.epicode.trasporti.entities.tranports.*;
import it.epicode.trasporti.entities.travel_documents.MonthlyPass;
import it.epicode.trasporti.entities.travel_documents.Ticket;
import it.epicode.trasporti.entities.travel_documents.TravelDocument;
import it.epicode.trasporti.entities.travel_documents.WeeklyPass;


import java.time.LocalDate;


public class Program {

    public static void main(String[] args) throws Exception {

        UserDaoImpl user = new UserDaoImpl();
        StoreDaoImpl store = new StoreDaoImpl();
        TravelDocumentDaoImpl document = new TravelDocumentDaoImpl();
        CardDaoImpl card = new CardDaoImpl();
        VehicleDaoImpl vehicle = new VehicleDaoImpl();
        MaintenanceDaoImpl maintenance = new MaintenanceDaoImpl();
        RouteDaoImpl route = new RouteDaoImpl();
        SingleRouteDaoImpl singleRoute = new SingleRouteDaoImpl();

        User user1 = new User("Mario","Rossi");
        User user2 = new User("Giulia", "Bianchi");
        User user3 = new User("Riccardo", "Giallo");
        User user4 = new User("Luca", "Valentinuzzi");

        //user.save(user1);
        //user.save(user2);
        //user.save(user3);
        //user.save(user4);


        TravelDocument document1 = new Ticket(LocalDate.of(2024, 5, 7),3L);
        TravelDocument document2 = new WeeklyPass(LocalDate.of(2024,5,5), 3L, user.findUserById(1L));
        TravelDocument document3 = new MonthlyPass(LocalDate.of(2024,4,1), 4L , user.findUserById(2L));
        TravelDocument document4 = new Ticket(LocalDate.of(2024, 5, 7),1L);
        TravelDocument document5 = new Ticket(LocalDate.of(2024,5,5),5L);
        TravelDocument document6 = new Ticket(LocalDate.of(2024,4,1),4L);
        TravelDocument document7 = new Ticket(LocalDate.of(2024,5,1),2L);
        TravelDocument document8 = new Ticket(LocalDate.of(2023,10,11),4L);

//        document.emitDocument(document1);
//        document.emitDocument(document2);
//        document.emitDocument(document3);
//        document.emitDocument(document4);
//        document.emitDocument(document5);
//        document.emitDocument(document6);
//        document.emitDocument(document7);
//        document.emitDocument(document8);


        Card card1 = new Card(user.findUserById(1L));
        Card card2 = new Card(user.findUserById(2L));
        Card card3 = new Card(user.findUserById(3L));
        Card card4 = new Card(user.findUserById(4L));
        //card.save(card1);
        //card.save(card2);
        //card.save(card3);
        //card.save(card4);

        Vehicle v1 = new Bus();
        Vehicle v2 = new Tram();
        Vehicle v3 = new Bus();
        Vehicle v4 = new Bus();
        Vehicle v5 = new Bus();
        Vehicle v6 = new Tram();
        //vehicle.save(v1);
        //vehicle.save(v2);
        //vehicle.save(v3);
        //vehicle.save(v4);
        //vehicle.save(v5);
        //vehicle.save(v6);

        Maintenance maintenance1 = new Maintenance(vehicle.findVehicleById(3L), LocalDate.now());
        Maintenance maintenance2 = new Maintenance(vehicle.findVehicleById(3L), LocalDate.of(2024,4,30));
        maintenance2.setEnd(LocalDate.of(2024,5,1));
        //maintenance.save(maintenance1);
        //maintenance.save(maintenance2);

        Route route1 = new Route("Stazione Termini", "Piazza Venezia");
        Route route2 = new Route("Via Cristoforo Colombo", "San Giovanni");
        Route route3 = new Route("Ponte Mammolo", "Laurentina");

        //route.save(route1);
        //route.save(route2);
        //route.save(route3);

        SingleRoute sr1 = new SingleRoute(vehicle.findVehicleById(1L),route.findRouteById(1L),20);
        SingleRoute sr2 = new SingleRoute(vehicle.findVehicleById(2L),route.findRouteById(3L),140);
        SingleRoute sr3 = new SingleRoute(vehicle.findVehicleById(3L),route.findRouteById(2L),30);
        SingleRoute sr4 = new SingleRoute(vehicle.findVehicleById(5L),route.findRouteById(3L),50);
        SingleRoute sr5 = new SingleRoute(vehicle.findVehicleById(4L),route.findRouteById(2L),45);
        SingleRoute sr6 = new SingleRoute(vehicle.findVehicleById(1L),route.findRouteById(1L),25);

//        singleRoute.generateSingleRoute(sr1);
//        singleRoute.generateSingleRoute(sr2);
//        singleRoute.generateSingleRoute(sr3);
//        singleRoute.generateSingleRoute(sr4);
//        singleRoute.generateSingleRoute(sr5);
//        singleRoute.generateSingleRoute(sr6);

        //System.out.println(route.calculateAvgTime(1L));
        //System.out.println(route.calculateAvgTime(2L));
        //System.out.println(route.calculateAvgTime(3L));

        //route.updateAvgTime(1L);
        //route.updateAvgTime(2L);
        //route.updateAvgTime(3L);

        //System.out.println(singleRoute.routesPerVehicle(1L,1L));  //Numero di volte che un mezzo percorre una tratta



        //card.renewCard(5L);     //Funzione per rinnovare la tessera

        //document.validateTicket(1L,vehicle.findVehicleById(1L));
        //document.validateTicket(4L,vehicle.findVehicleById(1L));
        //document.validateTicket(5L,vehicle.findVehicleById(5L));


        //System.out.println(document.ticketsPerVehicle(1L));  //Ricerca biglietti vidimati per mezzo

        //SimpleDateFormat sdfh = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //Date startDate1 = sdfh.parse("2024-02-01 00:00");
        //Date endDate1 = sdfh.parse("2024-05-05 23:59");


        //System.out.println(document.ticketsPerTimeRange(startDate1,endDate1)); //Ricerca biglietti vidimati per intervallo temporale



        System.out.println("La tessera cercata " + (document.checkPassValidity(1L) ? "" : "non ") + "è valida"); //controllo validità abbonamento


        System.out.println(document.documentsPerStore(3L));
        System.out.println(document.documentsPerStore(1L));


        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        LocalDate startDate2 = LocalDate.of(2024,1,1);
        LocalDate endDate2 = LocalDate.of(2024,5,6);

        System.out.println(document.documentsPerTimeRange(startDate2,endDate2));



        singleRoute.generateSingleRoute(sr3);
    }

}
