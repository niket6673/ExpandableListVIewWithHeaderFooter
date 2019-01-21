package com.example.niket.headerfooterforexpandablelistview;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MainActivity extends Activity {
    ExpandableListView elv;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = getLayoutInflater();
        elv = (ExpandableListView)findViewById(R.id.elv);
        elv.setOnGroupExpandListener(onGroupExpandListenser);
        MyExpandableAdapter adapter = new MyExpandableAdapter(this, getData());
        elv.setAdapter(adapter);
    }

    ExpandableListView.OnGroupExpandListener onGroupExpandListenser = new ExpandableListView.OnGroupExpandListener() {
        int previousGroup =-1;
        @Override
        public void onGroupExpand(int groupPosition) {
            if(groupPosition!= previousGroup)
                elv.collapseGroup(previousGroup);
            previousGroup = groupPosition;
        }
    };

    public  List<ParentObject> getData()
    {
        List<ParentObject> parentObjects = new ArrayList<ParentObject>();
        for (int i = 0; i<20; i++)
        {
            parentObjects.add(new ParentObject("Mother " +i, "Father " +i, "Header " + i, "Footer " +i, getChildren(i)));

        }
        return parentObjects;
    }

    private  List<ChildObject> getChildren(int childCount)
    {
        List<ChildObject> childObjects = new ArrayList<ChildObject>();
        for (int i =0; i<childCount; i++)
        {
            childObjects.add(new ChildObject("Child " + (i+1), 10 +i ));
        }
        return childObjects;
    }


  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/



}