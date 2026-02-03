package com.example.demo;
import com.example.demo.Artist;
import com.example.demo.ArtistRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistRepository artistRepo;

    public ArtistController(ArtistRepository artistRepo) {
        this.artistRepo = artistRepo;
    }

    @GetMapping
    public List<Artist> getAll() {
        return artistRepo.findAll();
    }

    @GetMapping("/{id}")
    public Artist getById(@PathVariable Long id) {
        return artistRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Artist create(@RequestBody Artist artist) {
        return artistRepo.save(artist);
    }
}
