import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoPlatform implements ISubject {
    public Map<String, List<IObserver>> observersList = new HashMap<>();
    public Map<String, List<String>> videos = new HashMap<>();
    public String message;

    public VideoPlatform() {
        observersList = new HashMap<String, List<IObserver>>();
    }

    public void addObserver(String eventType, IObserver observer) {
        if (observersList.containsKey(eventType)) {
            observersList.get(eventType).add(observer);
        } else {
            List<IObserver> observers = new ArrayList<>();
            observers.add(observer);
            observersList.put(eventType, observers);
        }
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
        videos.put(videoId, new ArrayList<>());
        videos.get(videoId).add(title);
        videos.get(videoId).add(description);
        List<String> data = List.of(videoId, title, description);
        this.notifyObservers("nouvelle vidéo", data);
    }

    public void updateVideo(String videoId, String newTitle, String newDescription) {
        List<String> video = videos.get(videoId);
        if (video != null) {
            video.set(0, newTitle);
            video.set(1, newDescription);
            List<String> data = List.of(videoId, newTitle, newDescription);
            this.notifyObservers("modification", data);
        }
    }

    public void sendGeneralNotification(String message) {
        this.message = message;
        this.notifyObservers("notification générale", this.message);
    }
}
