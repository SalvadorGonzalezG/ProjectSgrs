package com.projectRs.sgrs.services;

import com.projectRs.sgrs.dto.PageRequest;
import com.projectRs.sgrs.dto.PageResponse;
import com.projectRs.sgrs.dto.PostRequest;

public interface PageService {

    PageResponse create(PageRequest page);

    PageResponse readByTitle(String title);

    PageResponse update(PageRequest page, String title);

    // Eliminar por titutlo
    void delete(String title);

    //crear un post
    // ->post hijo de paginas (una pagina contine muchos post) y un post simepre dependera de una pagina tando en Db como en nuesto sistema
    PageResponse createPost(PostRequest post, String title);

    void deletePost(Long idPost, String title);

}
