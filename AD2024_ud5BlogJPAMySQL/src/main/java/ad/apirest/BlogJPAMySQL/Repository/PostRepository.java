package ad.apirest.BlogJPAMySQL.Repository;

import ad.apirest.BlogJPAMySQL.Model.Post;
import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends ListCrudRepository<Post, Integer> {}
