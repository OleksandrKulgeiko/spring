package com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by akulgeiko on 7/20/2018.
 */
public class BloggerRepositoryImpl implements BloggerSweeper {

    @PersistenceContext
    private EntityManager em;

    public int eliteSweep() {
        String update =
                "UPDATE Spitter spitter " +
                        "SET spitter.status = 'Elite' " +
                        "WHERE spitter.status = 'Newbie' " +
                        "AND spitter.id IN (" +
                        "SELECT s FROM Spitter s WHERE (" +
                        "  SELECT COUNT(spittles) FROM s.spittles spittles) > 10000" +
                        ")";
        return em.createQuery(update).executeUpdate();
    }

}
