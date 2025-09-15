package com.projectRs.sgrs.services;

import com.projectRs.sgrs.dto.PageRequest;
import com.projectRs.sgrs.dto.PageResponse;
import com.projectRs.sgrs.dto.PostRequest;
import com.projectRs.sgrs.dto.PostResponse;
import com.projectRs.sgrs.entities.PageEntity;
import com.projectRs.sgrs.entities.PostEntity;
import com.projectRs.sgrs.repositories.PageRepository;
import com.projectRs.sgrs.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional; // Gestiona Commits, rollbacks propagaciones y isolaciones

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PageServiceImp implements PageService{

    private final PageRepository pageRepository; // ID
    private final UserRepository userRepository; // Obtencion del usuario atravez del repoditorio

    @Override
    public PageResponse create(PageRequest page){

        final var entity = new PageEntity();// Create Object entity to persist in DataBase

        BeanUtils.copyProperties(page, entity); // Copi properties from argument page in entity
        // seteo del usuaio
        final var user = this.userRepository.findById(page.getUserId()) // Search user coresponds to page
                .orElseThrow();
        entity.setDateCreation(LocalDateTime.now()); //seteo de la fecha (set date now)
        entity.setUser(user); // Create relationship between users and page
        //entity.setPosts(new ArrayList<>()); // Set empty list

        var pageCreated = this.pageRepository.save(entity); // Upseat id exists id update else insert
        final var response = new PageResponse(); // Create DTO for response

        BeanUtils.copyProperties(pageCreated, response); // Copy properties from entity(pageCreated) in response
        return response;
    }
    @Override
    public PageResponse readByTitle(String title){
        final var entityResponse = this.pageRepository.findByTitle(title) // findByTitle and handle erros
                .orElseThrow(()-> new IllegalArgumentException("Title not found"));

        final var response = new PageResponse(); // create response Obj

        BeanUtils.copyProperties(entityResponse, response); // Copy properties from entity

        // Mapeo de Post
        final List<PostResponse> postResponses = entityResponse.getPosts() // Get post responses from ´post entity
                .stream() // Convert to stream
                .map(postE -> // transform postEntity to postResponse
                    PostResponse
                           .builder()
                           .img(postE.getImg())
                           .content(postE.getContent())
                           .dateCreation(postE.getDateCreation())
                           .build()
                )
                .toList(); // convert To list

        response.setPosts(postResponses); //set list of post
        return response;
    }

    @Override
    public PageResponse update(PageRequest page, String title){
        final var entityFromDB = this.pageRepository.findByTitle(title)
                .orElseThrow(()-> new IllegalArgumentException("Title not found"));
        entityFromDB.setTitle(page.getTitle()); // Update fields prom param pages

        var pageCreated = this.pageRepository.save(entityFromDB);
        final var response = new PageResponse();
        BeanUtils.copyProperties(pageCreated, response);
        return response;
    }


    @Override
    public void delete(String title){
        // Delete by title
        /*final var entityFromDB = this.pageRepository.findByTitle(title)
                .orElseThrow(()-> new IllegalArgumentException("Title not found"));
        this.pageRepository.delete(entityFromDB);*/

        if (this.pageRepository.existsByTitle(title)){

            log.info("Deliting page");
            this.pageRepository.deleteByTitle(title);
        }else {
            log.error("Error to delete");
            throw new IllegalArgumentException("Cant delete because id not exist");
        }
    }

    @Override
    public PageResponse createPost(PostRequest post){
        return null;
    }

    @Override
    public PageResponse deletePost(Long idPost){
        return null;
    }
}
