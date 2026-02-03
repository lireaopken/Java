package com.example.demo;

import com.example.demo.SongCreateRequest;
import com.example.demo.Artist;
import com.example.demo.Song;
import com.example.demo.ArtistRepository;
import com.example.demo.SongRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongRepository songRepo;
    private final ArtistRepository artistRepo;

    public SongController(SongRepository songRepo, ArtistRepository artistRepo) {
        this.songRepo = songRepo;
        this.artistRepo = artistRepo;
    }

    @GetMapping
    public List<Song> getAll() {
        return songRepo.findAll();
    }

    @GetMapping("/{id}")
    public Song getById(@PathVariable Long id) {
        return songRepo.findById(id).orElseThrow();
    }

    @GetMapping("/by-artist/{artistId}")
    public List<Song> getByArtist(@PathVariable Long artistId) {
        return songRepo.findByArtistId(artistId);
    }

    @PostMapping
    public Song create(@RequestBody SongCreateRequest req) {
        Artist artist = artistRepo.findById(req.getArtistId()).orElseThrow();

        Song song = new Song();
        song.setTitle(req.getTitle());
        song.setDurationSec(req.getDurationSec());
        song.setArtist(artist);

        return songRepo.save(song);
    }
}
