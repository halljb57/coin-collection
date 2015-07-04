package net.downthehall.business.service.misc;

import javax.persistence.EntityManager;

public class BaseJPADAO extends JPADAOFactory
{

    public EntityManager getEntityManager()
    {
        return JPADAOFactory.createEntityManager();
    }

    public void closeEntityManager()
    {
        JPADAOFactory.close();
    }

}
