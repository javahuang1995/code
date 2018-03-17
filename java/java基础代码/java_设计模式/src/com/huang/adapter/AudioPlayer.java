package com.huang.adapter;

public class AudioPlayer implements MediaPlayer{

	MediaAdapter mediaAdapter;
	public void play(String audioType, String fileName) {
		if("mp3".equalsIgnoreCase(audioType)){
			System.out.println("Playing mp3 file.Name:"+fileName);
		}
		else if("mp4".equalsIgnoreCase(audioType)
				|| "avi".equalsIgnoreCase(audioType)){
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}else{
			System.out.println("not support!!!");
		}
		
	}
	

}
