package ad.dam.Ejemplo1.Repository;

import ad.dam.Ejemplo1.Model.Post;
import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends ListCrudRepository<Post, Integer> {}


