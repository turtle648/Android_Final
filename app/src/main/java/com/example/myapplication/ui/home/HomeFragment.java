package com.example.myapplication.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeFragment extends Fragment {

    private DatePicker datePicker;
    private EditText editText1, editText2, editText3, editText4, editText5, editText6;
    private Button button1, button2;
    private ListView listView;

    // 데이터를 저장할 리스트
    private List<String> dataList;
    private ArrayAdapter<String> adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        datePicker = view.findViewById(R.id.datePicker);
        editText1 = view.findViewById(R.id.editText1);
        editText2 = view.findViewById(R.id.editText2);
        editText3 = view.findViewById(R.id.editText_extitle);
        editText4 = view.findViewById(R.id.editText_set);
        editText5 = view.findViewById(R.id.editText_times);
        editText6 = view.findViewById(R.id.editText_weight);
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        listView = view.findViewById(R.id.listView);

        // 리스트뷰에 사용할 어댑터 및 데이터 리스트 초기화
        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(requireContext(), R.layout.exercise_item, R.id.textView5, dataList);
        listView.setAdapter(adapter);

        // 버튼1 클릭 이벤트 처리 예시
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼1 클릭에 대한 로직을 여기에 추가

            }
        });

        // 버튼2 클릭 이벤트 처리 예시
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 에딧텍스트에서 데이터 가져와서 리스트에 추가
                String data = editText1.getText().toString() + ", " +
                        editText2.getText().toString() + ", " +
                        editText3.getText().toString() + ", " +
                        editText4.getText().toString() + ", " +
                        editText5.getText().toString() + ", " +
                        editText6.getText().toString();
                dataList.add(data);

                // 어댑터 갱신
                adapter.notifyDataSetChanged();
            }
        });

        // DatePicker의 날짜 변경 이벤트 처리
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        // 선택된 날짜를 EditText1에 표시
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                        Date selectedDate = new Date(year - 1900, monthOfYear, dayOfMonth);
                        String formattedDate = sdf.format(selectedDate);
                        editText1.setText(formattedDate);
                    }
                });

        return view;
    }
}
