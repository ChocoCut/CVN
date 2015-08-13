
package tk.brytnah.cvn.scenes;

import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import tk.brytnah.cvn.Main;
import tk.brytnah.cvn.utility.Audio;
import tk.brytnah.cvn.utility.Resources;
import tk.brytnah.cvn.utility.Scenes;

/**
* @Author Nicolas
* @Date Aug 6, 2015
* @Time 4:56:17 PM
*/
public class LoadingScreen {
  final private Scene scene;
  final private VBox vb;
  final private Thread loadingThread;
  
  public LoadingScreen(){
    BorderPane group = new BorderPane();
    scene = new Scene(group, Main.windowSize[0], Main.windowSize[1]);
    ProgressBar pb = new ProgressBar();
    Label progressLabel = new Label();
    vb = new VBox();
    
    group.getStyleClass().add("LoadingBackGround720p");
    progressLabel.textProperty().bind(loadingTask.messageProperty());
    pb.progressProperty().bind(loadingTask.progressProperty());
    pb.setMinWidth(600);
    pb.setMinHeight(40);
    vb.getChildren().add(progressLabel);
    vb.getChildren().add(pb);
    vb.setAlignment(Pos.CENTER);
    group.setCenter(vb);
    
    loadingThread = new Thread(loadingTask);
    loadingThread.setDaemon(true);
    startLoadingThread();
  }
  
  private void startLoadingThread(){
    loadingThread.start();
  }
  
  public Scene getScene(){  return this.scene;  }
  
  Task<Void> loadingTask = new Task<Void>() {
    String[] resources = {
      "AirportLounge.mp3",
      "BassWalker.mp3",
      "Carefree.mp3",
      "Corncob.mp3",
      "DiscoMedusae.mp3",
      "FastTalkin.mp3",
      "GrooveGrove.mp3",
      "KoolKats.mp3",
      "LocalForecast.mp3",
      "MartyGotsAPlan.mp3",
      "MiningbyMoonlight.mp3",
      "Odyssey.mp3",
      "OfftoOsaka.mp3",
      "Ouroboros.mp3",
      "Overcast.mp3",
      "TheBuilder.mp3",
      "TwoFingerJohnny.mp3",
      "MainMenu.scene"
    };
    @Override
    protected Void call() throws Exception {
      Audio audio = Main.audio;
      Scenes scenes = Main.scenes;
      int progress = 0;
      int maxprogress = resources.length;
      for(String resource : resources){
        String[] nameParts = resource.split("\\.");
        if(nameParts[1].equals("mp3")){
          updateMessage("Loading "+resource+"...");
          audio.addAudio(resource);
          updateMessage("Loaded "+resource);
          progress++;
          updateProgress(progress,maxprogress);
        }
        if(nameParts[1].equals("scene")){
          System.out.println(nameParts[0]);
          updateMessage("Loading a Scene "+nameParts[0]+"...");
          scenes.addScene(nameParts[0], new MainMenu().getScene());
          progress++;
          updateProgress(progress,maxprogress);
        }
      }
      return null;
    }
    @Override
    protected void succeeded(){
       super.succeeded();
       vb.getChildren().add(new Label("Done"));
       Main.pStage.setScene((Scene) Main.scenes.getScenes().get("MainMenu"));
       Main.setCSS(new Resources().getResource("css/Main.css"));
    }
    @Override
    protected void failed(){
      super.failed();
      Main.applicationFailed();
    }
  };
}
