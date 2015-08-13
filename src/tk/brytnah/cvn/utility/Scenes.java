
package tk.brytnah.cvn.utility;

import java.util.HashMap;
import javafx.scene.Scene;

/**
* @Author Nicolas
* @Date Aug 6, 2015
* @Time 5:17:50 PM
*/
public class Scenes {
  final private HashMap<String, Scene> scenes = new HashMap<>();
  
  public HashMap getScenes(){ return this.scenes;  }
  public void addScene(String sceneName, Scene scene){
    this.scenes.put(sceneName, scene);
  }
}
