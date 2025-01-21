public interface ISubject {
    public void addObserver(String eventType, IObserver observer);
    public void removeObserver(String eventType, IObserver observer);
    public void notifyObservers(String eventType, Object data);
}
