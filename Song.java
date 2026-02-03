package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer durationSec;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    public Song() {}

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Integer getDurationSec() { return durationSec; }
    public Artist getArtist() { return artist; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDurationSec(Integer durationSec) { this.durationSec = durationSec; }
    public void setArtist(Artist artist) { this.artist = artist; }
}
