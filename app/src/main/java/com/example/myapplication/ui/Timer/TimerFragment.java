package com.example.myapplication.ui.Timer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentTimerBinding;

public class TimerFragment extends Fragment {

private FragmentTimerBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        TimerViewModel timerViewModel =
                new ViewModelProvider(this).get(TimerViewModel.class);

    binding = FragmentTimerBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
//
//        final TextView textView = binding.textView;
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
        return inflater.inflate(R.layout.fragment_timer, container, false);

    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}