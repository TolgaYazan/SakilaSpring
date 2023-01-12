package com.uniyaz.sakila.core.film.dao;

import com.uniyaz.sakila.core.film.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmDao extends JpaRepository<Film,Long> {

//    List<Film> findByCategory_IdEquals(Long id);
}
