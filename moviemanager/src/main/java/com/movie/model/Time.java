package com.movie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Time {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private @NonNull String week_number;
    private @NonNull String utc_offset;
    private @NonNull String unixtime;
    private @NonNull String timezone;
    private @NonNull String dst_until = null;
    private @NonNull String dst_from = null;
    private @NonNull Boolean dst;
    private @NonNull String day_of_year;
    private @NonNull String day_of_week;
    private @NonNull String datetime;
    private @NonNull String abbreviation;

}
