package com.olddrivers.tickets.business.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
@Table(name = "movie")
public class Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;
	
	private String release_date;
	
	private String storyLine;
	
	private String detail;
	
	private String poster;
	
	private Float avgScore;
	
	private Boolean isshow;
	
	private MovieType movieType;
	
	public Movie() {
		super();
		
	}
	
	
	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy="org.hibernate.id.UUIDGenerator")
	@Column(name = "movie_id")
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	@Column(name = "moive_name")
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "movie_release_date")
	public String getRelease_date() {
		return release_date;
	}
	
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	@Column(name = "movie_isshow")
	public Boolean getIsshow() {
		return isshow;
	}

	public void setIsshow(Boolean isshow) {
		this.isshow = isshow;
	}

	
	@Column(name = "movie_storyline")
	public String getStoryLine() {
		return storyLine;
	}
	
	
	public void setStoryLine(String storyLine) {
		this.storyLine = storyLine;
	}
	
	@Column(name = "movie_detail")
	public String getDetail() {
		return detail;
	}
	
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Column(name = "movie_poster")
	public String getPoster() {
		return poster;
	}
	
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	
	@Column(name = "movie_avgScore")
	public Float getAvgScore() {
		return avgScore;
	}
	
	
	public void setAvgScore(Float avgScore) {
		this.avgScore = avgScore;
	}

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="movie_type_id")
	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

}
