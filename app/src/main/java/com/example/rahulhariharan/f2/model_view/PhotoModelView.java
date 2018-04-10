package com.example.rahulhariharan.f2.model_view;

import android.provider.Contacts;

import com.example.rahulhariharan.f2.api_client.PhotoAPI;
import com.example.rahulhariharan.f2.model.Photo;

import java.util.List;

/**
 * Created by rahulhariharan on 10/04/18.
 */

public class PhotoModelView {

    public static void getPhotos(final PhotoModelViewEvent event) {
        PhotoAPI.getPhotosAPI(new PhotoAPI.PhotoAPICallback() {
            @Override
            public void onPhotoAPIsuccess(List<Photo> photos) {
                // Data binding
                event.onSuccess(photos);
            }

            @Override
            public void onPhotoAPIfailure() {
                // handle failure
                event.onFailure();
            }
        });
    }


    public interface PhotoModelViewEvent {
        void onSuccess(List<Photo> photo);
        void onFailure();
    }
}
