package ad.dam.Ejemplo1.Controller;

import ad.dam.Ejemplo1.Model.Post;
import ad.dam.Ejemplo1.Repository.JdbcPostRespository;
import ad.dam.Ejemplo1.Repository.MemoryPostRespository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MiControlador {

    /*private final MemoryPostRespository postRepository;

    public MiControlador(MemoryPostRespository postRepository) {
        this.postRepository = postRepository;
    }*/
    private final JdbcPostRespository postRepository;

    public MiControlador(JdbcPostRespository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public List<Post> getAllPosts(){
        return postRepository.getAllPost();
    }

    // http://localhost:8080/post?id=21
    @GetMapping("/post")
    public Post getPostById(@RequestParam int id){
        return postRepository.getPostById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void savePost(@RequestBody Post p){
        postRepository.savePost(p);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/post")
    public void updatePost(@RequestParam int id, @RequestBody Post p){
        postRepository.updatePost(id, p);
    }

    // Lo hago distinto para utilizar el envio de parametros en la ruta
    // http://localhost:8080/delete?id=21 Podria ser asi, pero hemos decidido hacerlo de otra forma
    // http://localhost:8080/delete/21
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable int id){
        postRepository.deletePost(id);
    }


}
