package org.learnspringframework.restfullwebservices.service;

import jakarta.validation.Valid;
import org.learnspringframework.restfullwebservices.Exceptions.PostNotFoundException;
import org.learnspringframework.restfullwebservices.Exceptions.UserNotFoundException;
import org.learnspringframework.restfullwebservices.data.Posts;
import org.learnspringframework.restfullwebservices.data.UserJpa;
import org.learnspringframework.restfullwebservices.repository.PostRepository;
import org.learnspringframework.restfullwebservices.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostsService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Posts> getAllPosts(){
      return postRepository.findAll();
    }

    public List<Posts> getAllPostByUserId(Long id) {
        List<Posts> userPosts = postRepository.findAll()
                .stream()
                .filter(post -> post.getUser().getId().equals(id))
                .toList();
        if(userPosts.isEmpty()){
            throw new PostNotFoundException("User by id : "+ id + " Doesn't have any posts Yet ");
        }
        return userPosts;
    }

    public Posts getPostByUserIdAndPostId(Long userId, Long postId) {

        return this.getAllPostByUserId(userId)
                .stream()
                .filter(posts -> posts.getId().equals(postId))
                .findFirst()
                .orElseThrow(() -> new PostNotFoundException("User by id " + userId + "does not have any posts by id : " + postId));

    }

    public int getUsersPostCount(Long userId) {
        return this.getAllPostByUserId(userId).size();
    }

    public Posts createNewPostForUser(Long id, @Valid Posts newPost) {

        Optional<UserJpa> user = userRepository.findById(id);

        if (user.isEmpty()){
            throw new UserNotFoundException("User is not Found By id  : "+ id);
        }

        newPost.setUser(user.get());

        return postRepository.save(newPost);

    }
}
