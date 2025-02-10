package ad.dam.Ejemplo1.Controller;

import ad.dam.Ejemplo1.Model.Post;
import ad.dam.Ejemplo1.Repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MiControlador {

    private final PostRepository postRepository;

    public MiControlador(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    // http://localhost:8080/post?id=21
    @GetMapping("/post")
    public Optional<Post> getPostById(@RequestParam int id){
        return postRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void savePost(@RequestBody Post p){
        postRepository.save(p);
    }

   /* @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/post")
    public void updatePost(@RequestParam int id, @RequestBody Post p){
        postRepository.
    }*/

    // Lo hago distinto para utilizar el envio de parametros en la ruta
    // http://localhost:8080/delete?id=21 Podria ser asi, pero hemos decidido hacerlo de otra forma
    // http://localhost:8080/delete/21
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable int id){
        postRepository.deleteById(id);
    }


}
