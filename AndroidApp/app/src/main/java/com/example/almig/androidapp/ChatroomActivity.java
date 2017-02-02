package com.example.almig.androidapp;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.almig.androidapp.ChatroomAdaptor.ChatroomAdapter;

public class ChatroomActivity extends AppCompatActivity {
    private ChatroomAdapter chatroomAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        chatroomAdaptor = new ChatroomAdapter(this.getApplicationContext(),R.layout.chatroom_item);
        final ListView listView = (ListView)findViewById(R.id.ListView_chatroom);
        listView.setAdapter(chatroomAdaptor);
        listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL); // 이게 필수

        // When message is added, it makes listview to scroll last message
        chatroomAdaptor.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chatroomAdaptor.getCount()-1);
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void send(View view){
        EditText etMsg = (EditText)findViewById(R.id.EditText_ChatMsg);
        String strMsg = (String)etMsg.getText().toString();
    }
}
