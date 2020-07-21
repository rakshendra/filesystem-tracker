import java.util.Date;

public class MonitorData {
    private String ip;
    private boolean isDirectory;
    private String eventType;
    private String filePath;
    private Date eventTimeStamp;

    public MonitorData() {
    }

    public MonitorData(String ip, boolean isDirectory, String eventType, String filePath, Date eventTimeStamp) {
        this.ip = ip;
        this.isDirectory = isDirectory;
        this.eventType = eventType;
        this.filePath = filePath;
        this.eventTimeStamp = eventTimeStamp;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getEventTimeStamp() {
        return eventTimeStamp;
    }

    public void setEventTimeStamp(Date eventTimeStamp) {
        this.eventTimeStamp = eventTimeStamp;
    }
}
