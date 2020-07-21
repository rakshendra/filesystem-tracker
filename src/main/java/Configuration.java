public class Configuration {
    private String destinationURL;
    private long pollingTimeInterval;
    private String directoryPath;

    public Configuration() {
    }

    public Configuration(String destinationURL, long pollingTimeInterval, String directoryPath) {
        this.destinationURL = destinationURL;
        this.pollingTimeInterval = pollingTimeInterval;
        this.directoryPath = directoryPath;
    }

    public String getDestinationURL() {
        return destinationURL;
    }

    public void setDestinationURL(String destinationURL) {
        this.destinationURL = destinationURL;
    }

    public long getPollingTimeInterval() {
        return pollingTimeInterval;
    }

    public void setPollingTimeInterval(long pollingTimeInterval) {
        this.pollingTimeInterval = pollingTimeInterval;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "destinationURL='" + destinationURL + '\'' +
                ", pollingTimeInterval=" + pollingTimeInterval +
                ", directoryPath='" + directoryPath + '\'' +
                '}';
    }
}
