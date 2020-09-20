package com.movie.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity

@Data
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private @NonNull String name;
    private @NonNull String genre;
    private @NonNull String language;
    private @NonNull String yearReleased;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss z")
    private @NonNull Date releaseDate;
    private @NonNull String rating;
    private @NonNull Long length;

}
