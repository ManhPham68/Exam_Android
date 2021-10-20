package com.example.phamducmanh;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<UserEntity> listUser;

    public UserAdapter(Activity activity, List<UserEntity> listUser) {
        this.activity = activity;
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.activity_user,parent,false);
        UserViewHolder holder = new UserViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UserViewHolder vh = (UserViewHolder) holder;
        UserEntity model = listUser.get(position);
        vh.tvId.setText(String.valueOf(model.getId()));
        vh.tvName.setText(model.getName());
        vh.tvGripe.setText(model.getGripe());
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }
    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView tvId;
        TextView tvName;
        TextView tvGripe;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.tvId);
            tvName=itemView.findViewById(R.id.tvName);
            tvGripe = itemView.findViewById(R.id.tvGripe);
        }
    }
}
