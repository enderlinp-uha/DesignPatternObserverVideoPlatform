public class Main {
    public static void main(String[] args) {
        VideoPlatform systemNotification = new VideoPlatform();
        User alice = new User("Alice");
        User bob   = new User("Bob");

        systemNotification.addObserver("Nouvelle vidéo ajoutée", alice);
        systemNotification.addObserver("Changement dans la vidéo", bob);
        systemNotification.addObserver("notification générale", bob);

        systemNotification.addVideo(
                "v1",
                "Charlie et la chocolaterie",
                "C'est l'histoire de 5 gamins qui se font kidnapper par un artisan chocolatier"
        );

        systemNotification.sendGeneralNotification("Promotion spéciale : Abonnez-vous maintenant !");
    }
}