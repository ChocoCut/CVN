package tk.neptuni.cvn.scenes;

import javafx.scene.Scene;

/**
 *
 * @author Nick
 */
public interface GameScene {
  
  /**
   * Returns the scene node.
   * 
   * @author Nick
   * @return Scene
   */
  Scene getScene();
  
  /**
   * Returns the name of the scene.
   * 
   * @author Nick
   * @return String
   */
  String getName();
  
  /**
   * Starts the audio of the scene.
   * 
   * @author Nick
   */
  void startAudio();
}
