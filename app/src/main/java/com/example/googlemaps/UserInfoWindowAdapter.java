package com.example.googlemaps;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class UserInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    LayoutInflater inflater=null;
    UserInfoWindowAdapter(LayoutInflater inflater){
        this.inflater=inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View infoWindows=inflater.inflate(R.layout.kfc, null);
        TextView title = (TextView) infoWindows.findViewById(R.id.textView);
        TextView description = (TextView) infoWindows.findViewById(R.id.textView2);
        title.setText(marker.getTitle());
        description.setText(marker.getSnippet());
        return (infoWindows);
    }
}
