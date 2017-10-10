package com.tutorials.hp.searchbarrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import com.mancj.materialsearchbar.MaterialSearchBar;
import java.util.ArrayList;
/*
- Our MainActivity class.
- We reference our RecyclerView and  MaterialSearchBar here.
- We define data source and pass it to our MyAdapter instance.
- We add TextChangelistener to our material searchbar
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //RFERENCE VIEWS
        rv= (RecyclerView) findViewById(R.id.mRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));

        MaterialSearchBar searchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        searchBar.setHint("Search..");
        searchBar.setSpeechMode(true);

        //ADAPTER
        adapter=new MyAdapter(getGalaxies());
        rv.setAdapter(adapter);

        //SEARCHBAR TEXT CHANGE LISTENER
        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //SEARCH FILTER
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private ArrayList<String> getGalaxies()
    {
        ArrayList<String> galaxies=new ArrayList<>();
        galaxies.add("Cartwheel");
        galaxies.add("Whirlpool");
        galaxies.add("Andromeda I");
        galaxies.add("Andromeda II");
        galaxies.add("Sombrero");
        galaxies.add("Messier 81");
        galaxies.add("Messier 87");
        galaxies.add("Canis Majos Over-density");
        galaxies.add("Messier 92");
        galaxies.add("Black Eye");
        galaxies.add("Centaurus A");
        galaxies.add("Centaurus B");
        galaxies.add("Milky Way");
        galaxies.add("IC 1011");
        galaxies.add("Star Bust");
        galaxies.add("Hoag's Object");
        galaxies.add("Pinwheel");
        galaxies.add("Triangulum");
        galaxies.add("Cosmos Redshift");
        galaxies.add("Ursa Minor");
        galaxies.add("Virgo Stellar-Stream");

        return galaxies;
    }

}
