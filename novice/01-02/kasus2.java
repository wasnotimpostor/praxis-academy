import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import jdk.internal.org.objectweb.asm.ClassReader;

import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.sun.tools.javac.Main;

public class kasus2 {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        ClassLoader classLoader = Main.class.getClassLoader();

        try {
            Object object = jsonParser.parse(new FileReader(new File(classLoader.getResource("kasus2.json").getFile())));
            JSONObject jsonObjectRoot = (JSONObject) object;

            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
