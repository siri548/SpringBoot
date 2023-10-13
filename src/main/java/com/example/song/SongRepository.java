// Write your code here\
package com.example.song;

import com.example.song.Song;
import java.util.*;

public interface SongRepository {

    Song addSong(Song song);

    Song getSongBySongId(int songId);

    Song updateSong(int songId, String singer, Song song);

    ArrayList<Song> getSongs();

    void deleteSong(int songId);
}
