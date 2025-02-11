package ad.dam.Ejemplo1.Controller;

import ad.dam.Ejemplo1.Model.Post;
import ad.dam.Ejemplo1.Repository.PostRepository;
import ad.dam.Ejemplo1.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MiControlador {

    private final PostService postService;

    public MiControlador(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public List<Post> getAllPosts(){
        return postService.getAllPost();
    }

    // http://localhost:8080/post?id=21
    @GetMapping("/post")
    public Optional<Post> getPostById(@RequestParam int id){
        return postService.getPostById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void savePost(@RequestBody Post p){
        postService.savePost(p);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/post")
    public void updatePost(@RequestParam int id, @RequestBody Post p){
       postService.updatePost(id, p);
    }

    // Lo hago distinto para utilizar el envio de parametros en la ruta
    // http://localhost:8080/delete?id=21 Podria ser asi, pero hemos decidido hacerlo de otra forma
    // http://localhost:8080/delete/21
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable int id){
        postService.deletePost(id);
    }


}
