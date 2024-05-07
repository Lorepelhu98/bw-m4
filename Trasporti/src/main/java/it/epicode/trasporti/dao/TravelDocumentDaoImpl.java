package it.epicode.trasporti.dao;

import it.epicode.trasporti.entities.travel_documents.TravelDocument;

public class TravelDocumentDaoImpl extends BaseDao implements TravelDocumentDao{

    @Override
    public void save(TravelDocument travelDocument){
        try{
            log.debug("Saving {}", travelDocument);
            var t = em.getTransaction();
            t.begin();
            em.persist(travelDocument);
            log.debug("Before commit {}", travelDocument);
            t.commit();
            log.debug("After commit {}", travelDocument);
        } catch (Exception e){
            log.error("Exception saving entity...", e);
        }
    }


}
