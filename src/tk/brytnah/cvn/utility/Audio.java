
package tk.brytnah.cvn.utility;

import java.io.File;
import java.util.HashMap;
import javafx.scene.media.AudioClip;

/**
* @Author Nicolas
* @Date Aug 6, 2015
* @Time 5:01:09 PM
*/
public class Audio {
  final private HashMap<String, AudioClip> audioList = new HashMap<>();
  Resources resources = new Resources();
  
  public HashMap getAudioList() { return this.audioList; }
  public boolean stopAudio(String audio){
    if(audioList.containsKey(audio)){
      audioList.get(audio).stop();
      return true;
    }else{
      return false;
    }
  }
  public boolean addAudio(String audio){
    File audioFile = new File(resources.getResource("audio/"+audio).getPath());
    if(audioFile.exists()){
      this.audioList.put(audio, new AudioClip(resources.getResource("audio/"+audio).toString()));
      return true;
    }else{
      return false;
    }
  }
}
