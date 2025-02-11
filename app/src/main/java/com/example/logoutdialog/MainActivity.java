package com.example.logoutdialog;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnAlert,btnTimePicker,btnDatePicker,btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();

    }
    private void initView(){
        btnAlert=findViewById(R.id.btnAlert);
        btnTimePicker=findViewById(R.id.btnTimePicker);
        btnDatePicker=findViewById(R.id.btnDatePicker);
        btnLog=findViewById(R.id.btnLog);
    }
    private void initListener(){
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exam Form Submission");
                builder.setMessage("Are you sure you want to submit ?");
                builder.setIcon(R.drawable.ic_launcher_foreground);
                builder.setPositiveButton("Yes",new AlertDialogButtonAll());
                builder.setNegativeButton("No",new AlertDialogButtonAll());

                builder.setNeutralButton("Okey",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Neutral Click "+ which,Toast.LENGTH_LONG).show();

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this,new TimePickerDialogBtn(),11,34,true);
                timePickerDialog.show();
            }
        });
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this,new DatePickerDialogBtn(),2024,8,11);
                datePickerDialog.show();


            }
        });
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogoutDialog logoutDialog=new LogoutDialog(MainActivity.this);
                logoutDialog.setOnLogoutDialogClick(new LogoutDialogClickListener());
                logoutDialog.show();
            }
        });
    }
    class LogoutDialogClickListener implements LogoutDialog.OnLogoutDialogClick{

        @Override
        public void OnSuccess() {
            Log.e("tag","on Success");

        }

        @Override
        public void OnFailure() {
            Log.e("tag","on Failure");

        }
    }

    class TimePickerDialogBtn implements TimePickerDialog.OnTimeSetListener{

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(MainActivity.this,"Time Dialog Click" + view +" "+hourOfDay+" "+minute+" ",Toast.LENGTH_LONG).show();
        }
    }
    class DatePickerDialogBtn implements DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        }
    }

    class AlertDialogButtonAll implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which==-1){
                Toast.makeText(MainActivity.this,"Positive Button Click "+which,Toast.LENGTH_LONG).show();
            } else if (which==-2) {
                Toast.makeText(MainActivity.this,"Negative Button Click "+which,Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText(MainActivity.this,"Neutral Button Click "+which,Toast.LENGTH_LONG).show();
            }

        }
    }
    class PositiveButton implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this,"Positive click "+ which,Toast.LENGTH_LONG).show();
        }
    }
    class NegetiveButton implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this,"Negetive click "+ which,Toast.LENGTH_LONG).show();
        }
    }
    class NeutralButton implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this,"Neutral click "+ which,Toast.LENGTH_LONG).show();
        }
    }
}