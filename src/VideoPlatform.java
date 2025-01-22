import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoPlatform implements ISubject {
    public Map<String, List<IObserver>> observersList;
    public List<IObserver> observers;
    public String message;

    public VideoPlatform() {
        observersList = new HashMap<String, List<IObserver>>();
        observers = new ArrayList<>();
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
        Map<String, String> data = Map.of("videoId", videoId, "title", title, "description", description);
        this.notifyObservers("Nouvelle vidéo ajoutée", data);
    }

    public void updateVideo(String videoId, String newTitle, String newDescription) {

    }

    public void sendGeneralNotification(String message) {
        this.message = message;
        this.notifyObservers("notification générale", this.message);
    }
}
