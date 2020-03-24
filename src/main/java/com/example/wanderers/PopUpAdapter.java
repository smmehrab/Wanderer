package com.example.wanderers;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PopUpAdapter extends BaseAdapter {

    Context context;
    ArrayList<PopUp> arrayList;
    Resources resources;
    String[] titles;
    LayoutInflater inflater;
    View popUpView;
    TextView popUpText;
    ViewGroup viewGroup;

    public PopUpAdapter(Context context) {
        this.context = context;
        arrayList = new ArrayList<>();
        resources = context.getResources();
        titles = resources.getStringArray(R.array.pop_up_titles);

        for(int index = 0;index<titles.length;index++){
            arrayList.add(new PopUp(titles[index]));
        }
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        popUpView = inflater.inflate(R.layout.pop_up, parent, false );

        popUpText = (TextView) popUpView.findViewById(R.id.popUpTextView);
        PopUp popUpObj = arrayList.get(position);
        popUpText.setText(popUpObj.getTitle());

        return popUpView;
    }
}
