package ad.dam.Ejemplo1.Repository;

import ad.dam.Ejemplo1.Model.Post;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPostRespository{


        private final JdbcClient jdbcClient;

        public JdbcPostRespository(JdbcClient jdbcClient) {
            this.jdbcClient = jdbcClient;
        }

        public List<Post> getAllPost() {
            return jdbcClient.sql("SELECT id, titulo, mensaje FROM articulos")
                    .query(Post.class)
                    .list();
        }

        public Post getPostById(int id) {
            return jdbcClient.sql("SELECT id, titulo, mensaje FROM articulos WHERE id = :id")
                    .param("id", id)
                    .query(Post.class)
                    .single();
        }

        public void savePost(Post p) {
            int update = jdbcClient.sql("INSERT INTO articulos(id, titulo, mensaje) VALUES (?,?,?)")
                    .params(List.of(p.getId(), p.getTitulo(), p.getMensaje()))
                    .update();
        }

        public void updatePost(int id, Post p) {
            int updated = jdbcClient.sql("UPDATE articulos SET titulo = ?, mensaje = ? WHERE id = ?")
                    .params(List.of(p.getTitulo(), p.getMensaje(), id))
                    .update();
        }

        public void deletePost(int id) {
            int updated = jdbcClient.sql("DELETE FROM articulos WHERE id = :id")
                    .param("id", id)
                    .update();
        }
    }

