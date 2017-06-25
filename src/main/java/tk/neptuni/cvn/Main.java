package tk.neptuni.cvn;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tk.neptuni.cvn.scenes.LoadingScreen;
import tk.neptuni.cvn.utility.Audio;
import tk.neptuni.cvn.utility.Resources;
import tk.neptuni.cvn.utility.Scenes;

/**
 *
 * @author Nick
 */
public class Main extends Application {
  public static int[] windowSize = {1280,720};
  public static Audio audio;
  public static Scenes scenes;
  public static Stage pStage;
  
  @Override
  public void start(Stage primaryStage){
    pStage = primaryStage;
    
    primaryStage.setWidth(windowSize[0]);
    primaryStage.setHeight(windowSize[1]);
    primaryStage.setResizable(false);
    
    primaryStage.setScene(new LoadingScreen().getScene());
    primaryStage.getScene().getStylesheets().add(Resources.getRSource("css/Main.css").toExternalForm());
    primaryStage.show();
  }
  public static void main(String[] args) {
    audio = new Audio();
    scenes = new Scenes();
    launch(args);
  }
  public static void setCSS(String cssFile){
    pStage.getScene().getStylesheets().add(Resources.getRSource("css/"+cssFile).toExternalForm());
  }
  public static void applicationFailed(String error){
    Main.pStage.setScene(new Scene(new GridPane()));
    Stage errorStage = new Stage();
    errorStage.setWidth(200);
    errorStage.setHeight(150);
    HBox errorBox = new HBox(new Label("Application Failed." + error));
    errorBox.setAlignment(Pos.CENTER);
    errorStage.setScene(new Scene(errorBox, 1000, 500));
    errorStage.setOnCloseRequest((WindowEvent we) -> {
      errorStage.close();
      Main.pStage.close();
    });
    errorStage.show();
  }
}
