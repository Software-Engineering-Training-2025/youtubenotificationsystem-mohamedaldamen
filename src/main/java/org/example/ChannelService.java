package org.example;

import org.example.observer.Observer;
import org.example.subject.Channel;
import org.example.subject.Subject;

import java.nio.channels.Channels;
import java.util.HashMap;
import java.util.Map;

public class ChannelService {
    private final Map<String, Channel> channels = new HashMap<>();

    public boolean createNewChannel(String channel) {
        // TODO: implement
        if(channel == null || channels.containsKey(channel)){
            return false;
        }
        else{channels.put(channel,new Channel(channel));
        return true;
        }


    }
    public boolean deleteChannel(String name){
        if (channels.containsKey(name)){
            channels.remove(name);
            return true;
        }else {
            return false;
        }
    }

    public boolean subscribeToChannel(String channel, Observer observer) {
        // TODO: implement
        if(channels.containsKey(channel)){
            channels.get(channel).subscribe(observer);
            return true;
        }else{
            return false;
        }
    }
    public boolean unsubscribe(String channelName, Observer user){
        if(channels.containsKey(channelName)){
            channels.get(channelName).unsubscribe(user);
            return true;
    }
        else{
            return false;
        }
    }
    public boolean upload(String channelName, String videoTitle){

            channels.get(channelName).uploadVideo(videoTitle);
            return true;
        }


}
