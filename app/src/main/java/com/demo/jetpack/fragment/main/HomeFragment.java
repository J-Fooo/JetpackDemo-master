package com.demo.jetpack.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.jetpack.R;
import com.demo.jetpack.viewmodel.NumViewModel;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class HomeFragment extends Fragment {

    private TextView mTvNumber;
    private TextView mTvAdd;
    private NumViewModel mNumViewModel;
    private int num = 1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNumViewModel = new ViewModelProvider(this).get(NumViewModel.class);
        mNumViewModel.getNumData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mTvNumber.setText(String.valueOf(integer));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        View view = binding.getRoot();

        mTvNumber = view.findViewById(R.id.tv_number);
        mTvAdd = view.findViewById(R.id.tv_add);

        mTvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNumViewModel.setNumData(num++);
            }
        });
        return view;
    }


}
