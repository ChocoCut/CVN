
package tk.brytnah.cvn.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import tk.brytnah.cvn.Main;

/**
* @Author Nicolas
* @Date Aug 6, 2015
* @Time 4:54:26 PM
*/
public class MainMenu implements GameScene {
  final private Scene scene;
  final private String sceneName = "MainMenu";
  private MediaPlayer media;
  
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
  }
  @Override
  public Scene getScene(){
    return this.scene;
  }
  @Override
  public String getName(){
    return this.sceneName;
  }
  @Override
  public final void startAudio(){
    media = Main.audio.getMedia("Overcast.mp3");
    media.setVolume(0.3);
    media.setStopTime(new Duration(209897));
    media.play();
    media.setOnEndOfMedia(() -> {
      media.seek(new Duration(2040));
      media.play();
    });
  }
}