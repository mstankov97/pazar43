package com.prostaks.pazar43.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue
    Long id;

    String title;
    String description;

    Integer price;
    LocalDateTime dateCreated;
    Region region;

    @ManyToOne
    Category category;



}
