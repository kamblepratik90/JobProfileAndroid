package com.example.jobprofile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JobAdapter<H> extends RecyclerView.Adapter<JobAdapter.PostViewHolder> {
    private List<Job> postList;
    Context context;

    public JobAdapter(Context context, int simple_list_item_1, List<Job> models){
        this.context=context;
        postList=models;
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.frontjob, parent, false);
        return new PostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Job model=postList.get(position);

        holder.txtId.setText(model.getId());
        holder.txtCampany.setText(model.getCompany());
        holder.txtPosition.setText(model.getPosition());
        holder.txtStatus.setText(model.getStatus());
        holder.txtJobtype.setText(model.getJobtype());
        holder.txtCreatedBy.setText(model.getCreatedBy());
        holder.txtCreatedAt.setText(model.getCreatedAt());

    }

    @Override
    public int getItemCount() {

        return postList.size();
    }

    public static class PostViewHolder extends  RecyclerView.ViewHolder {

        TextView txtId,txtCampany,txtPosition,txtStatus,txtJobtype,txtCreatedBy,txtCreatedAt;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            txtId = itemView.findViewById(R.id.id);
            txtCampany = itemView.findViewById(R.id.company);
            txtPosition = itemView.findViewById(R.id.position);
            txtStatus = itemView.findViewById(R.id.status);
            txtJobtype = itemView.findViewById(R.id.jobtype);
            txtCreatedAt = itemView.findViewById(R.id.createdat);
            txtCreatedBy = itemView.findViewById(R.id.createdby);

        }
    }


}
