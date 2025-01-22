import java.util.Map;

public class User implements IObserver {
    public String message;
    public String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String eventType, Object data) {
        this.message = this.name + " a reçu une ";
        if (eventType.equals("notification générale")) {
            this.message += eventType + " : " + '"' + data + '"';
        } else {
            Map<String, String> dataMap = (Map<String, String>) data;
            if (eventType.equals("Nouvelle vidéo ajoutée")) {
                this.message += "notification : " + eventType + " - [ID: " + dataMap.get("videoId") + ", Titre: " + dataMap.get("title") + "]";
            } else {
                //
            }
        }
        System.out.println(this.message);
    }
}
