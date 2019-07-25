package coder.impls;

import coder.daos.CatDao;
import coder.models.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CatImpl implements CatDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    public List<Category> getAllCat() {
        Query query = session().createQuery("from Category");
        List<Category> cats = query.list();
        session().flush();
        return cats;
    }

    public void addCat(Category category) {
        session().save(category);
        session().flush();
    }

    public Category getCatById(int id) {
        Category cat = session().get(Category.class, id);
        session().flush();
        return cat;
    }

    public void updateCat(Category category) {
        session().saveOrUpdate(category);
        session().flush();
    }

    public void deleteCat(int id) {
        session().delete(getCatById(id));
        session().flush();
    }
}
