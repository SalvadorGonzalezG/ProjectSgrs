package com.projectRs.sgrs.services;

import com.projectRs.sgrs.dto.PageRequest;
import com.projectRs.sgrs.dto.PageResponse;
import com.projectRs.sgrs.dto.PostRequest;
import com.projectRs.sgrs.dto.PostResponse;
import com.projectRs.sgrs.repositories.PageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PageServiceImp implements PageService{

    private final PageRepository pageRepository; // ID

    @Override
    public PageResponse create(PageRequest page){
        return null;
    }
    @Override
    public PageResponse readByTitle(String title){
        return null;
    }

    @Override
    public PageResponse update(PageRequest page, String title){
        return null;
    }


    @Override
    public void delete(String title){

    }

    @Override
    public PostResponse createPost(PostRequest post){
        return null;
    }

    @Override
    public PostResponse deletePost(Long idPost){
        return null;
    }
}
