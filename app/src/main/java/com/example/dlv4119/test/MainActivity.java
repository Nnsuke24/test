package com.example.dlv4119.test;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = "MainActivity";


    boolean state = false;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // メニューのクリック処理
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                    return true;
                } else if (id == R.id.action_addItem){
                    addItem();
                    return true;
                }

                return true;
            }
        });

        click();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mDataset = new ArrayList<>();
        mDataset.add("A");
        mDataset.add("B");
        mDataset.add("C");
        mAdapter = new MyAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        // Sample Projectから参照
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Sample Projectから参照　ここまで

//        ((Button)findViewById(R.id.drawer_button)).setOnClickListener(this);
//
//        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer,
//                R.drawable.ic_drawer, R.string.drawer_open,
//                R.string.drawer_close) {
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                Log.i(LOGTAG, "onDrawerClosed");
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                Log.i(LOGTAG, "onDrawerOpened");
//            }
//
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                // ActionBarDrawerToggleクラス内の同メソッドにてアイコンのアニメーションの処理をしている。
//                // overrideするときは気を付けること。
//                super.onDrawerSlide(drawerView, slideOffset);
//                Log.i(LOGTAG, "onDrawerSlide : " + slideOffset);
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//                // 表示済み、閉じ済みの状態：0
//                // ドラッグ中状態:1
//                // ドラッグを放した後のアニメーション中：2
//                Log.i(LOGTAG, "onDrawerStateChanged  new state : " + newState);
//            }
//        };
//
//        mDrawer.setDrawerListener(mDrawerToggle);
//
//        // UpNavigationアイコン(アイコン横の<の部分)を有効に
//        // NavigationDrawerではR.drawable.drawerで上書き
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        // UpNavigationを有効に
//        getActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d(TAG, "onCreateOptionsMenu");
        return true;
    }

    @Override
    protected void onDestroy() {
        // TODO 自動生成されたメソッド・スタブ
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onPause() {
        // TODO 自動生成されたメソッド・スタブ
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        // TODO 自動生成されたメソッド・スタブ
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        // TODO 自動生成されたメソッド・スタブ
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onStart() {
        // TODO 自動生成されたメソッド・スタブ
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        // TODO 自動生成されたメソッド・スタブ
        super.onStop();
        Log.d(TAG, "onStop");
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
        } else if (id == R.id.action_addItem){
            addItem();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void click() {
        final Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state) {
                    btn.setSelected(false);
                    state = false;
                    btn.setText("start");
                } else {
                    btn.setSelected(true);
                    state = true;
                    btn.setText("stop");
                }
            }
        });

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void addItem() {
        mDataset.add(0, "X");
        mAdapter.notifyItemInserted(0);
    }
}
