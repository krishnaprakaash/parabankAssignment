package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertyFileMethods {


 
    static Properties properties;
    
public String readProp(String key){
        properties = new Properties();
        File file = new File("prop.properties");
        FileReader fileReader;
		try {
			fileReader = new FileReader(file);
	        properties.load(fileReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return properties.getProperty(key);
    }

 	
}
