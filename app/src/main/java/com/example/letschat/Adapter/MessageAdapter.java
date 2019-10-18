package com.example.letschat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.letschat.MessageActivity;
import com.example.letschat.Model.Chat;
import com.example.letschat.Model.User;
import com.example.letschat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {
    private Context context;
    private List<Chat> mChats;
    private String image_url;
    public static final int msg_left=0;
    public static final int msg_right=1;
    FirebaseUser firebaseUser;

    public MessageAdapter(Context context, List<Chat> mChats,String image_url) {
        this.context = context;
        this.mChats = mChats;
        this.image_url=image_url;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{


        public TextView show_message;
        public CircleImageView profile;
        public TextView isseen;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            show_message=itemView.findViewById(R.id.show_message);
            profile=itemView.findViewById(R.id.profile);
            isseen=itemView.findViewById(R.id.txt_seen);

        }
    }

    @NonNull
    @Override
    public MessageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i==msg_left) {
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_left, viewGroup, false);
            return new MessageAdapter.MyViewHolder(view);
        }
        else{
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_right, viewGroup, false);
            return new MessageAdapter.MyViewHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Chat chat=mChats.get(i);
        myViewHolder.show_message.setText(chat.getMessage());
        if(image_url.equals("default")){
            myViewHolder.profile.setImageResource(R.mipmap.ic_launcher);

        }
        else{
            Glide.with(context).load(image_url).into(myViewHolder.profile);
        }
        if(i==mChats.size()-1){
            if(chat.getIsSeen()){
                myViewHolder.isseen.setVisibility(View.VISIBLE);
                myViewHolder.isseen.setText("Seen");
            }
            else{
                myViewHolder.isseen.setVisibility(View.VISIBLE);
                myViewHolder.isseen.setText("Delievered");
            }
        }else{
            myViewHolder.isseen.setVisibility(View.GONE);
        }


    }


    @Override
    public int getItemCount() {
        return mChats.size();
    }

    @Override
    public int getItemViewType(int position) {
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        if(mChats.get(position).getSender().equals(firebaseUser.getUid())){
            return msg_right;
        }
        else{
            return msg_left;
        }

    }
}
