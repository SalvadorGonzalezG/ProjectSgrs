package com.projectRs.sgrs.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Page")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDateTime dateCreation;

    @OneToOne
    @JoinColumn(name = "id_User", unique = true)
    private String user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostEntity> posts = new ArrayList<>();

    // function to addPost
    public void addPost(PostEntity post){
        posts.add(post);
    }

    //Remove f:
    public void removePost(PostEntity post){
        posts.remove(post);
    }
}
