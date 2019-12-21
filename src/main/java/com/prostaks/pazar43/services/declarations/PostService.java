package com.prostaks.pazar43.services.declarations;

import com.prostaks.pazar43.models.Category;
import com.prostaks.pazar43.models.Post;
import com.prostaks.pazar43.models.Region;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    public List<Post> listAllPosts();
    public List<Post> listByCategoryAndTitleAndRegion(Category category, String title, Region region);
}
