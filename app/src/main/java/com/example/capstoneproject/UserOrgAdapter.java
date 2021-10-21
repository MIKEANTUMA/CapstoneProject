package com.example.capstoneproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.capstoneproject.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class UserOrgAdapter extends RecyclerView.Adapter<UserOrgAdapter.TasksViewHolder> {
    private Context mCtx;
    private List<UserOrgRoom> taskList;

    public UserOrgAdapter(Context mCtx, List<UserOrgRoom> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.activity_show_users, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        UserOrgRoom t = taskList.get(position);
        holder.textViewTask.setText(t.getEmail());
        holder.textViewDesc.setText(t.getUsername());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewStatus, textViewTask, textViewDesc, textViewFinishBy;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textViewTask = itemView.findViewById(R.id.textViewEmail);
            textViewDesc = itemView.findViewById(R.id.textViewUserName);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            UserOrgRoom note = taskList.get(getAdapterPosition());

            Intent intent = new Intent(mCtx, Register.class);
            intent.putExtra("Note", note);

            mCtx.startActivity(intent);
        }
    }
}
