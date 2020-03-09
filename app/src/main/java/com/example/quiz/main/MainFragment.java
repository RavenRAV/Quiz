package com.example.quiz.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.utils.SimpleOnSeekBarChangeListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private SeekBar seekBar;
    private TextView textView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        seekBar = view.findViewById(R.id.seek_bar_fm);
        textView = view.findViewById(R.id.q_amount);
        textView.setText("5");

        seekBar.setOnSeekBarChangeListener(new SimpleOnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                super.onProgressChanged(seekBar, progress, fromUser);
                textView.setText(String.valueOf(seekBar.getProgress()));
            }

//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                super.onStopTrackingTouch(seekBar);
//                textView.setText(String.valueOf(seekBar.getProgress()));
//            }
        });


    }
}
