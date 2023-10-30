// Write your code here
package com.example.song.repository;

import com.example.song.model.Song;
import com.example.song.model.SongRowMapper;
import java.util.*;

public interface SongRepository{
    ArrayList<Song> getSongs();
    Song addSong(Song song);
    Song updateSong(int songId, Song song);
    Song getSongById(int songId);
    void deleteSong(int songId);
    
}