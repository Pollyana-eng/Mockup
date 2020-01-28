package com.example.mockup;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Exerciciomapa extends AppCompatActivity implements OnMapReadyCallback {
        private DrawerLayout drawer;
        private GoogleMap mMap;

        //declara variaveis para permissão location
        private static final String[] LOCATION_PERMS={
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        private static final int INITIAL_REQUEST=1337;
        private static final int LOCATION_REQUEST=INITIAL_REQUEST+3;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_exerciciomapa);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

            Toolbar mytoolbar = (Toolbar)findViewById(R.id.my_toolbar);
            setSupportActionBar(mytoolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);


            drawer = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, mytoolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();


        }
        @Override
        public void onBackPressed() {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
        @Override
        public void onMapReady(GoogleMap googleMap) {
           mMap = googleMap;

            // Add a marker in Sydney and move the camera
            LatLng CaxiasdoSul = new LatLng(-29.169388, -51.181995);
            LatLng Gramado = new LatLng(-29.380655, -50.875920);
            LatLng PortoAlegre = new LatLng(-30.023674, -51.184504);
            LatLng Torres = new LatLng(-29.336783, -49.727969);
            LatLng SãoFrancisco = new LatLng(-29.444312, -50.580523);

            mMap.addMarker(new MarkerOptions().position(CaxiasdoSul).title("Marker em Caxias do Sul").icon(BitmapDescriptorFactory.fromResource(R.drawable.caxias)));
            mMap.addMarker(new MarkerOptions().position(Gramado).title("Marker em Gramado").icon(BitmapDescriptorFactory.fromResource(R.drawable.arvorepng)));
            mMap.addMarker(new MarkerOptions().position(PortoAlegre).title("Marker em Porto Alegre").icon(BitmapDescriptorFactory.fromResource(R.drawable.casinha)));
            mMap.addMarker(new MarkerOptions().position(Torres).title("Marker em Torres").icon(BitmapDescriptorFactory.fromResource(R.drawable.praia)));

            //setar o room do mapa
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(CaxiasdoSul, 12.0f));
            //mostra controle de zoom
            mMap.getUiSettings().setZoomControlsEnabled(true);

            //verifica se é permitido ao aplicativo pegar a localização atual do dispositivo
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            } else {
                //caso ainda não tenha sido dada a permissão, solicitar a permissão
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(LOCATION_PERMS, LOCATION_REQUEST);
                }
            }

            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            mMap.getUiSettings().setCompassEnabled(true);


            //adiciona rota
            mMap.addPolyline(new PolylineOptions()
                    .add(CaxiasdoSul, Gramado, PortoAlegre, Torres, CaxiasdoSul)
                    .width(5)
                    .color(Color.BLUE));

            mMap.addCircle(
                    new CircleOptions()
                            .center(SãoFrancisco)
                            .radius(90000.0)
                            .strokeWidth(5f)
                            .strokeColor(Color.BLUE)
                            .fillColor(Color.argb(61,58,137,190))
            );

        }
}




