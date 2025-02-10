package ad.dam.Ejemplo1.Repository;

import ad.dam.Ejemplo1.Model.Post;
import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends ListCrudRepository<Post, Integer> {}

/* Cuando lo hemos hecho de forma manual para JdbcPostRepository y MemoryPostRepository
public interface PostRepository {
    public List<Post> getAllPost();
    public Post getPostById(int id);
    public void savePost(Post post);
    public void updatePost(int id, Post p);
    public void deletePost(int id);
}*/
