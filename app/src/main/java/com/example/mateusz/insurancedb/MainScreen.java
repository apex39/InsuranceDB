package com.example.mateusz.insurancedb;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.domain.model.Oc;

import static android.app.PendingIntent.getActivity;
import static android.support.v7.app.ActionBar.OnNavigationListener;


public class MainScreen extends ActionBarActivity implements list.OnFragmentInteractionListener {
    DatabaseData data = new DatabaseData();
    ListsAdapter listsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listsAdapter = new ListsAdapter(this, data.getData1(), data.getData2());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

                toolbar.setOnMenuItemClickListener(
                        new Toolbar.OnMenuItemClickListener() {

                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                return true;
                            }
                        }
                );

        String url = "https://insurancedb-testing9569.rhcloud.com/connectDB.php";
        final GsonRequest gsonRequest = new GsonRequest(url, com.domain.model.Oc.class, null, new Response.Listener<Oc>() {

            @Override
            public void onResponse(Oc response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(volleyError != null) Log.e("MainActivity", volleyError.getMessage());
            }
        });

    }

    private void setListContent() {

        data.setData1("asd");
        data.setData2("as");
        ListView list = (ListView) findViewById(R.id.list_container);
        list.setAdapter(listsAdapter);
        listsAdapter.notifyDataSetChanged();
    }
    private void addListContent(){
        data.setData1("asd");
        data.setData2("as");
        listsAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Spinner spinner = (Spinner) findViewById(R.id.menu_spinner);
        SpinnerAdapter spinnerAdapter = ArrayAdapter.createFromResource
                (getSupportActionBar().getThemedContext(), R.array.mainScreen_list, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setListContent();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return true;
    }

    private String getScreenName(){
        return "x";
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_search) {
            onSearchRequested();
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }

    public void openActivityElement(View view) {
        Intent intent = new Intent(this,Details.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        ;
    }

}
