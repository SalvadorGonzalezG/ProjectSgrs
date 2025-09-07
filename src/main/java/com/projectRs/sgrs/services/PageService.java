package com.projectRs.sgrs.services;

import com.projectRs.sgrs.dto.PageRequest;
import com.projectRs.sgrs.dto.PageResponse;
import com.projectRs.sgrs.dto.PostRequest;
import com.projectRs.sgrs.dto.PostResponse;

public interface PageService {

    PageResponse create(PageRequest page);

    PageResponse readByTitle(String title);

    PageResponse update(PageRequest page, String title);

    // Eliminar por titutlo
    void delete(String title);

    //crear un post
    PostResponse createPost(PostRequest post);

    PostResponse deletePost(Long idPost);

}
