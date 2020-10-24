package com.example.DotaMarketPlace;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class  topUpForm extends AppCompatActivity {

    ImageView btnImg;
    View rLayout;

    EditText aa, aPassword;
    Button bBuy;

    int uBalance , doet;
    TextView value;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topupform);

        Intent myIntent = getIntent();
        uBalance = myIntent.getIntExtra("userDefault", 0);
            value = (TextView) findViewById(R.id.txtTValue);
                value.setText(String.valueOf(uBalance));

        rLayout = (View) findViewById(R.id.hilang);
        btnImg = (ImageView) findViewById(R.id.btnTplus);

        bBuy = (Button) findViewById(R.id.btnBeli);
        aa = (EditText) findViewById(R.id.txtAmountValue);
        aPassword = (EditText) findViewById(R.id.txtTpassword);

        String passw = aPassword.getText().toString();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   Start  Button Plus ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   /*     btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rLayout.setVisibility(View.VISIBLE);

            }
        }); */

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ End Button PLus ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

      //  if( rLayout.getVisibility() == View.VISIBLE ){

            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   Start  Button BUY ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            bBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText( topUpForm.this , " Buy button has been Click " , Toast.LENGTH_SHORT).show();

                    // Ini punya AmountBalance
                    String bb = aa.getText().toString();


                    if (TextUtils.isEmpty(bb)) {

                        aa.setError("Amount of balance must be filled");
                        aa.requestFocus();

                    } else {

                        int amount = Integer.parseInt(bb);

                        if (amount < 50000) {

                            aa.setError(" Amount balance must be more than equals 50000");
                            aa.requestFocus();

                        } else if (TextUtils.isEmpty(aPassword.getText())) {

                            aPassword.setError("Password must be filled");
                            aPassword.requestFocus();

                        } else if( cekTop() == false ){

                            aPassword.setError("Password Do not match");
                            aPassword.requestFocus();

                        }else {

                            doet = uBalance + amount;
                            Toast.makeText(topUpForm.this, " Done  Top Up Success : " + doet, Toast.LENGTH_SHORT).show();

                            Balance.setUbalance(doet);

                            Intent wew = new Intent(topUpForm.this , MenuForm.class);
                            startActivity(wew);
                            finish();

                        }
                    }


                } //Close onClick
            });


    }

    public boolean cekTop(){

        String tPass = User.getPassword();

        if(TextUtils.isEmpty(tPass)){

            Toast.makeText(topUpForm.this, " getPassword is Empty Value : " + tPass, Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(topUpForm.this, " getPassword has a Value : " + tPass, Toast.LENGTH_SHORT).show();

            if(!aPassword.equals(tPass)){
                return false;
            }

        }
         return true;
    }

}
