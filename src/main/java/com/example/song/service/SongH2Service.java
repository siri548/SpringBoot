package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.song.repository.SongRepository;
import com.example.song.model.Song;
import com.example.song.model.SongRowMapper;

// Write your code here
@Service
public class SongH2Service implements SongRepository {
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Song> getSongs() {
        Collection<Song> songsList = db.query("select * from playlist", new SongRowMapper());
        ArrayList<Song> songs = new ArrayList<>(songsList);
        return songs;

    }

    @Override
    public Song getSongById(int songId) {
        try {
            Song song = db.queryForObject("select * from playlist where songId=?", new SongRowMapper(), songId);
            return song;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song song) {
        db.update("INSERT INTO playlist(songId, songName, lyricist, singer, musicDirector) VALUES (?,?,?,?,?)",
                song.getSongId(), song.getSongName(), song.getLyricist(), song.getSinger(), song.getMusicDirector());
        Song addedSong = db.queryForObject(
                "select * from playlist where songName=? and lyricist=? and singer=? and musicDirector=?",
                new SongRowMapper(), song.getSongName(), song.getLyricist(), song.getSinger(), song.getMusicDirector());
        return addedSong;

    }

    @Override
    public Song updateSong(int songId, Song song) {
        if (song.getSongName() != null) {
            db.update("update playlist SET songName=? where songId=?", song.getSongName(), songId);
        }
        if (song.getLyricist() != null) {
            db.update("update playlist SET lyricist=? where songId=?", song.getLyricist(), songId);
        }
        if (song .getSinger() != null) {
            db.update("update playlist SET singer=? where songId=? ", song.getSinger(), songId);

        }
        if (song.getMusicDirector() != null) {
            db.update("update playlist SET musicDirector=? where songId=? ", song.getMusicDirector(), songId);
        }
        return getSongById(songId);
    }

    @Override
    public void deleteSong(int songId) {
        db.update("delete from playlist where songId=?", songId);
    }
}
