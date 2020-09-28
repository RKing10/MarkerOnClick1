package com.example.markeronclick1;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng>arrayList = new ArrayList<LatLng>();
    LatLng sydney = new LatLng(-34, 151);
    LatLng Tamworth = new LatLng(-31, 150);
    LatLng Newcastle = new LatLng(-32, 151);
    LatLng Brisbane = new LatLng(-27, 153);
    LatLng Dubbo = new LatLng(-32, 148);

    ArrayList<String> title = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        arrayList.add(sydney);
        arrayList.add(Tamworth);
        arrayList.add(Newcastle);
        arrayList.add(Brisbane);
        arrayList.add(Dubbo);

        title.add("Sydney");
        title.add("Tamworth");
        title.add("Newcastle");
        title.add("Brisbane");
        title.add("Dubbo");

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for (int i=0; i < arrayList.size();i++) {

            for (int j =0; j<title.size();j++) {

                mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(String.valueOf(title.get(i))));
            }
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }

       mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
           @Override
           public boolean onMarkerClick(Marker marker) {
               String markertitle = marker.getTitle();

               Intent i = new Intent(MapsActivity.this, DetailsActivity.class);
               i.putExtra("title", markertitle);
               startActivity(i);


               return false;
           }
       });
    }
}