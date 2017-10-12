package com.accounting.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

  private static final String PERSISTENT_UNIT_NAME = "PERSISTENCE";

  private static final EntityManagerFactory emf;
  
  static {
    try {
      emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
    } catch (Throwable ex) {
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
}

