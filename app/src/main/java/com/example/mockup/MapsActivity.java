package com.example.mockup;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-29.7549941, -51.150283);
        LatLng esteio = new LatLng(-29.8524632, -51.1845758);
        LatLng saoLeopoldo = new LatLng(-29.761273, -51.145735);
        LatLng sapucaia = new LatLng(-29.764196, -51.144060);
        LatLng canoas = new LatLng(-29.918437, -51.182065);
        LatLng fenac = new LatLng(-29.703625, -51.138389);
        LatLng polisinos = new LatLng(-29.772845, -51.127422);
        LatLng unisinos = new LatLng(-29.795274, -51.152163);

        mMap.addMarker(new MarkerOptions().position(esteio).title("Marker em Esteio"));
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(saoLeopoldo).title("Marker in São Leopoldo"));
        mMap.addMarker(new MarkerOptions().position(sapucaia).title("Marker in Sapucaia"));
        mMap.addMarker(new MarkerOptions().position(canoas).title("Marker in Canoas"));
        mMap.addMarker(new MarkerOptions().position(fenac).title("Marker in Fenac"));
        mMap.addMarker(new MarkerOptions().position(polisinos).title("Marker em Polisinos"));
        mMap.addMarker(new MarkerOptions().position(unisinos).title("Marker em Unisinos"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //setar o room do mapa
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12.0f));
        //mostra controle de zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //adiciona rota
        mMap.addPolyline(new PolylineOptions()
                .add(sydney, esteio)
                .width(5)
                .color(Color.RED));

    }
}