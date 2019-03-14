package com.elfefe.exinterface.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.elfefe.exinterface.R;
import com.elfefe.exinterface.fragment.DetailFragment;
import com.elfefe.exinterface.fragment.MainFragment;
import com.elfefe.exinterface.fragment.MainFragment.OnButtonClickedListener;

public class MainActivity extends AppCompatActivity implements OnButtonClickedListener {

    DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.configureToolbar();
        this.configureAndShowMainFragment();
        this.configureAndShowDetailFragment();
    }

    private void configureAndShowMainFragment(){
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);

        if (mainFragment == null) {
            mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_main, mainFragment)
                    .commit();
        }
    }

    private void configureAndShowDetailFragment(){
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (detailFragment == null && findViewById(R.id.frame_layout_detail) != null) {
            detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit();
        }
    }

    private void configureToolbar(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        this.setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_activity_main_params:
                Toast.makeText(this, "Il n'y a rien à paramétrer ici, passez votre chemin...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_activity_main_search:
                Toast.makeText(this, "Recherche indisponible, demandez plutôt l'avis de Google, c'est mieux et plus rapide.", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onButtonClicked(View view) {
        int buttonTag = Integer.parseInt(view.getTag().toString());

        if(detailFragment != null && detailFragment.isVisible()){
            detailFragment.updateTextView(buttonTag);
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_BUTTON_TAG, buttonTag);
            startActivity(intent);
        }
    }
}
