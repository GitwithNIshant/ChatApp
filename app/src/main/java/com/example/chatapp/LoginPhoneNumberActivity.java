package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class LoginPhoneNumberActivity extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    EditText phoneInput;
    Button sendOtpBtn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone_number);

        countryCodePicker = findViewById(R.id.login_countrycode);
        phoneInput = findViewById(R.id.login_mobile_number);
        sendOtpBtn = findViewById(R.id.sent_otp_btn);
        progressBar = findViewById(R.id.login_progress_bar);
        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(phoneInput);

        sendOtpBtn.setOnClickListener((v) -> {
            if (!countryCodePicker.isValidFullNumber()) {
                phoneInput.setError("Phone number is not valid");
                return;
            }

            // Get the full phone number with the country code
            String fullPhoneNumber = countryCodePicker.getFullNumberWithPlus();

            // Replace the leading '0' with the country code
            String countryCode = countryCodePicker.getSelectedCountryCodeWithPlus();
            String formattedPhoneNumber = fullPhoneNumber.replaceFirst("91", countryCode);

            // Start the LoginOtpActivity with the formatted phone number
            Intent intent = new Intent(LoginPhoneNumberActivity.this, LoginOtpActivity.class);
            intent.putExtra("phone", formattedPhoneNumber);
            startActivity(intent);
        });


    }
}