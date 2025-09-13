package org.example.subject;

import org.example.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject{
    private final String name;
    private final List<Observer> subscribers = new ArrayList<>();


    public Channel(String name) {
        this.name = name;
    }

    public void uploadVideo(String title){
        // TODO: Notify all subscribers about new video
        String message = name+"uploaded a new video"+title;
        this.notifyObservers(message);
    }

    @Override
    public void subscribe(Observer observer) {
        // TODO: Add subscriber
        if(observer == null || subscribers.contains(observer)){
            return;

        }else {
            subscribers.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        // TODO: Remove subscriber
        if (subscribers.contains(observer)){
            subscribers.remove(observer);
        }else{
            return;
        }
    }

    @Override
    public void notifyObservers(String message) {
        // TODO: Notify subscribers
        for(Observer sub : subscribers){
            sub.update(message);
        }
    }

    public String getName() {
        return name;
    }
}
