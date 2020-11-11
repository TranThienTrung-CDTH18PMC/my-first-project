package com.example.dangnhap;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DangnhapFragment extends Fragment {
    private EditText gmail, password;
    private TextView tvMassage;
    private Button btnlogin;
    private Button btndangky;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dangnhap, container, false);
        gmail = view.findViewById(R.id.dangnhap_taikhoan);
        password = view.findViewById(R.id.dangnhap_matkhau);
        btnlogin = view.findViewById(R.id.btn_login);
        tvMassage = view.findViewById(R.id.tv_message);
        btndangky = view.findViewById(R.id.dangnhap_dangky);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }

        });
        return view;
    }

    private void clickLogin() {
        String a = "trungtran@gmail.com";
        String b = "123456";
        String mEmail = gmail.getText().toString().trim();
        String mpassword = password.getText().toString().trim();
        User user = new User(mEmail, mpassword);
        tvMassage.setVisibility(View.VISIBLE);
        if (user.isValidPassword() && user.isValidEmail()) {
            if (mEmail.equals(a) && mpassword.equals(b)) {
                Intent intent = new Intent(getActivity(), Trangcanhan.class);
                startActivity(intent);
            }

        }
    }
}