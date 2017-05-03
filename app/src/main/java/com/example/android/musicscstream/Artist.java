package com.example.android.musicscstream;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources;

import java.util.ArrayList;

public class Artist {

    private String artistName;
    private int imageId = IMAGE_NOT_AVAILABLE;
    private static final int IMAGE_NOT_AVAILABLE = -1;

    private ArrayList<Album> albums = new ArrayList<Album>();
    private ArrayList<Song> allSongs = new ArrayList<Song>();

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String pArtistName) {
        artistName = pArtistName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int pImageId) {
        imageId = pImageId;
    }


    public Artist(Context context, String artistName, int artistImageId) {
        this.artistName = artistName;
        this.imageId = artistImageId;

        Resources res = context.getResources();

        for (int i = 0; i < 6; i++) {
            int j = i + 1;
            String imgName = "album_" + j + "_thumb";
            int resID = res.getIdentifier(imgName, "drawable", context.getPackageName());
            albums.add(new Album("Album " + i + ", " + artistName, resID));
        }
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public ArrayList<Song> getSongs() {
        for (Album album : albums) {
            ArrayList<Song> songs = album.getSongs();

            for (Song song : songs) {
                allSongs.add(song);
            }
        }
        return allSongs;
    }

    public boolean hasImage() {
        return imageId != IMAGE_NOT_AVAILABLE;
    }
}
