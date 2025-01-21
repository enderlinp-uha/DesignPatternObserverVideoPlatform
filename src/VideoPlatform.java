import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoPlatform implements ISubject {
    public Map<String, List<IObserver>> observersList;
    public List<IObserver> observers;
    public List<List<String>> videos;
    public String message;

    public VideoPlatform() {
        observers = new ArrayList<>();
        observersList = new HashMap<String, List<IObserver>>();
        videos = new ArrayList<>();
    }

    public void addObserver(String eventType, IObserver observer) {
        observers.add(observer);
        observersList.put(eventType, observers);
    }

    public void removeObserver(String eventType, IObserver observer) {
        for (Map.Entry<String, List<IObserver>> entry : observersList.entrySet()) {
            if (entry.getKey().equals(eventType)) {
                entry.getValue().remove(observer);
            }
        }
    }

    public void notifyObservers(String eventType, Object data) {
        if (observersList.containsKey(eventType)) {
            for (IObserver observer : observersList.get(eventType)) {
                observer.update(eventType, data);
            }
        }
    }

    public void addVideo(String videoId, String title, String description) {
        List<String> video = new ArrayList<>();
        video.add(videoId);
        video.add(title);
        video.add(description);
        videos.add(video);
    }

    public void updateVideo(String videoId, String newTitle, String newDescription) {

    }

    public void sendGeneralNotification(String message) {
        this.message = message;
        this.notifyObservers("notification générale", this.message);
    }
}
