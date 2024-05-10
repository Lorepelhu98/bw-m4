package it.epicode.trasporti;

import it.epicode.trasporti.dao.implementations.*;
import it.epicode.trasporti.entities.*;
import it.epicode.trasporti.entities.stores.Reseller;
import it.epicode.trasporti.entities.stores.Store;
import it.epicode.trasporti.entities.stores.TicketMachine;
import it.epicode.trasporti.entities.tranports.*;
import it.epicode.trasporti.entities.travel_documents.MonthlyPass;
import it.epicode.trasporti.entities.travel_documents.Ticket;
import it.epicode.trasporti.entities.travel_documents.TravelDocument;
import it.epicode.trasporti.entities.travel_documents.WeeklyPass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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


        // GENERAZIONE UTENTI E RELATIVE TESSERE E SALVATAGGIO NEL DB
        User user1 = new User("Mario", "Rossi");
        User user2 = new User("Giulia", "Bianchi");
        User user3 = new User("Riccardo", "Giallo");
        User user4 = new User("Luca", "Valentinuzzi");

        //user.generateUser(user1);
        //user.generateUser(user2);
        //user.generateUser(user3);
        //user.generateUser(user4);


        // RINNOVO DELLA TESSERA UTENTE
        //card.renewCard(4L);


        // GENERAZIONE PUNTI VENDITA E SALVATAGGIO NEL DB
        Store store1 = new TicketMachine(true);
        Store store2 = new TicketMachine(true);
        Store store3 = new TicketMachine(false);
        Store store4 = new Reseller();
        Store store5 = new Reseller();
        Store store6 = new Reseller();

        //store.save(store1);
        //store.save(store2);
        //store.save(store3);
        //store.save(store4);
        //store.save(store5);
        //store.save(store6);


        // GENERAZIONE TITOLI DI VIAGGIO E SALVATAGGIO NEL DB
        TravelDocument document1 = new Ticket(LocalDate.of(2024, 5, 7),3L);
        TravelDocument document2 = new WeeklyPass(LocalDate.of(2024,5,5), 3L, user.findUserById(1L));
        TravelDocument document3 = new MonthlyPass(LocalDate.of(2024,4,1), 4L , user.findUserById(2L));
        TravelDocument document4 = new Ticket(LocalDate.of(2024, 5, 7),1L);
        TravelDocument document5 = new Ticket(LocalDate.of(2024,5,5),5L);
        TravelDocument document6 = new Ticket(LocalDate.of(2024,4,1),4L);
        TravelDocument document7 = new Ticket(LocalDate.of(2024,5,1),2L);
        TravelDocument document8 = new Ticket(LocalDate.of(2023,10,11),4L);

        //document.emitDocument(document1);
        //document.emitDocument(document2);
        //document.emitDocument(document3);
        //document.emitDocument(document4);
        //document.emitDocument(document5);
        //document.emitDocument(document6);
        //document.emitDocument(document7);
        //document.emitDocument(document8);


        //CONTROLLO VALIDITA' ABBONAMENTO A PARTIRE DA NUMERO DI TESSERA UTENTE
        System.out.println("La tessera cercata " + (document.checkPassValidity(1L) ? "" : "non ") + "è valida");


        //RICERCA DEL NUMERO DI TITOLI DI VIAGGIO EMESSI DA UN DETERMINATO PUNTO VENDITA
        System.out.println(document.documentsPerStore(3L));
        System.out.println(document.documentsPerStore(1L));


        //RICERCA DEL NUMERO DI TITOLI DI VIAGGIO EMESSI IN UN DETERMINATO INTERVALLO DI TEMPO
        LocalDate startDate2 = LocalDate.of(2024,1,1);
        LocalDate endDate2 = LocalDate.of(2024,5,6);

        System.out.println(document.documentsPerTimeRange(startDate2,endDate2));


        // GENERAZIONE VEICOLI E SALVATAGGIO NEL DB
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


        //VIDIMAZIONE DEI BIGLIETTI
        //document.validateTicket(1L,vehicle.findVehicleById(1L));
        //document.validateTicket(4L,vehicle.findVehicleById(1L));
        //document.validateTicket(5L,vehicle.findVehicleById(5L));


        //RICERCA DEL NUMERO DI BIGLIETTI VIDIMATI PER MEZZO
        Long veic1 = 1L;
        System.out.println("Numero di biglietti vidimati sul mezzo "+ veic1 + ": " + document.ticketsPerVehicle(veic1));


        //RICERCA DEL NUMERO DI BIGLIETTI VIDIMATI IN UN DATO INTERVALLO DI TEMPO
        SimpleDateFormat sdfh = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate1 = sdfh.parse("2024-02-01 00:00");
        Date endDate1 = sdfh.parse("2024-06-05 23:59");
        System.out.println("Numero di biglietti vidimati nel seguente intervallo: '"+ startDate1+ " - "+ endDate1+"': " + document.ticketsPerTimeRange(startDate1,endDate1));


        // GENERAZIONE MANUTENZIONI E SALVATAGGIO NEL DB
        Maintenance maintenance1 = new Maintenance(vehicle.findVehicleById(3L), LocalDate.now());
        Maintenance maintenance2 = new Maintenance(vehicle.findVehicleById(3L), LocalDate.of(2024,4,30));
        maintenance2.setEnd(LocalDate.of(2024,5,1));

        //maintenance.save(maintenance1);
        //maintenance.save(maintenance2);


        // GENERAZIONE TRATTE E SALVATAGGIO NEL DB
        Route route1 = new Route("Stazione Termini", "Piazza Venezia");
        Route route2 = new Route("Via Cristoforo Colombo", "San Giovanni");
        Route route3 = new Route("Ponte Mammolo", "Laurentina");

        //route.save(route1);
        //route.save(route2);
        //route.save(route3);


        // GENERAZIONE DELLE TRATTE SINGOLE E SALVATAGGIO NEL DB
        SingleRoute sr1 = new SingleRoute(vehicle.findVehicleById(1L),route.findRouteById(1L),20);
        SingleRoute sr2 = new SingleRoute(vehicle.findVehicleById(2L),route.findRouteById(3L),140);
        SingleRoute sr3 = new SingleRoute(vehicle.findVehicleById(3L),route.findRouteById(2L),30);
        SingleRoute sr4 = new SingleRoute(vehicle.findVehicleById(5L),route.findRouteById(3L),50);
        SingleRoute sr5 = new SingleRoute(vehicle.findVehicleById(4L),route.findRouteById(2L),45);
        SingleRoute sr6 = new SingleRoute(vehicle.findVehicleById(1L),route.findRouteById(1L),25);

        //singleRoute.generateSingleRoute(sr1);
        //singleRoute.generateSingleRoute(sr2);
        //singleRoute.generateSingleRoute(sr3);
        //singleRoute.generateSingleRoute(sr4);
        //singleRoute.generateSingleRoute(sr5);
        //singleRoute.generateSingleRoute(sr6);


        // CALCOLO TEMPO MEDIO DI PERCORRENZA
        System.out.println(route.calculateAvgTime(1L));
        System.out.println(route.calculateAvgTime(2L));
        System.out.println(route.calculateAvgTime(3L));


        // CALCOLO DEL NUMERO DI VOLTE CHE UN MEZZO PERCORRE UNA SPECIFICA TRATTA
        Long routeId = 1L;
        Long vehicleId = 1L;
        System.out.println("Il mezzo " + vehicleId+ " ha percorso "  +singleRoute.routesPerVehicle(routeId,vehicleId)+ " volte la tratta " + routeId);

    }

}
