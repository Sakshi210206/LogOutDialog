package com.example.logoutdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {
    Button btnLogoutDialog,btnLogoutDialog2,btnLogoutDialog3,btnYes,btnNo;
    TextView text1,text2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initview();
        initLinstener();
    }
    private  void initview(){
        btnLogoutDialog=findViewById(R.id.btnLogoutDialog);
        btnLogoutDialog2=findViewById(R.id.btnLogoutDialog2);
        btnLogoutDialog3=findViewById(R.id.btnLogoutDialog3);
    }
    private void initLinstener(){
        btnLogoutDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(SecondActivity.this);
                dialog.setTitle("Logout Dialog");
                dialog.setContentView(R.layout.logout_dialog);
                text1=dialog.findViewById(R.id.text1);
                text2=dialog.findViewById(R.id.text2);
                btnYes=dialog.findViewById(R.id.btnYes);
                btnNo=dialog.findViewById(R.id.btnNo);
                dialog.show();
            }
        });
        btnLogoutDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogoutDialog logoutDialog=new LogoutDialog(SecondActivity.this);
                logoutDialog.show();
            }
        });
        btnLogoutDialog3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                LogoutDialog logoutDialog1=new LogoutDialog(SecondActivity.this);
                logoutDialog1.setOnLogoutDialogClick(new MyLogoutDialogClick());
                logoutDialog1.show();


            }
        });
    }
    class MyLogoutDialogClick implements LogoutDialog.OnLogoutDialogClick{

        @Override
        public void OnSuccess() {
            Toast.makeText(SecondActivity.this,"On Success",Toast.LENGTH_LONG).show();
        }

        @Override
        public void OnFailure() {
            Toast.makeText(SecondActivity.this,"On failure",Toast.LENGTH_LONG).show();

        }
    }
}