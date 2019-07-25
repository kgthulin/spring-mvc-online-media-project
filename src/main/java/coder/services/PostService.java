package coder.services;

import coder.daos.PostDao;
import coder.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostDao postDao;

    public void addPost(Post post) {
        postDao.addPost(post);
    }

    public List<Post> getAllPost() {
        return postDao.getAllPost();
    }

    public Post getPost(int id) {
        return postDao.getPost(id);
    }

    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    public void deletePost(int id) {
        postDao.deletePost(id);
    }
}
