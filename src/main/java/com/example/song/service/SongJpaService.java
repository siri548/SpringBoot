package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.song.repository.SongRepository;
import com.example.song.repository.SongJpaRepository;
import com.example.song.model.Song;

@Service
public class SongJpaService implements SongRepository {

    @Autowired
    private SongJpaRepository songJpaRepository;

    @Override
    public ArrayList<Song> getSongs() {
        List<Song> allSongs = songJpaRepository.findAll();
        ArrayList<Song> songs = new ArrayList<>(allSongs);
        return songs;
    }

    @Override
    public Song getSongById(int songId) {
        Optional<Song> song = songJpaRepository.findById(songId);
        if (song.isPresent()) {
            Song req = song.get();
            return req;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song song) {
        songJpaRepository.save(song);
        return song;
    }

    @Override
    public Song updateSong(int songId, Song song) {
        Optional<Song> newSong = songJpaRepository.findById(songId);
        if (newSong.isPresent()) {
            Song req = newSong.get();
            if (song.getSongName() != null) {
                req.setSongName(song.getSongName());
            }
            if (song.getLyricist() != null) {
                req.setLyricist(song.getLyricist());
            }
            if (song.getSinger() != null) {
                req.setSinger(song.getSinger());
            }
            if (song.getMusicDirector() != null) {
                req.setMusicDirector(song.getMusicDirector());
            }
            return req;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteSong(int songId) {
        songJpaRepository.deleteById(songId);
    }

}

// Write your code here