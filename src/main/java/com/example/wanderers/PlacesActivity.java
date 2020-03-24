package com.example.wanderers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class PlacesActivity extends AppCompatActivity {

    private ListView spotList;

    private String[] spotTitles;
    private String[] spotSubtitles;
    private int[] spotCovers;

    private Intent intent;
    private Context context = PlacesActivity.this;

    private AlertDialog popUp;
    private AlertDialog.Builder popUpBuilder;
    private View pop_up_view;
    private LayoutInflater popUpInflater;
    private ListView popUpListView;
    private String[] popUpItemTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        String receivedCountry = getIntent().getStringExtra("countryName").toString();

        loadPlaces(receivedCountry);
        showPlaces();
    }

    public void loadPlaces(String receivedCountry){
        if(receivedCountry.equals("Bangladesh")){
            loadBangladeshiPlaces();
        }

        else if(receivedCountry.equals("Bhutan")){
            loadBhutaniPlaces();
        }

        else if(receivedCountry.equals("India")){
            loadIndianPlaces();
        }

        else if(receivedCountry.equals("Nepal")){
            loadNepaliPlaces();
        }
    }


    public void loadBangladeshiPlaces(){
        spotCovers = new int[]{R.drawable.ahsan_manzil_cover,
                R.drawable.boga_lake_cover,
                R.drawable.cox_bazar_cover,
                R.drawable.jaflong_cover,
                R.drawable.kantojir_mondir_cover,
                R.drawable.kuakata_cover,
                R.drawable.kushtia_kuthibari_cover,
                R.drawable.lala_khal_cover,
                R.drawable.nilgiri_cover,
                R.drawable.sajek_valley_cover,
                R.drawable.shat_gombuj_cover,
                R.drawable.sundarban_cover};
        spotTitles = getResources().getStringArray(R.array.bangladeshi_spot_titles);
        spotSubtitles = getResources().getStringArray(R.array.bangladeshi_spot_subtitles);
    }

    public void loadBhutaniPlaces(){
        spotCovers = new int[]{R.drawable.ahsan_manzil_cover,
                R.drawable.boga_lake_cover,
                R.drawable.cox_bazar_cover,
                R.drawable.jaflong_cover,
                R.drawable.kantojir_mondir_cover,
                R.drawable.kuakata_cover,
                R.drawable.kushtia_kuthibari_cover,
                R.drawable.lala_khal_cover,
                R.drawable.nilgiri_cover,
                R.drawable.sajek_valley_cover,
                R.drawable.shat_gombuj_cover,
                R.drawable.sundarban_cover};
        spotTitles = getResources().getStringArray(R.array.bangladeshi_spot_titles);
        spotSubtitles = getResources().getStringArray(R.array.bangladeshi_spot_subtitles);
    }

    public void loadIndianPlaces(){
        spotCovers = new int[]{R.drawable.ahsan_manzil_cover,
                R.drawable.boga_lake_cover,
                R.drawable.cox_bazar_cover,
                R.drawable.jaflong_cover,
                R.drawable.kantojir_mondir_cover,
                R.drawable.kuakata_cover,
                R.drawable.kushtia_kuthibari_cover,
                R.drawable.lala_khal_cover,
                R.drawable.nilgiri_cover,
                R.drawable.sajek_valley_cover,
                R.drawable.shat_gombuj_cover,
                R.drawable.sundarban_cover};
        spotTitles = getResources().getStringArray(R.array.bangladeshi_spot_titles);
        spotSubtitles = getResources().getStringArray(R.array.bangladeshi_spot_subtitles);
    }

    public void loadNepaliPlaces(){
        spotCovers = new int[]{R.drawable.ahsan_manzil_cover,
                R.drawable.boga_lake_cover,
                R.drawable.cox_bazar_cover,
                R.drawable.jaflong_cover,
                R.drawable.kantojir_mondir_cover,
                R.drawable.kuakata_cover,
                R.drawable.kushtia_kuthibari_cover,
                R.drawable.lala_khal_cover,
                R.drawable.nilgiri_cover,
                R.drawable.sajek_valley_cover,
                R.drawable.shat_gombuj_cover,
                R.drawable.sundarban_cover};
        spotTitles = getResources().getStringArray(R.array.bangladeshi_spot_titles);
        spotSubtitles = getResources().getStringArray(R.array.bangladeshi_spot_subtitles);
    }

    public void showPlaces(){
        spotList = (ListView) findViewById(R.id.spotList);
        PlaceAdapter adapter = new PlaceAdapter(this, spotTitles, spotSubtitles, spotCovers);
        spotList.setAdapter(adapter);


        spotList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPopUp(view);
            }
        });
    }

    public void showPopUp(View view){
        popUpItemTitles = getResources().getStringArray(R.array.pop_up_titles);
        popUpBuilder = new AlertDialog.Builder(context);
        popUpInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        pop_up_view = popUpInflater.inflate(R.layout.pop_up, null);
        popUpListView = (ListView) findViewById(R.id.popUpListView);
        PopUpAdapter  adapter = new PopUpAdapter(context);

        Toast.makeText(PlacesActivity.this,"Gotcha", Toast.LENGTH_SHORT).show();



        //popUpListView.setAdapter(adapter);
        //popUpBuilder.setView(pop_up_view);
        //popUp = popUpBuilder.create();
        //popUp.show();

    }
}
