package com.olddrivers.tickets.business.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

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
	
	private String releaseDate;
	
	private String storyLine;
	
	private String detail;
	
	private String poster;
	
	private Float avgScore;
	
	private Boolean isShow;
	
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
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	@Column(name = "movie_name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "movie_releaseDate")
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Column(name = "movie_isShow")
	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
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
	
	
	@Column(name = "movie_avgScore", columnDefinition="decimal(2,1) default 0.0")
	@DecimalMin("0.1")
	public Float getAvgScore() {
		return avgScore;
	}
	
	
	public void setAvgScore(Float avgScore) {
		this.avgScore = avgScore;
	}

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="movie_type_id")
	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

}
