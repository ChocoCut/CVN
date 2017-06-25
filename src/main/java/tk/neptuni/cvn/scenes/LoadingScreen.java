package tk.neptuni.cvn.scenes;

import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import tk.neptuni.cvn.Main;
import tk.neptuni.cvn.utility.Audio;
import tk.neptuni.cvn.utility.Scenes;

/**
 *
 * @author Nick
 */
public class LoadingScreen {
  final private Scene scene;
  final private VBox vb;
  final private Thread loadingThread;
  
  public LoadingScreen(){
    BorderPane group = new BorderPane();
    this.scene = new Scene(group, Main.windowSize[0], Main.windowSize[1]);
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
    this.loadingThread.start();
  }
  
  public Scene getScene(){
    return this.scene;
  }
  
  Task<Void> loadingTask = new Task<Void>() {
    Object[] resources = {
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
      new MainMenu(),
      new OptionsMenu()
    };
    @Override
    protected Void call() throws Exception {
      Audio audio = Main.audio;
      Scenes scenes = Main.scenes;
      int progress = 0;
      int maxprogress = resources.length;
      for(Object resource : resources){
        if(resource instanceof String){
          String[] nameParts = ((String)resource).split("\\.");
          if(nameParts[1].equals("mp3")){
            updateMessage("Loading "+resource+"...");
            audio.addMedia((String)resource);
            updateMessage("Loading "+resource+".");
            updateProgress(progress++,maxprogress);
          }
        }
        if(resource instanceof GameScene){
          updateMessage("Loading a scene...");
          scenes.addScene(((GameScene)resource).getName(), ((GameScene)resource));
          updateMessage("Loading scene.");
          updateProgress(progress++,maxprogress);
        }
      }
      return null;
    }
    @Override
    protected void succeeded(){
       super.succeeded();
       vb.getChildren().add(new Label("Done"));
       Main.pStage.setScene((Scene) Main.scenes.getScene("MainMenu"));
       ((GameScene) Main.scenes.getGameScenes().get("MainMenu")).startAudio();
       Main.setCSS("Main.css");
    }
    @Override
    protected void failed(){
      super.failed();
      Main.applicationFailed("Failed");
    }
  };
}
