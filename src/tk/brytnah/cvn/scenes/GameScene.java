
package tk.brytnah.cvn.scenes;

import javafx.scene.Scene;

/**
* @Author Nicolas
* @Date Aug 13, 2015
* @Time Aug 13, 2015 12:15:42 PM
*/
public interface GameScene {
  /**
   * Returns the Scene node.
   * 
   * @author Nick
   * @return Scene
   */
  String getName();
  /**
   * Returns the name of the Scene.
   * 
   * @author Nick
   * @return String
   */
  Scene getScene();
  /**
   * Starts the audio of the scene.
   * 
   * @author Nick
   */
  void startAudio();
}
