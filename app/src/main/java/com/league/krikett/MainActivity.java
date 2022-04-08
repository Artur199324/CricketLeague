package com.league.krikett;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.league.krikett.adapter.CricketAdapter;
import com.league.krikett.model.Cricket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements CricketAdapter.OnItemClickListener{

    String results;
    String home;
    String away;
    String stadium;
    String date;
    String title;
    String status;
    CricketAdapter cricketAdapter;
    ArrayList<Cricket> arrayListCricket;
    RecyclerView recyclerViewCricket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCricket = findViewById(R.id.recyclerViewCricket);
        arrayListCricket = new ArrayList<>();

        recyclerViewCricket.setLayoutManager(new LinearLayoutManager(this));

        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://cricket-live-data.p.rapidapi.com/results")
                        .get()
                        .addHeader("X-RapidAPI-Host", "cricket-live-data.p.rapidapi.com")
                        .addHeader("X-RapidAPI-Key", "718e426adfmsh856cb77fb799819p12a0d6jsnb6f3b91fdadc")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    JSONArray jsonArrayResults = jsonObject.getJSONArray("results");
                    for (int i = 0; i< jsonArrayResults.length();i++){
                        JSONObject jsonObjectCricet = jsonArrayResults.getJSONObject(i);
                        results = jsonObjectCricet.getString("result");
                        stadium = jsonObjectCricet.getString("venue");
                        status = jsonObjectCricet.getString("status");
                        title = jsonObjectCricet.getString("match_title");
                        JSONObject jsonObject1Home = new JSONObject(jsonObjectCricet.getString("home"));
                        home = jsonObject1Home.getString("name");
                        JSONObject jsonObjectAway = new JSONObject(jsonObjectCricet.getString("away"));
                        away = jsonObjectAway.getString("name");
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        Date result;
                        try {
                            result = df.parse(jsonObjectCricet.getString("date"));
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            date = sdf.format(result);
                        }catch (Exception e){

                        }

                        Cricket cricket = new Cricket();
                        cricket.setResults(results);
                        cricket.setHome(home);
                        cricket.setAway(away);
                        cricket.setStadium(stadium);
                        cricket.setDate(date);
                        cricket.setTitle(title);
                        cricket.setStatus(status);
                        arrayListCricket.add(cricket);
                    }


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            cricketAdapter = new CricketAdapter(MainActivity.this,arrayListCricket);
                            cricketAdapter.setOnItemClickListener((CricketAdapter.OnItemClickListener) MainActivity.this);
                            recyclerViewCricket.setAdapter(cricketAdapter);
                        }
                    });


                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }


    @Override
    public void onItemClick(int position) {
        Cricket cricket = null;
        for (int i = 0; i<arrayListCricket.size();i++){
            cricket = arrayListCricket.get(position);

        }

        Intent intent = new Intent(getApplicationContext(),CricetActivity.class);
        intent.putExtra("result",cricket.getResults());
        intent.putExtra("awey",cricket.getAway());
        intent.putExtra("home",cricket.getHome());
        intent.putExtra("data",cricket.getDate());
        intent.putExtra("stadium",cricket.getStadium());
        intent.putExtra("status",cricket.getStatus());
        intent.putExtra("title",cricket.getTitle());
        startActivity(intent);
    }
}