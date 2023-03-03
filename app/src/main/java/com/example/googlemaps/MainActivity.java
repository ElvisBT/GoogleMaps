package com.example.googlemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener
{
    //let service;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(-1.0097359955229466, -79.46945600409167), 50);
        mMap.moveCamera(camUpd1);
        //PolylineOptions lineas = new PolylineOptions()
            //    .add(new LatLng(25.265074, 51.446466))
          //      .add(new LatLng(25.265377, 51.449447))
              //  .add(new LatLng(25.262054, 51.449929))
                //.add(new LatLng(25.261779, 51.446515))
                //add(new LatLng(25.265074, 51.446466));
        //lineas.width(8);
        //lineas.color(Color.RED);
        //mMap.addPolyline(lineas);

        LatLng punto = new LatLng(-1.0097359955229466, -79.46945600409167);
        mMap.addMarker(new MarkerOptions().position(punto)
                .title("KFC - Paseo Shopping Quevedo").snippet("Restaurante de comida Rapida"));

        LatLng punto1 = new LatLng(-1.010184962389284, -79.47039425909544);
        mMap.addMarker(new MarkerOptions().position(punto1)
                .title("Asadero la esquina del shooping").snippet("Pidelo a Domicilio al : 095847336"));

        LatLng punto2 = new LatLng(-1.010109872068591, -79.47089851465867);
        mMap.addMarker(new MarkerOptions().position(punto2)
                .title("DESAYUNOS Y ALMUERZO MARIA JOSE").snippet("Pidelo a Domicilio"));

        LatLng punto3 = new LatLng(-1.0139612453056612, -79.47068103113877);
        mMap.addMarker(new MarkerOptions().position(punto3)
                .title("D Joalmar Sorbetes & Burgers").snippet("Pidelo a Domicilio"));

        LatLng punto4 = new LatLng(-1.0134642951989752, -79.46931229461099);
        mMap.addMarker(new MarkerOptions().position(punto4)
                .title("Lokos D' Asar\n").snippet("Pidelo a Domicilio"));


        mMap.setInfoWindowAdapter(new UserInfoWindowAdapter(getLayoutInflater()));

        /*LatLng madrid = new LatLng(25.263708222565565, 51.44834527551974);

        CameraPosition camPos = new CameraPosition.Builder()
                .target(madrid)
                .zoom(19)
                .bearing(45)      //noreste arriba
                .tilt(70)         //punto de vista de la cámara 70 grados
                .build();

        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);

        mMap.animateCamera(camUpd3);*/
       // service = new google.maps.places.PlacesService(mMap);
        //service.nearbySearch(request, callback);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        Projection proj = mMap.getProjection();
        Point coord = proj.toScreenLocation(latLng);
        Toast.makeText(MainActivity.this, "Click\n" + "Lat: " + latLng.latitude + "\n" + "Lng: " + latLng.longitude + "\n" + "X: " + coord.x + " - Y: " + coord.y, Toast.LENGTH_SHORT).show();
    }
}