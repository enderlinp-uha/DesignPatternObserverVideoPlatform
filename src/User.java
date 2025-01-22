import java.util.List;
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
            List<String> video = (List<String>) data;
            if (eventType.equals("nouvelle vidéo")) {
                this.message += "notification : Nouvelle vidéo ajoutée - [ID: " + video.get(0) + ", Titre: \"" + video.get(1) + "\"]";
            } else {
                this.message += "notification : Changement dans la vidéo [ID: " + video.get(0) + "] - Nouveau titre: \"" + video.get(1) + "\"";
            }
        }
        System.out.println(this.message);
    }
}
