
package tk.brytnah.cvn.scenes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import tk.brytnah.cvn.Main;

/**
* @Author Nicolas
* @Date Aug 6, 2015
* @Time 4:57:50 PM
*/
public class OptionsMenu {
  final private Scene scene;
  public OptionsMenu(){
    BorderPane group = new BorderPane();
    scene = new Scene(group, Main.windowSize[0], Main.windowSize[1]);
    
    
  }
  
  public Scene getScene(){
    return this.scene;
  }
}
