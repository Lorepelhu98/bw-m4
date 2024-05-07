package it.epicode.trasporti.dao.implementations;

import it.epicode.trasporti.dao.BaseDao;
import it.epicode.trasporti.dao.interfaces.VehicleDao;
import it.epicode.trasporti.entities.tranports.Vehicle;
import jakarta.persistence.NoResultException;

public class VehicleDaoImpl extends BaseDao implements VehicleDao {

    @Override
    public void save(Vehicle vehicle){
        try{
            log.debug("Saving {}", vehicle);
            var t = em.getTransaction();
            t.begin();
            em.persist(vehicle);
            log.debug("Before commit {}", vehicle);
            t.commit();
            log.debug("After commit {}", vehicle);
        } catch (Exception e){
            log.error("Exception saving entity...", e);
        }
    }

    @Override
    public Vehicle findVehicleById(Long id){
        try{
            return em.createQuery("SELECT t FROM Vehicle t WHERE t.id =:id", Vehicle.class)
                    .setParameter("id",id)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

}
