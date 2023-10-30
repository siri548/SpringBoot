package com.example.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.song.service.SongH2Service;
import com.example.song.model.Song;

@RestController
public class SongController {

  private final SongH2Service songService;

  @Autowired
  public SongController(SongH2Service songService) {
    this.songService = songService;
  }

  @GetMapping("/songs")
  public ArrayList<Song> getSongs() {
    return songService.getSongs();
  }

  @GetMapping("/songs/{songId}")
  public Song getSongById(@PathVariable("songId") int songId) {
    return songService.getSongById(songId);
  }

  @PutMapping("/songs/{songId}")
  public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song) {
    return songService.updateSong(songId, song);
  }

  @PostMapping("/songs")
  public Song addSong(@RequestBody Song song) {
    return songService.addSong(song);
  }

  @DeleteMapping("/songs/{songId}")
  public void deleteSong(@PathVariable("songId") int songId) {
    songService.deleteSong(songId);
  }
}
