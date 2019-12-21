package com.prostaks.pazar43.services.implementations;

import com.prostaks.pazar43.models.Category;
import com.prostaks.pazar43.models.Post;
import com.prostaks.pazar43.models.Region;
import com.prostaks.pazar43.repository.PostRepository;
import com.prostaks.pazar43.services.declarations.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> listAllPosts(){
        return postRepository.findAll();
    }

    @Override
    public List<Post> listByCategoryAndTitleAndRegion(Category category, String title, Region region) {
        return postRepository.findAllByCategoryAndTitleAndRegionOrderByDateCreatedDesc(category, title, region);
    }

    public List<Post> listPostByCategory(Category category){
        return postRepository.findAllByCategoryOrderByDateCreatedDesc(category);
    }
}
