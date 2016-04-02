package xyz.mhuy.n.roidkeeper;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import fragments.Fragment1;
import fragments.Fragment2;
import fragments.HomeFragment;

public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private DrawerLayout drawerLayout;
    private ActionBar actionBar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ListView navlist;

    private ArrayList<String> navArray;
    private ArrayAdapter<String> adapter;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        drawerLayout = (DrawerLayout) this.findViewById(R.id.drawerlayout);
        navlist = (ListView) this.findViewById(R.id.navlist);

        navArray = new ArrayList<String>();
        navArray.add("Home");
        navArray.add("Fragment 1");
        navArray.add("Fragment 2");
        navArray.add("Fragment 3");
        navArray.add("Fragment 4");
        navArray.add("Fragment 5");
        navlist.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_activated_1, navArray);
        navlist.setAdapter(adapter);
        navlist.setOnItemClickListener(this);


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.opendrawer, R.string.closedrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Howdy, good morning!");

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentholder, new HomeFragment());
        fragmentTransaction.commit();
        loadSelection(0);

    }

    private void loadSelection(int position){
        navlist.setItemChecked(position, true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            if(drawerLayout.isDrawerOpen(navlist)){
                drawerLayout.closeDrawer(navlist);
            } else {
                drawerLayout.openDrawer(navlist);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (position){
            case 0:
                fragmentTransaction.replace(R.id.fragmentholder, new HomeFragment());
                break;
            case 1:
                fragmentTransaction.replace(R.id.fragmentholder, new Fragment1());
                break;
            case 2:
                fragmentTransaction.replace(R.id.fragmentholder, new Fragment2());
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        drawerLayout.closeDrawer(navlist);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (drawerLayout.isDrawerOpen(navlist)){
                drawerLayout.closeDrawer(navlist);
            } else if (! drawerLayout.isDrawerOpen(navlist)){
                this.finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}