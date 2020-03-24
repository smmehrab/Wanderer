package com.example.wanderers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryAdapter extends BaseAdapter {

    private int[] flags;
    private String[] countryNames;
    private String[] countrySubtitles;
    private Context context;
    private LayoutInflater inflater;

    CountryAdapter(Context context, String[] countryNames, String[] countrySubtitles, int[] flags){
        this.context=context;
        this.countryNames=countryNames;
        this.countrySubtitles=countrySubtitles;
        this.flags=flags;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.country_view, parent, false);
        }

        ImageView countryFlag = (ImageView) convertView.findViewById(R.id.countryFlag);
        TextView countryName = (TextView) convertView.findViewById(R.id.countryName);
        TextView countrySubtitle = (TextView) convertView.findViewById(R.id.countrySubtitle);

        countryFlag.setImageResource(flags[position]);
        countryName.setText(countryNames[position]);
        countrySubtitle.setText(countrySubtitles[position]);

        return convertView;
    }
}
