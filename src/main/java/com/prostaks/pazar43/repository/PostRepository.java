package com.prostaks.pazar43.repository;

import com.prostaks.pazar43.models.Category;
import com.prostaks.pazar43.models.Post;
import com.prostaks.pazar43.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PostRepository  extends JpaRepository<Post,Long> {

        List<Post> findAllByCategoryOrderByDateCreatedDesc(Category category);
        List<Post> findAllByRegionOrderByDateCreatedDesc(Region region);
        List<Post> findAllByTitleOrderByDateCreatedDesc(String  title);
        List<Post> findAllByPriceLessThanOrderByDateCreatedDesc(Integer price);
        List<Post> findAllByCategoryAndTitleAndRegionOrderByDateCreatedDesc(Category category, String title, Region region);
}
