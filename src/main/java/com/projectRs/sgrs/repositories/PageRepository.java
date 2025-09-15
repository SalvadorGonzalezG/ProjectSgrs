package com.projectRs.sgrs.repositories;

import com.projectRs.sgrs.entities.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PageRepository extends JpaRepository<PageEntity, Long> {

    // SELECT * FROM page WHERE title = :title
    // @Query("from PageEntity where title = :title") //JPQL
    Optional<PageEntity> findByTitle(String title);

    //Optional<PageEntity> deleteByTitle(String title);
    // Query -> delete page
    // Delete * from page where title = title;
    @Modifying
    @Query("DELETE FROM PageEntity WHERE title=:title")
    void deleteByTitle(@Param("title") String title);

    // If exist return true if not return false
    Boolean existsByTitle(String title);

}
