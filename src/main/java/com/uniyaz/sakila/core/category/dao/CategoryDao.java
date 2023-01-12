package com.uniyaz.sakila.core.category.dao;

import com.uniyaz.sakila.core.category.domain.Category;
import com.uniyaz.sakila.core.film.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {
    @Query(value ="select category_name as categoryname, last_update as lastUpdate from category where category_name LIKE '%?1%' or last_update LIKE '%?1%'",nativeQuery =  true)
    List<Film> searchCategory(String data);
}
