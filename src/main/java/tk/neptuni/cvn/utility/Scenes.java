package tk.neptuni.cvn.utility;

import java.util.HashMap;
import javafx.scene.Scene;
import tk.neptuni.cvn.scenes.GameScene;

/**
 *
 * @author Nick
 */
public class Scenes {
  /**
   * Even though it works, it stores
   * the basic scene node which doesn't
   * allow much control.
   * 
   * @deprecated
   * @author Nick
   */
  @Deprecated
  final private HashMap<String, Scene> _scenes = new HashMap<>();
  
  @Deprecated
  public HashMap getScenes(){
    return this._scenes;
  }
  
  @Deprecated
  public void addScene(String sceneName, Scene scene){
    this._scenes.put(sceneName, scene);
  }
  
  /**
   * New Scene storage using the
   * new GameScene interface allowing
   * more control over the actual scene.
   * 
   * @author Nick
   */
  final private HashMap<String, GameScene> scenes = new HashMap<>();
  
  public HashMap getGameScenes(){
    return this.scenes;
  }
  
  public void addScene(String sceneName, GameScene gameScene){
    this.scenes.put(sceneName, gameScene);
  }
  
  public Scene getScene(String sceneName){
    if(this.scenes.containsKey(sceneName)){
      return this.scenes.get(sceneName).getScene();
    }
    return null;
  }
  
}
