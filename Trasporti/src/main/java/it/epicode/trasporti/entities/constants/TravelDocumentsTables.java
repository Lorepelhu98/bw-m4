package it.epicode.trasporti.entities.constants;

public class TravelDocumentsTables {

    public static class Names {
        public static final String TICKETS = "tickets";
        public static final String WEEKLY_PASS = "weekly_pass";
        public static final String MONTHLY_PASS = "monthly_pass";
    }

    public static class Discriminators {
        public static final String TICKETS = "0";
        public static final String WEEKLY_PASS = "1";
        public static final String MONTHLY_PASS = "2";
    }

}
