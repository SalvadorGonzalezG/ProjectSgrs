package com.projectRs.sgrs.repositories;

import com.projectRs.sgrs.entities.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PageRepository extends JpaRepository<PageEntity, Long> {

    // SELECT * FROM page WHERE title = :title
    // @Query("from PageEntity where title = :title") //JPQL
    Optional<PageEntity> findByTitle(String title);

    //Optional<PageEntity> deleteByTitle(String title);
    // Query -> delete page
    // Delete * from page where title = title;
    void deleteByTitle(String title);

    // If exist return true if not return false
    Boolean existByTitle(String title);

}
