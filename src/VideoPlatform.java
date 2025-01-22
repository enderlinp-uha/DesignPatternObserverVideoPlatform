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
        if (EEvents.labelExists(eventType)) {
            if (observersList.containsKey(eventType)) {
                observersList.get(eventType).add(observer);
            } else {
                List<IObserver> observers = new ArrayList<>();
                observers.add(observer);
                observersList.put(eventType, observers);
            }
        } else {
            System.out.println("Ce type d'évènement n'existe pas : " + eventType);
        }
    }

    public void removeObserver(String eventType, IObserver observer) {
        if (EEvents.labelExists(eventType)) {
            for (Map.Entry<String, List<IObserver>> entry : observersList.entrySet()) {
                if (entry.getKey().equals(eventType)) {
                    entry.getValue().remove(observer);
                }
            }
        } else {
            System.out.println("Ce type d'évènement n'existe pas : " + eventType);
        }
    }

    public void notifyObservers(String eventType, Object data) {
        if (observersList.containsKey(eventType)) {
            for (IObserver observer : observersList.get(eventType)) {
                observer.update(eventType, data);
            }
        } else {
            System.out.println("Aucun observateur trouvé pour ce type d'évènement : " + eventType);
        }
    }

    public void addVideo(String videoId, String title, String description) {
        if (!videos.containsKey(videoId)) {
            videos.put(videoId, new ArrayList<>());
            videos.get(videoId).add(title);
            videos.get(videoId).add(description);
            List<String> data = List.of(videoId, title, description);
            this.notifyObservers(EEvents.INSERT.getLabel(), data);
        } else {
            System.out.println("Cette vidéo existe déjà : " + videoId);
        }
    }

    public void updateVideo(String videoId, String newTitle, String newDescription) {
         if (videos.containsKey(videoId)) {
            List<String> video = videos.get(videoId);
            video.set(0, newTitle);
            video.set(1, newDescription);
            List<String> data = List.of(videoId, newTitle, newDescription);
            this.notifyObservers(EEvents.UPDATE.getLabel(), data);
        } else {
             System.out.println("Cette video n'existe pas : " + videoId);
         }
    }

    public void sendGeneralNotification(String message) {
        this.message = message;
        this.notifyObservers(EEvents.NOTIFICATION.getLabel(), this.message);
    }
}
