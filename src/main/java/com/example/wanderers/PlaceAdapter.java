package com.example.wanderers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceAdapter extends BaseAdapter {

    private int[] spotCovers;
    private String[] spotTitles;
    private String[] spotSubtitles;

    private Context context;
    private LayoutInflater inflater;

    PlaceAdapter(Context context, String[] spotTitles, String[] spotSubtitles, int[] spotCovers){
        this.context=context;
        this.spotTitles=spotTitles;
        this.spotSubtitles=spotSubtitles;
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
            convertView = inflater.inflate(R.layout.place_view, parent, false);
        }

        ImageView spotCover = (ImageView) convertView.findViewById(R.id.spotCover);
        TextView spotTitle = (TextView) convertView.findViewById(R.id.spotTitle);
        TextView spotSubtitle = (TextView) convertView.findViewById(R.id.spotSubtitle);

        spotCover.setImageResource(spotCovers[position]);
        spotTitle.setText(spotTitles[position]);
        spotSubtitle.setText(spotSubtitles[position]);

        return convertView;
    }
}
