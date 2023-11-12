// Write your code here
package com.example.song.repository;

import com.example.song.model.Song;
import java.util.*;

public interface SongRepository {
    ArrayList<Song> getSongs();

    Song getSongById(int songId);

    Song updateSong(int songId, Song song);

    Song addSong(Song song);

    void deleteSong(int songId);
}