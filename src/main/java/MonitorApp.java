import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class MonitorApp {
    public static void main(String[] args) {
        String path = "/home/rakshendra/Downloads";
        Configuration configuration = new Configuration("http://localhost:8080/data/add", 10000, path);

        FileAlterationMonitor monitor = new FileAlterationMonitor(configuration.getPollingTimeInterval());
        FileAlterationObserver observer = new FileAlterationObserver(configuration.getDirectoryPath());
        observer.addListener(new DirectoryListener(configuration.getDestinationURL()));
        monitor.addObserver(observer);
        try {
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
