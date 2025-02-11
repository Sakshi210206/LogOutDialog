package com.example.logoutdialog;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class LogoutDialog extends Dialog {
    TextView text1,text2;
    Button btnYes,btnNo;

    interface OnLogoutDialogClick{
        void OnSuccess();
        void OnFailure();
    }
    private OnLogoutDialogClick onLogoutDialogClick;
    public void setOnLogoutDialogClick(OnLogoutDialogClick onLogoutDialogClick){
        this.onLogoutDialogClick=onLogoutDialogClick;
    }

    public LogoutDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.logout_dialog);
        initView();
        initListener();
    }
    private  void initView(){
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        btnYes=findViewById(R.id.btnYes);
        btnNo=findViewById(R.id.btnNo);

    }
    private  void initListener(){
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutDialogClick.OnSuccess();
//                Log.e("tag","Yes Click");
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutDialogClick.OnFailure();
//                Log.e("tag","No Click");
            }
        });
    }
}