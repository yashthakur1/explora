package com.heady.explora.screens.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.heady.explora.R;
import com.heady.explora.screens.userModels.ResponseResult;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by yashthakur on 26/08/18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    Context context;
    private ArrayList<ResponseResult> users;
    public UserAdapter.OnItemClickListener listener;

    public UserAdapter(Context context, ArrayList<ResponseResult> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery_image, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder viewHolder, final int position) {

        ResponseResult user = users.get(position);
        String url = user.getPicture().getLarge();

        Logger.d("BIND " + position);
        Picasso.get().load(url).into(viewHolder.imageView);
        viewHolder.btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users != null ? users.size() : 0;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        Button btnReject;

        UserViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            btnReject = itemView.findViewById(R.id.btnReject);
        }
    }

    public void removeAt(int position) {
        users.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, users.size());
    }


    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }


}

