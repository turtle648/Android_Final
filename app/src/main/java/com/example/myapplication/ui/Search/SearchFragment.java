package com.example.myapplication.ui.Search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    private SearchViewModel searchViewModel;
    private Spinner spinner1, spinner2;
    private ScrollView scrollView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Spinner 초기화
        spinner1 = root.findViewById(R.id.spinner);
        spinner2 = root.findViewById(R.id.spinner_2);
        scrollView = root.findViewById(R.id.scrollView);

        // 스피너1 아이템 추가
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(requireContext(),
                R.array.body_parts_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        // 스피너2 아이템 추가
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(requireContext(),
                R.array.exercises_array_back, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        // 스피너 값 설정
        spinner1.setSelection(adapter1.getPosition("등")); // 스피너1에 "등" 설정
        spinner2.setSelection(adapter2.getPosition("렛풀다운")); // 스피너2에 "렛풀다운" 설정

        // ScrollView에 텍스트 추가
        updateChartText("등", "렛풀다운");

        // 스피너 이벤트 리스너 등록
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedBodyPart = (String) parentView.getItemAtPosition(position);
                String selectedExercise = (String) spinner2.getSelectedItem();
                updateChartText(selectedBodyPart, selectedExercise);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedBodyPart = (String) spinner1.getSelectedItem();
                String selectedExercise = (String) parentView.getItemAtPosition(position);
                updateChartText(selectedBodyPart, selectedExercise);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        // 여기에 스피너나 다른 뷰들과 상호 작용하는 로직 추가

        return root;
    }

    private void updateChartText(String bodyPart, String exercise) {
        String text = "2023.11.19. " + exercise + ", 3세트, 8개, 40kg";
        TextView textView = new TextView(requireContext());
        textView.setText(text);
        scrollView.removeAllViews();
        scrollView.addView(textView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
