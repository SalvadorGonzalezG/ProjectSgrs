package com.projectRs.sgrs.controllers;

import com.projectRs.sgrs.dto.PageResponse;
import com.projectRs.sgrs.services.PageService;
import jakarta.persistence.OrderBy;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // use to expose RESTful
@RequestMapping(path = "page") // to get this controller
@NoArgsConstructor(force = true)
public class PageController {

    private final PageService pageService;

    @GetMapping
    public ResponseEntity<PageResponse> getPage(){
        return null;
    }

    @PostMapping
    public ResponseEntity<?> postPage(){
        return null;
    }

    @PutMapping
    public  ResponseEntity<?> updatePage(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePage(){
        return null;
    }
}
