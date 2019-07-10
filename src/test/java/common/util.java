package common;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.URL;

public class util {
    public static String getStringValues(File filePath) throws IOException {
        InputStreamReader in = new InputStreamReader(new FileInputStream(filePath), "UTF-8");

        BufferedReader br = new BufferedReader(in);
        StringBuffer buffer = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }

    public static String getStringValue(String filePath) throws IOException {
        URL fileUrl = util.class.getResource(filePath);
        File file = new File(fileUrl.getFile());
        return file.isFile() ? getStringValues(file) : null;
    }

    public static JSONObject getObject(String filePath) throws IOException {
//        return JSON.parseObject(getStringValue(filePath), clazz);
        JSONObject obj = new JSONObject().fromObject(getStringValue(filePath));
        return obj;
    }
}
