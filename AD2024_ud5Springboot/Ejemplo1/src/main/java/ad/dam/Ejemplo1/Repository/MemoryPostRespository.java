package ad.dam.Ejemplo1.Repository;

import ad.dam.Ejemplo1.Model.Post;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryPostRespository {

    private List<Post> posts = new ArrayList<>();

    // Will return all post from the blog
    public List<Post> getAllPost(){
        return posts;
    }

    // Will save a post that it's received as a param
    public void savePost(Post post){
        posts.add(post);
    }


    // Se ejecuta al incializar la clase para precargarla con datos
    @PostConstruct
    public void init(){
        posts.add(new Post(1, "Welcome to My Blog", "Hello everyone! This is my first blog post. I'm excited to share my thoughts and experiences with you."));
        posts.add(new Post(2, "Exploring New Horizons", "Today, I want to talk about the importance of stepping out of your comfort zone and trying new things."));
        posts.add(new Post(3, "The Joy of Cooking", "Cooking has always been a passion of mine. In this post, I'll share some of my favorite recipes and cooking tips."));
        posts.add(new Post(4, "Travel Adventures", "Recently, I traveled to Japan and had an amazing experience. Here are some highlights from my trip."));
        posts.add(new Post(5, "Book Recommendations", "I've been reading some fantastic books lately. In this post, I'll recommend a few that I think you'll love."));
        posts.add(new Post(6, "Fitness Journey", "Staying fit is important to me. I'll share my fitness routine and some tips for maintaining a healthy lifestyle."));
        posts.add(new Post(7, "Reflections on Life", "Sometimes, it's good to pause and reflect on life. In this post, I'll share some of my thoughts and insights."));
    }

    public void updatePost(int id, Post p) {
    }

    public void deletePost(int id) {
    }
}
