package com.example.herry_wang.week2_fragment;

/**
 * Created by Herry_Wang on 2015/1/16.
 */

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private Button backBtn,nextBtn;
    private int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        backBtn = (Button)findViewById(R.id.back_button);
        nextBtn = (Button)findViewById(R.id.next_button);
        changeFragment(MainFragment.newInstance(page));
        backBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(page>1){
                    changeFragment(MainFragment.newInstance(--page));
                }
                else{
                    changeFragment(MainFragment.newInstance(page));
                }
            }

        });
        nextBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                changeFragment(MainFragment.newInstance(++page));
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void changeFragment(Fragment f) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, f);
        transaction.commit();
    }


}