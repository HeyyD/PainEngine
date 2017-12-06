package painengine.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundManager
{
	public void playSound(String sound){
		try {
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(sound).getAbsoluteFile());
			Clip c = AudioSystem.getClip();
			c.open(inputStream);
			c.start();
		} catch(Exception e){
				System.out.println("Something went wrong: " + e);
		}
	}
}

