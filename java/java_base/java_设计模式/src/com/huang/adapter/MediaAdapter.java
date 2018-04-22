package com.huang.adapter;

public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMusicPlayer;

	public MediaAdapter(String audiType) {
		if ("avi".equalsIgnoreCase(audiType)) {
			advancedMusicPlayer = new AviPlayer();
		} else if ("mp4".equalsIgnoreCase(audiType)) {
			advancedMusicPlayer = new Mp4Player();
		}
	}

	public void play(String audiType, String filename) {
		if ("avi".equalsIgnoreCase(audiType)) {
			advancedMusicPlayer.playAvi(filename);
		} else if ("mp4".equalsIgnoreCase(audiType)) {
			advancedMusicPlayer.playMp4(filename);
		}
	}

}
