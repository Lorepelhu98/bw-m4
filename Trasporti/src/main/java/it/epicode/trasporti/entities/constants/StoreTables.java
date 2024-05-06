package it.epicode.trasporti.entities.constants;

public class StoreTables {

    public static class Names {
        public static final String TICKET_MACHINES = "ticket_machines";
        public static final String RESELLERS = "resellers";
    }

    public static class Discriminators {
        public static final String TICKET_MACHINES = "0";
        public static final String RESELLERS = "1";
    }
}
