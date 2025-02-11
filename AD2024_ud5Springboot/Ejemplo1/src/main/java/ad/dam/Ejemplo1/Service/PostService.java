package ad.dam.Ejemplo1.Service;

import ad.dam.Ejemplo1.Model.Post;
import ad.dam.Ejemplo1.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(int id){
        return postRepository.findById(id);
    }

    public void savePost(Post post){
        postRepository.save(post);
    }

    public void updatePost(int id, Post p){
        Optional<Post> postModificar = postRepository.findById(id);
        if(postModificar.isPresent()){
            Post postRecuperado = postModificar.orElse(new Post());
            postRecuperado.setMensaje(p.getMensaje());
            postRecuperado.setTitulo(p.getTitulo());
            postRepository.save(postRecuperado);
        }
    }

    public void deletePost(int id){
        postRepository.deleteById(id);
    }

}
