package com.example.rahulhariharan.f2.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rahulhariharan.f2.R;
import com.example.rahulhariharan.f2.databinding.RecyclerItemBinding;
import com.example.rahulhariharan.f2.model.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahulhariharan on 10/04/18.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    List<Photo> photos;

    PhotoAdapter(List<Photo> photos) {
       this.photos = photos != null ? photos : new ArrayList<Photo>();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        RecyclerItemBinding binding;

        public PhotoViewHolder(View itemView) {
            super(itemView);
        }

        public PhotoViewHolder(RecyclerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerItemBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.recycler_item,
                parent, false);
        return new PhotoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo photo = photos.get(position);
        holder.binding.setPhoto(photo);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}
