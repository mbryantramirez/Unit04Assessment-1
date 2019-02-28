package org.pursuit.unit_04_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.unit_04_assessment.model.Echinoderm;
import org.pursuit.unit_04_assessment.model.EnchinodermList;
import org.pursuit.unit_04_assessment.network.EchinodermService;
import org.pursuit.unit_04_assessment.network.RetroFitSingleton;
import org.pursuit.unit_04_assessment.recyclerview.MyAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "retrofit_call";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        Retrofit retrofit = RetroFitSingleton.getSingleInstance();
        retrofit.create(EchinodermService.class)
                .getEchinoderms()
                .enqueue(new Callback<EnchinodermList>() {
                    @Override
                    public void onResponse(Call<EnchinodermList> call, Response<EnchinodermList> response) {
                        Log.d(TAG, "onResponse: " + response.body().getEchinodermList());

                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        recyclerView.setAdapter(new MyAdapter(response.body().getEchinodermList()));
                        recyclerView.setHasFixedSize(true);
                    }

                    @Override
                    public void onFailure(Call<EnchinodermList> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }
}