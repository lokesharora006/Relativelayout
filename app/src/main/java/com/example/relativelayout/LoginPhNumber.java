package com.example.drinkit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class LoginPhNumber extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    EditText phoneNumber;
    Button sendOtp;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ph_number);

        countryCodePicker=findViewById(R.id.login_countrycode);
        sendOtp = findViewById(R.id.send_otp_btn);
        progressBar =findViewById(R.id.login_progress_bar);
        phoneNumber=findViewById(R.id.login_mobile_number);
        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(phoneNumber);
        sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (!countryCodePicker.isValidFullNumber()){
                    phoneNumber.setError("Phone number not valid");
                    return;
                }

                Intent intent=new Intent(LoginPhNumber.this,OTP_Page.class);
                intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
                startActivity(intent);
            }
        });
    }
}