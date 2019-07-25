package coder.daos;

import coder.models.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostDao {
    void addPost(Post post);
    List<Post> getAllPost();
    Post getPost(int id);
    void updatePost(Post post);
    void deletePost(int id);
}
