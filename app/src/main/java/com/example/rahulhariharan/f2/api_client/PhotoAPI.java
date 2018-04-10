package com.example.rahulhariharan.f2.api_client;

import android.util.Log;

import com.example.rahulhariharan.f2.model.Photo;
import com.example.rahulhariharan.f2.model_view.PhotoModelView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by rahulhariharan on 09/04/18.
 */

public class PhotoAPI {

    public interface PhotoService {
        @GET("photos")
        Call<List<Photo>> getPhotos();
    }

    public static void getPhotosAPI(final PhotoAPICallback photoAPICallback) {
        Retrofit retrofit = RetrofitClient.getInstance().getApiClient();
        PhotoService service = retrofit.create(PhotoService.class);
        Call<List<Photo>> call = service.getPhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                List<Photo> photos = response.body();
                Log.v("event_", photos.toString());
                photoAPICallback.onPhotoAPIsuccess(photos);
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.v("event_", "failure");
                photoAPICallback.onPhotoAPIfailure();
            }
        });
    }

    public interface PhotoAPICallback {
        void onPhotoAPIsuccess(List<Photo> photos);
        void onPhotoAPIfailure();
    }
}
