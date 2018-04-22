package com.huang.adapter;

public class Demo {
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3","music1");
		audioPlayer.play("mp4", "music2");
		audioPlayer.play("avi","music3");
		audioPlayer.play("rmvb","music4");
	}
}
