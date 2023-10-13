package com.example.song;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.song.SongRepository;
import com.example.song.Song;

@RestController
class SongController {
  SongService songService = new SongService();

  @GetMapping("/songs")
  public ArrayList<Song> getSongs() {
    return songService.getSongs();
  }

  @GetMapping("/songs/{songId}")
  public Song getSongBySongId(@PathVariable("songId") int songId) {
    return songService.getSongBySongId(songId);
  }

  @PutMapping("/songs/{songId}")
  public Song updateSong(@PathVariable("songId") int songId, String singer, @RequestBody Song song) {

    return songService.updateSong(songId, singer, song);
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

// Write your code here