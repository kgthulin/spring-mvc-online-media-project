package coder.daos;

import coder.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CatDao {
    List<Category> getAllCat();
    void addCat(Category category);
    Category getCatById(int id);
    void updateCat(Category category);
    void deleteCat(int id);
}
