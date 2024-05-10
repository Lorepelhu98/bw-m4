package it.epicode.trasporti.dao.implementations;

import it.epicode.trasporti.dao.BaseDao;
import it.epicode.trasporti.dao.interfaces.SingleRouteDao;
import it.epicode.trasporti.entities.tranports.Maintenance;
import it.epicode.trasporti.entities.tranports.SingleRoute;
import it.epicode.trasporti.entities.tranports.Vehicle;
import it.epicode.trasporti.exceptions.VehicleUnderMaintenanceException;
import jakarta.persistence.NoResultException;

import java.time.LocalDate;
import java.util.List;

public class SingleRouteDaoImpl extends BaseDao implements SingleRouteDao {

    @Override
    public void save(SingleRoute sr){
        try{
            log.debug("Saving {}", sr);
            var t = em.getTransaction();
            t.begin();
            em.persist(sr);
            log.debug("Before commit {}", sr);
            t.commit();
            log.debug("After commit {}", sr);
        } catch (Exception e){
            log.error("Exception saving entity...", e);
        }
    }

    @Override
    public void generateSingleRoute(SingleRoute sr) {
        try {
            RouteDaoImpl route = new RouteDaoImpl();
            Vehicle vehicle = sr.getVehicle();
            List<Maintenance> maintenances = em.createQuery("SELECT m FROM Maintenance m WHERE m.vehicle = :vehicle", Maintenance.class)
                    .setParameter("vehicle", vehicle)
                    .getResultList();
            boolean isUnderMaintenance = maintenances.stream()
                    .anyMatch(e -> e.getEnd() == null || e.getEnd().isAfter(LocalDate.now()));
            if (isUnderMaintenance) {
                String message = String.format("Il veicolo %d è in manutenzione. Impossibile assegnare tratta '%s' al veicolo.", vehicle.getId(), sr.getRoute().getStartingZone(), sr.getRoute().getEndOfLine());
                log.info(message);
                throw new VehicleUnderMaintenanceException(message);
            } else {
                save(sr);
                route.updateAvgTime(sr.getRoute().getId());
            }
        } catch (Exception e) {
            log.error("Errore durante la generazione del percorso: " + e.getMessage());
        }
    }

    @Override
    public Long routesPerVehicle(Long routeId, Long vehicleId){

        try {
            return em.createQuery("SELECT COUNT(v) FROM SingleRoute v WHERE v.route.id =:routeId AND v.vehicle.id =:vehicleId", Long.class)
                    .setParameter("routeId", routeId)
                    .setParameter("vehicleId", vehicleId)
                    .getSingleResult();
        } catch (NoResultException ex){
            return 0L;
        }
    }

}
