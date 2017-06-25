package tk.neptuni.cvn.utility;

import java.io.File;
import java.util.HashMap;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Nick
 */
public class Audio {  
  /**
   * Even though it works it's not
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
  public HashMap getAudioList(){
    return this.audioList;
  }
  
  @Deprecated
  public boolean stopAudio(String audio){
    if(audioList.containsKey(audio)){
      audioList.get(audio).stop();
      return true;
    }
    return false;
  }
  @Deprecated
  public boolean addAudio(String audio){
    File audioFile = new File(Resources.getRSource("audio/" + audio).getPath());
    if(audioFile.exists()){
      this.audioList.put(audio, new AudioClip(Resources.getRSource("audio/" + audio).toString()));
      return true;
    }
    return false;
  }
  
  /**
   * New Audio System
   * Uses MediaPlayer to allow seeking
   * of certain times in audio file and
   * loop the audio file.
   * 
   * @author Nick
   */
  
  final private HashMap<String, MediaPlayer> mediaList = new HashMap<>();
  
  public MediaPlayer getMedia(String media){
    if(mediaList.containsKey(media)){
      return mediaList.get(media);
    }
    return null;
  }
  
  public boolean stopMedia(String media){
    if(mediaList.containsKey(media)){
      mediaList.get(media).stop();
      return true;
    }
    return false;
  }
  
  public boolean addMedia(String media){
    File mediaFile = new File(Resources.getRSource("audio/" + media).getPath());
    if(mediaFile.exists()){
      this.mediaList.put(media, new MediaPlayer(new Media(Resources.getRSource("audio/" + media).toExternalForm())));
      return true;
    }
    System.out.println("Media file " + media + " does not exist.");
    return false;
  }
}
