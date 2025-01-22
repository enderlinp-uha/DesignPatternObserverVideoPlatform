public enum EEvents {
    INSERT("nouvelle vidéo"),
    UPDATE("modification"),
    NOTIFICATION("notification générale");

    final private String label;

    EEvents(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static boolean labelExists(String label) {
        for (EEvents event : EEvents.values()) {
            if (event.getLabel().equals(label)) {
                return true;
            }
        }
        return false;
    }
}
