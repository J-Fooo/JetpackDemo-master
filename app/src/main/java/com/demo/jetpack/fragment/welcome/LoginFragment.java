package com.demo.jetpack.fragment.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.jetpack.R;
import com.demo.jetpack.activity.MainActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment {
    private static final String ARG_PARAM = "param";

    // TODO: Rename and change types of parameters
    private String mParam;
    private TextView mTvFmLoginBack;
    private TextView mTvLoToRe;
    private TextView mTvLoToMain;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
        Toast.makeText(getActivity(),mParam,Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvFmLoginBack = view.findViewById(R.id.tv_fm_login_back);
        mTvLoToRe = view.findViewById(R.id.tv_login_to_register);
        mTvLoToMain = view.findViewById(R.id.tv_login_to_main);


        mTvFmLoginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        mTvLoToRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragmentDirections.ActionLoginFragmentToRegisterFragment action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment().setREGISTERPARAMS("from login");
                Navigation.findNavController(v).navigate(action);
            }
        });

        mTvLoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("toMain","main");
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
