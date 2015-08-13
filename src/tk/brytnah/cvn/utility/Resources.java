
package tk.brytnah.cvn.utility;

import java.net.URL;
import tk.brytnah.cvn.Main;

/**
* @Author Nicolas
* @Date Aug 6, 2015
* @Time 5:07:34 PM
*/
public class Resources {
  /**
   * Returns the URL of the specified
   * resource's path.
   * 
   * @author Nick
   * @param path
   * @return URL
   */
  public URL getResource(String path){
    return Main.class.getResource(path);
  }
}
