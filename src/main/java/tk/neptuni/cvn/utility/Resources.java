package tk.neptuni.cvn.utility;

import java.net.URL;
import tk.neptuni.cvn.Main;

/**
 *
 * @author Nick
 */
public class Resources {
  
  @Deprecated
  public static URL getResource(String path){
    return Main.class.getResource(path);
  }
  
  public static URL getRSource(String path){
    return Main.class.getClassLoader().getResource(path);
  }
}
