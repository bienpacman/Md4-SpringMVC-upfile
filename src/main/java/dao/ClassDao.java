package dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClassDao {
    @Autowired
    EntityManager entityManager;

    public List<Class> getClassList() {
        String queryStr = "SELECT c FROM Class c";
        TypedQuery<Class> query = entityManager.createQuery(queryStr,Class.class);
        return query.getResultList();
    }
}
