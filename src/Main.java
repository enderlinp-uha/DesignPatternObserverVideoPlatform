public class Main {
    public static void main(String[] args) {
        VideoPlatform systemNotification = new VideoPlatform();
        User alice = new User("Alice");
        User bob   = new User("Bob");

        systemNotification.addObserver("nouvelle vidéo ajoutée", alice);
        systemNotification.addObserver("changement dans la vidéo", bob);
        systemNotification.addObserver("notification générale", bob);

        systemNotification.addVideo(
                "v1",
                "Charlie et la chocolaterie",
                "C'est l'histoire de 5 gamins qui se font kidnapper par un artisan chocolatier"
        );
        System.out.println(alice.getNotification());

        systemNotification.sendGeneralNotification("Promotion spéciale : Abonnez-vous maintenant !");
        System.out.println(bob.getNotification());
    }
}