package com.demo.jetpack.fragment.welcome;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.jetpack.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

public class WelcomeFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private TextView mTvLogin;
    private TextView mTvRegister;
    private static final String ARG_PARAM = "param";

    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvLogin = view.findViewById(R.id.tv_login);
        mTvRegister = view.findViewById(R.id.tv_register);

        NavOptions.Builder builder = new NavOptions.Builder();
        final NavOptions options = builder.setEnterAnim(R.anim.common_slide_in_right)
                .setExitAnim(R.anim.common_slide_out_left)
                .setPopEnterAnim(R.anim.common_slide_in_left)
                .setPopExitAnim(R.anim.common_slide_out_right)
                .build();


        //利用id导航跳转
        mTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(ARG_PARAM, "login");
                Navigation.findNavController(v).navigate(R.id.loginFragment,bundle,options);
            }
        });

        //利用Safe Args 跳转
        mTvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WelcomeFragmentDirections.ActionWelcomeFragmentToRegisterFragment action = WelcomeFragmentDirections.actionWelcomeFragmentToRegisterFragment().setREGISTERPARAMS("register");
                Navigation.findNavController(v).navigate(action);

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
