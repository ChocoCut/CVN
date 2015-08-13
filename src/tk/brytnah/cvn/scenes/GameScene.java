
package tk.brytnah.cvn.scenes;

import javafx.scene.Scene;

/**
* @Author Nicolas
* @Date Aug 13, 2015
* @Time Aug 13, 2015 12:15:42 PM
*/
public interface GameScene {
  String getName();
  Scene getScene();
  void startAudio();
}
