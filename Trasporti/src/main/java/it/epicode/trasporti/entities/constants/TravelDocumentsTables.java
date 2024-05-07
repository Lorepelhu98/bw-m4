package it.epicode.trasporti.entities.constants;

public class TravelDocumentsTables {

    public static class Names {
        public static final String TICKETS = "tickets";
        public static final String TRAVEL_PASS = "travel_pass";

    }

    public static class Discriminators {
        public static final String TICKETS = "0";
        public static final String TRAVEL_PASS = "1";

    }

}
