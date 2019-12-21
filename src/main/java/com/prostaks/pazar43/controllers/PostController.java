package com.prostaks.pazar43.controllers;

import com.prostaks.pazar43.models.Post;
import com.prostaks.pazar43.models.Region;
import com.prostaks.pazar43.services.declarations.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/posts")
    public List<Post> listAllPosts(){
        return postService.listAllPosts();
    }
   /* @GetMapping(path = "/posts/{region}/{category")
    public List<Post> listByRegionAndCategory(@RequestParam Long id, @RequestParam Region region){

    }*/
}
