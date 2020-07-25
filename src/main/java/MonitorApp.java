import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.io.IOException;

public class MonitorApp {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Configuration configuration = null;
        try {
            String pathname = System.getProperty("java.io.tmpdir") + "/appconfig/monitor-config.yaml";
            File configFile = new File(pathname);
            if(configFile.exists()) {
                configuration = mapper.readValue(configFile, Configuration.class);
            }else{
                throw new IOException("Config File cannot be found at: " + pathname);
            }
            FileAlterationMonitor monitor = new FileAlterationMonitor(configuration.getPollingTimeInterval());
            FileAlterationObserver observer = new FileAlterationObserver(configuration.getDirectoryPath());
            observer.addListener(new DirectoryListener(configuration.getDestinationURL()));
            monitor.addObserver(observer);
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
