package com.projectRs.sgrs.controllers;

import com.projectRs.sgrs.dto.PageRequest;
import com.projectRs.sgrs.dto.PageResponse;
import com.projectRs.sgrs.services.PageService;
import jakarta.persistence.OrderBy;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URL;

@RestController // use to expose RESTful
@RequestMapping(path = "page") // to get this controller
@AllArgsConstructor
public class PageController {

    @Autowired
    private PageService pageService;


    @GetMapping(path = "{title}") // use to get data
    public ResponseEntity<PageResponse> getPage(@PathVariable String title){
        return ResponseEntity.ok(this.pageService.readByTitle(title));
    }

    @PostMapping //use to create data
    public ResponseEntity<?> postPage(@RequestBody PageRequest request){
        request.setTitle(this.normalizeTitle(request.getTitle()));
        final var uri = this.pageService.create(request).getTitle();
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @PutMapping // use to update data
    public  ResponseEntity<?> updatePage(){
        return null;
    }

    @DeleteMapping // use to delete data
    public ResponseEntity<Void> deletePage(){
        return null;
    }

    private String normalizeTitle(String title){
        if (title.contains(" ")){
            return title.replaceAll("\\s+", "-");
        }else {
            return title;
        }
    }
}
