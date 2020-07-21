import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class DirectoryListener extends FileAlterationListenerAdaptor{

    private String url;

    public DirectoryListener(String url) {
        this.url = url;
    }

    public void onDirectoryCreate(File file) {
        sendData(file);
    }

    public void onDirectoryChange(File file) {
        sendData(file);
    }

    public void onDirectoryDelete(File file) {
        sendData(file);
    }

    public void onFileCreate(File file) {
        sendData(file);
    }

    public void onFileChange(File file) {
        sendData(file);
    }

    public void onFileDelete(File file) {
        sendData(file);
    }

    private void sendData(File file) {
        if(file != null && file.exists()) {

            try {
                MonitorData data = new MonitorData("localhost:8080", file.isDirectory(), "CREATE",
                        file.getPath(), new Date());
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                        new ObjectMapper().writeValueAsString(data));
                Request request = new Request.Builder().url(url).post(requestBody).build();
                Call call = new OkHttpClient().newCall(request);
                Response response = call.execute();
                System.out.println(response.toString());
                System.out.println(response.body().toString());

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

}
