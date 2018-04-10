package com.example.rahulhariharan.f2.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rahulhariharan.f2.R;
import com.example.rahulhariharan.f2.api_client.PhotoAPI;
import com.example.rahulhariharan.f2.api_client.RetrofitClient;
import com.example.rahulhariharan.f2.model.Photo;
import com.example.rahulhariharan.f2.model_view.PhotoModelView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements PhotoModelView.PhotoModelViewEvent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PhotoModelView.getPhotos(this);
    }

    @Override
    public void onSuccess(List<Photo> photo) {
       /* RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PhotoAdapter adapter = new PhotoAdapter(photo);
        recyclerView.setAdapter(adapter);*/

        Observable<List<Photo>> listObservable = Observable.just(photo);

        listObservable.subscribe(new Observer<List<Photo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Photo> photos) {
                Log.v("event_2", photos.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onFailure() {

    }
}
