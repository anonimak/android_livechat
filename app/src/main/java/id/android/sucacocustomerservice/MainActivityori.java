package id.android.sucacocustomerservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import id.android.sucacocustomerservice.adapter.VisitorAdapter;
import id.android.sucacocustomerservice.application.RatKiller;
import id.android.sucacocustomerservice.model.VisitorModel;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivityori extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VisitorAdapter adapter;
    private ArrayList<VisitorModel> visitorModelArrayList;
    private Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainori);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.rcv_visitor);

        adapter = new VisitorAdapter(visitorModelArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivityori.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);


//        socket.io
        RatKiller app = (RatKiller) getApplication();
        mSocket = app.getSocket();
        mSocket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                mSocket.emit("foo", "hi");
                mSocket.disconnect();
            }

        }).on("Typing", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject)args[0];
                Log.e("Typing", data.toString());
                //here the data is in JSON Format
                //Toast.makeText(MainActivity.this, data.toString(), Toast.LENGTH_SHORT).show();

            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {}

        });
        mSocket.connect();

        if (mSocket.connected()){
            Toast.makeText(MainActivityori.this, "Connected !!",Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(MainActivityori.this, "not !!",Toast.LENGTH_SHORT).show();
        }
    }

    void addData(){
        visitorModelArrayList = new ArrayList<>();
        visitorModelArrayList.add(new VisitorModel("Dimas Maulana"));
    }

}
