import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

public class DirectoryListener extends FileAlterationListenerAdaptor{

    private final String destinationURL;

    public DirectoryListener(String destinationURL) {
        this.destinationURL = destinationURL;
    }

    public void onDirectoryCreate(File file) {
        sendData(file,FileEvent.CREATE.name());
    }

    public void onDirectoryChange(File file) {
        sendData(file, FileEvent.MODIFY.name());
    }

    public void onDirectoryDelete(File file) {
        sendData(file, FileEvent.DELETE.name());
    }

    public void onFileCreate(File file) {
        sendData(file,FileEvent.CREATE.name());
    }

    public void onFileChange(File file) {
        sendData(file, FileEvent.MODIFY.name());
    }

    public void onFileDelete(File file) {
        sendData(file, FileEvent.DELETE.name());
    }

    private void sendData(File file, String eventType) {
        if(file != null) {
            try {
                MonitorData data = new MonitorData(InetAddress.getLocalHost().getHostName(), file.isDirectory(),
                        eventType, file.getPath(), new Date());
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                        new ObjectMapper().writeValueAsString(data));
                Request request = new Request.Builder().url(destinationURL).post(requestBody).build();
                Call call = new OkHttpClient().newCall(request);
                Response response = call.execute();
                System.out.println(response.toString());
                System.out.println(response.body().toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
