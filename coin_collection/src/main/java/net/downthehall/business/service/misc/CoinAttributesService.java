package net.downthehall.business.service.misc;

import net.downthehall.business.model.entity.CoinattributesEntity;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;

/**
 * Created by joseph on 7/30/2014.
 */
@Stateless
public class CoinAttributesService extends BaseJPADAO
{
    /*public List<CoinattributesEntity> getAll()
    {
        String sql = "SELECT c FROM CoinattributesEntity c";
        Query query = getEntityManager().createQuery(sql, CoinattributesEntity.class);
        List<CoinattributesEntity> list = query.getResultList();
        if (list.size() != 0)
        {
            closeEntityManager();
            return list;
        }
        else
        {
            closeEntityManager();
            return null;
        }
    }*/

    public Collection<CoinattributesEntity> getAll()
    {
        CriteriaQuery<CoinattributesEntity> query =
                getEntityManager().getCriteriaBuilder().createQuery(CoinattributesEntity.class);

        query.select(query.from(CoinattributesEntity.class));
        Collection<CoinattributesEntity> resultList = getEntityManager().createQuery(query).getResultList();

//        System.out.println(resultList.toString());
        return resultList;
    }

    /*@PersistenceContext(unitName = "cdipu")
    private EntityManager entityManager;

    public Collection<CoinattributesEntity> getAll()
    {
        CriteriaQuery<CoinattributesEntity> query = entityManager.getCriteriaBuilder().createQuery(CoinattributesEntity.class);

        query.select(query.from(CoinattributesEntity.class));
        resultList = entityManager.createQuery(query).getResultList();

        System.out.println(resultList.toString());
        return resultList;
    }*/
}
