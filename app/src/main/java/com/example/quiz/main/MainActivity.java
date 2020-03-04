package com.example.quiz.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.quiz.history.HistoryFragment;
import com.example.quiz.R;
import com.example.quiz.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    private MainPagerAdapter adapter;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.main_view_pager);
        adapter = new MainPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
    }


    private class MainPagerAdapter extends FragmentPagerAdapter {
        public MainPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment frag;
            switch (position){
                case 0:
                    frag = MainFragment.newInstance();
                    break;
                case 1:
                    frag = HistoryFragment.newInstance();
                    break;
                case 2:
                    frag = SettingsFragment.newInstance();
                    break;
                default:
                    frag = MainFragment.newInstance();
                    break;
            }
            return frag;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
