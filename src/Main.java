public class Main {
    public static void main(String[] args) {
        VideoPlatform systemNotification = new VideoPlatform();
        User alice = new User("Alice");
        User bob   = new User("Bob");

        systemNotification.addObserver("nouvelle vidéo", alice);
        systemNotification.addObserver("modification", bob);
        systemNotification.addObserver("notification générale", bob);
        systemNotification.addVideo(
                "v123",
                "Introduction à Java",
                ""
        );
        systemNotification.updateVideo(
                "v123",
                "Java Avancé",
                ""
        );
        systemNotification.sendGeneralNotification("Promotion spéciale : Abonnez-vous maintenant !");
        systemNotification.removeObserver("notification générale", bob);
    }
}