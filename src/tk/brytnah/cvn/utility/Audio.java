
package tk.brytnah.cvn.utility;

import java.io.File;
import java.util.HashMap;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
* @Author Nicolas
* @Date Aug 6, 2015
* @Time 5:01:09 PM
*/
public class Audio {
  Resources resources = new Resources();
  
  /**
   * Even though it works its not
   * entirely useful as it only
   * plays an audio file and that's
   * about it.
   * 
   * @deprecated
   * 
   * @author Nick
   */
  @Deprecated
  final private HashMap<String, AudioClip> audioList = new HashMap<>();
  @Deprecated
  public HashMap getAudioList() { return this.audioList; }
  @Deprecated
  public boolean stopAudio(String audio){
    if(audioList.containsKey(audio)){
      audioList.get(audio).stop();
      return true;
    }else{
      return false;
    }
  }
  @Deprecated
  public boolean addAudio(String audio){
    File audioFile = new File(resources.getResource("audio/"+audio).getPath());
    if(audioFile.exists()){
      this.audioList.put(audio, new AudioClip(resources.getResource("audio/"+audio).toString()));
      return true;
    }else{
      return false;
    }
  }
  
  /**
   * New Audio System
   * Uses MediaPlayer to allow seeking
   * of certain times in audio file.
   * 
   * @author Nick
   */
  
  final private HashMap<String, MediaPlayer> mediaList = new HashMap<>();
  public MediaPlayer getMedia(String media){
    if(mediaList.containsKey(media)){
      return mediaList.get(media);
    }else{
      return null;
    }
  }
  public boolean stopMedia(String media){
    if(mediaList.containsKey(media)){
      mediaList.get(media).stop();
      return true;
    }else{
      return false;
    }
  }
  public boolean addMedia(String media){
    File mediaFile = new File(resources.getResource("audio/"+media).getPath());
    if(mediaFile.exists()){
      this.mediaList.put(media, new MediaPlayer(new Media(resources.getResource("audio/"+media).toExternalForm())));
      return true;
    }else{
      System.out.println("Media file "+media+" does not exist.");
      return false;
    }
  }
}
