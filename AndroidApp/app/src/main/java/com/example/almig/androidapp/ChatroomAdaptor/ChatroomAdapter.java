package com.example.almig.androidapp.ChatroomAdaptor;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.almig.androidapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by almig on 2017-02-03.
 */

public class ChatroomAdapter extends ArrayAdapter {
    private List<ChatroomItem> msgs = new ArrayList();

    public ChatroomAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    //@Override
    public void add(Object object) {
        msgs.add((ChatroomItem) object);
        super.add(object);
    }



    @Override
    public int getCount() {
        return msgs.size();
    }

    @Override
    public ChatroomItem getItem(int index) {
        return msgs.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            // inflator를 생성하여, chatting_message.xml을 읽어서 View객체로 생성한다.
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.chatroom_item, parent, false);
        }

        // Array List에 들어 있는 채팅 문자열을 읽어
        ChatroomItem msg = msgs.get(position);

        // Inflater를 이용해서 생성한 View에, ChatMessage를 삽입한다.
        TextView msgText = (TextView) row.findViewById(R.id.TextView_ChatMessage);
        msgText.setText(msg.getMsg());
        msgText.setTextColor(Color.parseColor("#000000"));

        return row;
    }
}
