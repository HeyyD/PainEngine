package painengine.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundManager
{

	private Clip music = null;
	private boolean loop = true;

	public void playSound(String path){
		try {
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			Clip c = AudioSystem.getClip();
			c.open(inputStream);
			c.start();
		} catch(Exception e){
				System.out.println("Something went wrong: " + e);
		}
	}

	public void setMusic(String path){
		try {
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			music = AudioSystem.getClip();
			music.open(inputStream);
		} catch(Exception e){
				System.out.println("Something went wrong: " + e);
		}
	}

	public void startMusic(){
		if(music != null){
			if(loop){
				music.loop(Clip.LOOP_CONTINUOUSLY);
			} else{
				music.start();
			}
		}
	}

	public void stopMusic(){
		if(music != null){
			music.stop();
		}
	}

	public void loop(boolean value){this.loop = value;}
}

