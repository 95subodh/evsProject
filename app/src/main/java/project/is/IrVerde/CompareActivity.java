package project.is.IrVerde;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by subodhyadav on 04/05/15.
 */

public class CompareActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

    private Toolbar mToolbar;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private RecyclerView.LayoutManager mLinearLayoutManager;
    RecyclerView mRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_topdrawer2);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mRecycleView = (RecyclerView) findViewById(R.id.listView);
        mRecycleView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLinearLayoutManager);

        //setting data in it.
        ArrayList<MainActivityListItem> mainActivityList = new ArrayList<MainActivityListItem>();
        MainActivityListItem mainActivityListItem1 = new MainActivityListItem("1");
        MainActivityListItem mainActivityListItem2 = new MainActivityListItem("2");
        MainActivityListItem mainActivityListItem3 = new MainActivityListItem("3");
        MainActivityListItem mainActivityListItem4 = new MainActivityListItem("4");
        MainActivityListItem mainActivityListItem5 = new MainActivityListItem("5");
        MainActivityListItem mainActivityListItem6 = new MainActivityListItem("6");
        //MainActivityListItem mainActivityListItem7 = new MainActivityListItem("Chimney");
        //MainActivityListItem mainActivityListItem8 = new MainActivityListItem("Cooler");
        mainActivityList.add(mainActivityListItem1);
        mainActivityList.add(mainActivityListItem2);
        mainActivityList.add(mainActivityListItem3);
        mainActivityList.add(mainActivityListItem4);
        mainActivityList.add(mainActivityListItem5);
        mainActivityList.add(mainActivityListItem6);
        //mainActivityList.add(mainActivityListItem7);
        //mainActivityList.add(mainActivityListItem8);
        final MainActivityListAdapter listAdapter = new MainActivityListAdapter(this, mainActivityList);
        mRecycleView.setAdapter(listAdapter);
        //To Add Floating Action bar when we will have the listview ready.
        /*RecyclerView recyclerView = (RecyclerView) findViewById(android.R.id.list);
        */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToRecyclerView(mRecycleView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecycleView.scrollToPosition(1);
                //Intent intent = new Intent(getBaseContext(), About.class);
                //startActivity(intent);
            }
        });

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SignOut signOut = new SignOut(PlusBaseActivity.mPlusClient);
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.signOut:
                signOut.signOut();
                goBackToLogin();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goBackToLogin() {
        Intent intent = new Intent(this, ActivityLogin.class);
        startActivity(intent);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
        String className = this.getClass().getSimpleName();
        if(position==0 && className!="MainActivity"){
//            Intent home = new Intent(this,MainActivity.class);
            //home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(home);
            //super.onBackPressed();
        }
        else if (position==1){
            Intent about = new Intent(this,About.class);
            about.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(about);
        }
        else if (position==2) {
            Intent exit = new Intent(Intent.ACTION_MAIN);
            exit.addCategory(Intent.CATEGORY_HOME);
            exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(exit);
        }
    }
}
