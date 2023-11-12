package com.example.song.controller;

import com.example.song.model.Song;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.song.service.SongJpaService;

@RestController
public class SongController {

  private SongJpaService songJpaService;

  @Autowired
  public SongController(SongJpaService songJpaService) {
    this.songJpaService = songJpaService;
  }

  @GetMapping("/songs")
  public ArrayList<Song> getSongs() {
    return songJpaService.getSongs();
  }

  @GetMapping("/songs/{songId}")
  public Song getSongById(@PathVariable("songId") int songId) {
    return songJpaService.getSongById(songId);
  }

  @PutMapping("/songs/{songId}")
  public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song) {
    return songJpaService.updateSong(songId, song);
  }

  @PostMapping("/songs")
  public Song addSong(@RequestBody Song song) {
    return songJpaService.addSong(song);
  }

  @DeleteMapping("/songs/{songId}")
  public void deleteSong(@PathVariable("songId") int songId) {
    songJpaService.deleteSong(songId);
  }

}

// Write your code here