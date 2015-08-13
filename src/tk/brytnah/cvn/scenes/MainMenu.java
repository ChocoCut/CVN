
package tk.brytnah.cvn.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import tk.brytnah.cvn.Main;

/**
* @Author Nicolas
* @Date Aug 6, 2015
* @Time 4:54:26 PM
*/
public class MainMenu {
  final private Scene scene;
  
  public MainMenu(){
    HBox btnBox;
    BorderPane group;
    
    Button[] buttons = {
      new Button("Play"),
      new Button("Load"),
      new Button("Options"),
      new Button("Quit To Desktop")
    };
    
    group = new BorderPane();
    group.setPadding(new Insets(10,10,100,10));
    scene = new Scene(group, Main.windowSize[0], Main.windowSize[1]);
    group.getStyleClass().add("MainMenuBackground720p");
    
    btnBox = new HBox();
    int[] buttonHW = {250,30};
    for(Button btn : buttons){
      btn.setMinWidth(buttonHW[0]);
      btn.setMinHeight(buttonHW[1]);
      btn.setFont(Font.font("",FontWeight.BOLD, 20));
      btn.getStyleClass().removeAll();
      btn.getStyleClass().add("menuButton");
      btnBox.getChildren().add(btn);
    }
    btnBox.setSpacing(10);
    btnBox.setAlignment(Pos.BOTTOM_CENTER);
    
    group.setCenter(btnBox);
    buttons[3].setOnAction(e -> Main.pStage.close());
    
    AudioClip audio = (AudioClip) Main.audio.getAudioList().get("Overcast.mp3");
    audio.setVolume(0.2);
    audio.play();
  }
  
  public Scene getScene(){
    return this.scene;
  }
}