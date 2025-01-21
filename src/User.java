public class User implements IObserver {
    public String message;
    public String name;

    public User(String name) {
        this.name = name;
    }

    public String getNotification() {
        return this.message;
    }

    @Override
    public void update(String eventType, Object data) {
        this.message = this.name + " a reçu une " + eventType + ": - " + data;
        System.out.println(this.message);
    }
}
