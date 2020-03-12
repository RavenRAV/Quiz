package com.example.quiz.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.quiz.QuizActivity;
import com.example.quiz.utils.SimpleOnSeekBarChangeListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private SeekBar seekBar;
    private TextView textView;
    private int min = 5;

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
        textView.setText(String.valueOf(min));

        view.findViewById(R.id.b_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizActivity.start(getActivity());
            }
        });

        seekBar.setOnSeekBarChangeListener(new SimpleOnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                super.onProgressChanged(seekBar, progress, fromUser);
                if(progress < min)
                seekBar.setProgress(min);

                textView.setText(String.valueOf(seekBar.getProgress()));
            }
        });


    }
}
