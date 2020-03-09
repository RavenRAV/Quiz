package com.example.quiz.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.quiz.data.remote.IQuizApiClient;
import com.example.quiz.data.remote.QuizApiClient;
import com.example.quiz.history.HistoryFragment;
import com.example.quiz.R;
import com.example.quiz.model.Question;
import com.example.quiz.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private MainPagerAdapter adapter;
    private ViewPager pager;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.main_view_pager);
        adapter = new MainPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        bottomNav = findViewById(R.id.main_bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(this);

        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                bottomNav.getMenu().getItem(position).setChecked(true);
            }
        });

        new QuizApiClient().getQuestions(new IQuizApiClient.QuestionsCallback() {
            @Override
            public void onSuccess(List<Question> questions) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int page = 0;
        switch (item.getItemId()){
            case R.id.bn_history:
                page = 1;
                break;
            case R.id.bn_settings:
                page = 2;
                break;
        }
        pager.setCurrentItem(page);
        return true;
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
