
package tk.brytnah.cvn.scenes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import tk.brytnah.cvn.Main;

/**
* @Author Nicolas
* @Date Aug 6, 2015
* @Time 4:57:50 PM
*/
public class OptionsMenu implements GameScene{
  final private Scene scene;
  final private String sceneName = "OptionsMenu";
  public OptionsMenu(){
    BorderPane group = new BorderPane();
    scene = new Scene(group, Main.windowSize[0], Main.windowSize[1]);
    
    
  }
  
  @Override
  public Scene getScene(){
    return this.scene;
  }
  @Override
  public String getName() {
    return this.sceneName;
  }
  @Override
  public void startAudio() {
    
  }
}
