package coder.services;

import coder.daos.CatDao;
import coder.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    @Autowired
    private CatDao catDao;

    public List<Category> getAllCat() {
        return catDao.getAllCat();
    }

    public void addCat(Category category) {
        catDao.addCat(category);
    }

    public Category getCatById(int id) {
        return catDao.getCatById(id);
    }

    public void updateCat(Category category) {
        catDao.updateCat(category);
    }

    public void deleteCat(int id) {
        catDao.deleteCat(id);
    }
}
