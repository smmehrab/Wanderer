package com.example.wanderers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CountriesActivity extends AppCompatActivity {

    private ListView countryList;
    private String[] countryNames;
    private String[] countrySubtitles;
    private int[] flags = {R.drawable.bangladesh_flag,
                            R.drawable.bhutan_flag,
                            R.drawable.india_flag,
                            R.drawable.nepal_flag};
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        countryNames = getResources().getStringArray(R.array.country_names);
        countrySubtitles = getResources().getStringArray(R.array.country_subtitles);

        countryList = (ListView) findViewById(R.id.countryList);

        CountryAdapter adapter = new CountryAdapter(this, countryNames, countrySubtitles, flags);
        countryList.setAdapter(adapter);

        countryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemName = countryNames[position];

                intent = new Intent(CountriesActivity.this, PlacesActivity.class);
                intent.putExtra("countryName", selectedItemName);
                startActivity(intent);
            }
        });
    }
}
