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
    private Spinner spinnerCategory;
    private Spinner spinnerDifficulty;
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
        spinnerCategory = view.findViewById(R.id.spinner_category);
        spinnerDifficulty = view.findViewById(R.id.spinner_difficulty);
        textView = view.findViewById(R.id.q_amount);
        textView.setText(String.valueOf(min));

//        seekBar.getProgress();
//        spinnerDifficulty.getSelectedIndex();
//        spinnerCategory.getSelectedIndex()+8;
//        spinnerCategory.getSelectedItem().toString().toLowerCase();


        view.findViewById(R.id.b_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizActivity.start(getActivity(), 5, null, null);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SimpleOnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                super.onProgressChanged(seekBar, progress, fromUser);
                if (progress < min)
                    seekBar.setProgress(min);

                textView.setText(String.valueOf(seekBar.getProgress()));
            }
        });

    }

    private void onStartClick() {
        seekBar.getProgress();
        Integer categoryId = null;
        if (spinnerCategory.getSelectedItemPosition() != 0) {
            categoryId = spinnerCategory.getSelectedItemPosition() + 8;
        }
//        spinnerDifficulty.getSelectedIndex()+8;
        spinnerCategory.getSelectedItem().toString().toLowerCase();

        Integer difficultyId = null;
        if (spinnerDifficulty.getSelectedItemPosition() != 0) {
            difficultyId = spinnerDifficulty.getSelectedItemPosition() + 8;
//        }

            QuizActivity.start(getContext(), seekBar.getProgress(), categoryId, difficultyId);
        }
    }
}
