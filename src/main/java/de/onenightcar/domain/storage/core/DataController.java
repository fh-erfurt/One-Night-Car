package de.onenightcar.domain.storage.core;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataController {
    private static final String PERSISTENCE_UNIT_NAME = "OneNightCar";
    private EntityManagerFactory entityManagerFactory;
    private static DataController instance;

    public static DataController getInstance() {
        if (instance == null) {
            instance = new DataController();
        }
        return instance;
    }

    private DataController() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return this.entityManagerFactory;
    }
}
