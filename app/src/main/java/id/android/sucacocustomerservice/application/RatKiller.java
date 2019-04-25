package id.android.sucacocustomerservice.application;

import android.app.Application;
import java.net.URISyntaxException;


import id.android.sucacocustomerservice.config.ClientSettings;
import io.socket.client.IO;
import io.socket.client.Socket;

public class RatKiller extends Application {
    private Socket mSocket;
    {
        try {
            mSocket = IO.socket(ClientSettings.CHAT_ADDRESS);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public Socket getSocket(){
        return mSocket;
    }
}