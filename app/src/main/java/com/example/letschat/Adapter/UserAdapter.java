package com.example.letschat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.letschat.MessageActivity;
import com.example.letschat.Model.User;
import com.example.letschat.R;

import java.security.MessageDigest;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context context;
    private boolean isChat;
    private List<User> musers;

    public UserAdapter(Context context, List<User> musers,boolean isChat) {
        this.context = context;
        this.musers = musers;
        this.isChat=isChat;
}
    public class MyViewHolder extends RecyclerView.ViewHolder{


        public TextView username;
        public CircleImageView profile;
        private ImageView img_on,img_off;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            username=itemView.findViewById(R.id.id_name_user);
            profile=itemView.findViewById(R.id.id_profile_user);
            img_on=itemView.findViewById(R.id.img_on);
            img_off=itemView.findViewById(R.id.img_off);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.user_item,viewGroup,false);
        return new UserAdapter.MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        final User user=musers.get(i);
        holder.username.setText(user.getUsername());
        if(user.getImageurl().equals("default")){
            holder.profile.setImageResource(R.mipmap.ic_launcher);
        }
        else{
            Glide.with(context).load(user.getImageurl()).into(holder.profile);
        }
        if(isChat){
            if(user.getStatus().equals("online")){
                holder.img_on.setVisibility(View.VISIBLE);
                holder.img_off.setVisibility(View.GONE);
            }
            else{
                holder.img_on.setVisibility(View.GONE);
                holder.img_off.setVisibility(View.VISIBLE);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(context, MessageActivity.class);
                in.putExtra("userid",user.getId());
                context.startActivity(in);
            }
        });

    }

    @Override
    public int getItemCount() {
        return musers.size();
    }



}
