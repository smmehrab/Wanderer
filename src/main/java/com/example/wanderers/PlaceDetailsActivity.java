package com.example.wanderers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class PlaceDetailsActivity extends AppCompatActivity {

    private ListView spotDetails;
    private String[] spotTitles;
    private String[] spotSubtitles;
    private String[] spotDescriptions;
    private int[] spotCovers = {R.drawable.ahsan_manzil_cover,
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

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        spotTitles = getResources().getStringArray(R.array.bangladeshi_spot_titles);
        spotSubtitles = getResources().getStringArray(R.array.bangladeshi_spot_subtitles);
        spotDescriptions = getResources().getStringArray(R.array.bangladeshi_spot_descriptions);

        spotDetails = (ListView) findViewById(R.id.spotDetails);

        PlaceDetailsAdapter adapter = new PlaceDetailsAdapter(this, spotTitles, spotSubtitles, spotDescriptions, spotCovers);
        spotDetails.setAdapter(adapter);
    }
}
