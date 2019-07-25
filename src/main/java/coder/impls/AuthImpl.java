package coder.impls;

import coder.daos.AuthDao;
import coder.models.Authority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AuthImpl implements AuthDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addAuth(Authority auth) {
        session().save(auth);
        session().flush();
    }
}
