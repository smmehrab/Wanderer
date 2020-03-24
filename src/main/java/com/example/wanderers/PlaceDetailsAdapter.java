package com.example.wanderers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDetailsAdapter extends BaseAdapter {

    private String[] spotTitles;
    private String[] spotSubtitles;
    private String[] spotDescriptions;
    private int[] spotCovers;

    private Context context;
    private LayoutInflater inflater;

    PlaceDetailsAdapter(Context context, String[] spotTitles, String[] spotSubtitles, String[] spotDescriptions, int[] spotCovers){
        this.context=context;
        this.spotTitles=spotTitles;
        this.spotSubtitles=spotSubtitles;
        this.spotDescriptions=spotDescriptions;
        this.spotCovers=spotCovers;
    }

    @Override
    public int getCount() {
        return spotTitles.length;
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
            convertView = inflater.inflate(R.layout.place_details_view, parent, false);
        }

        ImageView spotCover = (ImageView) convertView.findViewById(R.id.spotCover);
        TextView spotTitle = (TextView) convertView.findViewById(R.id.spotTitle);
        TextView spotSubtitle = (TextView) convertView.findViewById(R.id.spotSubtitle);
        TextView spotDescription = (TextView) convertView.findViewById(R.id.spotDescription);

        spotCover.setImageResource(spotCovers[position]);
        spotTitle.setText(spotTitles[position]);
        spotSubtitle.setText(spotSubtitles[position]);
        spotDescription.setText(spotDescriptions[position]);

        return convertView;
    }
}
