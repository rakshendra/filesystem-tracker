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
            configuration = mapper.readValue(new File(Thread.currentThread().getContextClassLoader().getResource("config.yaml").getFile()), Configuration.class);
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
