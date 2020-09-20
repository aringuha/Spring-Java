package com.movie.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.model.Movie;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Integer>{
}
