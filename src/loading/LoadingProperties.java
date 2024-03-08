package loading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
public  class LoadingProperties {
   public static final Properties properties = new Properties();
   public static void loadingProperty(){
       try(BufferedReader bufferedReader =
                   new BufferedReader(
                           new FileReader("src/config.properties")
                   );
       )
       {
           properties.load(bufferedReader);
           System.out.println("Connection is sucessfully established!");
       }catch (Exception exception){
           System.out.println(exception.getMessage());
       }
   }
}
