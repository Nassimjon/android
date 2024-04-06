package com.example.noteapp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp1.data.User;

import java.util.List;

public class UserAdapter extends  RecyclerView.Adapter<UserAdapter.ViewHolder>{

    Context context;
//    ArrayList<User> users;
    List<User> users;

    public UserAdapter(List<User> users) {
        this.context = context;
        this.users = users;
    }


    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclreview, parent, false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.emailText.setText(users.get(position).getEmail());
        holder.passText.setText(users.get(position).getPassword());

    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView emailText, passText;
        public ViewHolder(View view) {
            super(view);
            emailText = view.findViewById(R.id.emailTxt);
            passText = view.findViewById(R.id.passwordTxt);
        }

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
