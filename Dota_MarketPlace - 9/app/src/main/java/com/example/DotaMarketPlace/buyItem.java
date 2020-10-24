package com.example.DotaMarketPlace;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.DotaMarketPlace.R;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class buyItem extends AppCompatActivity implements Serializable {

    TextView  title , stock , price , stockV , priceV , totalV;
    ImageView imageView;
    Button btn , btn2 , btn3;

    //btn2 > buy
    //btn3 > show

    EditText bQty;

    int position;
    String hasil ;
    int jAngka  , totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyitem);

        //    ActionBar actionBar = getSupportActionBar();

//         if( actionBar != null ){
//
//             this.getActionBar().setDisplayHomeAsUpEnabled(true);
//             this.getActionBar().setDisplayShowHomeEnabled(true);
//             // Also set in manifest
//         }

        imageView = findViewById(R.id.another_imageView);

        title = (TextView) findViewById(R.id.titleText);
        stock = (TextView)  findViewById(R.id.stockText);
        price = (TextView)  findViewById(R.id.priceText);

        stockV = (TextView)  findViewById(R.id.stockValue);
        priceV = (TextView) findViewById(R.id.priceValue);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~     Position 0   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        if (position == 0){

            Intent myIntent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");

            //Get Stock Value
            // ~ Integer
            int vStock = myIntent.getIntExtra("stock0" , 0 );
            int vDoet = myIntent.getIntExtra("balance" , 0 );
            int vUser = myIntent.getIntExtra("userBalance" , 0);

            // ~ String
            String aTitle = myIntent.getStringExtra("title");
            String aStock = myIntent.getStringExtra("stock");
            String aPrice = myIntent.getStringExtra("price");

            imageView.setImageResource(pic);

            title.setText(aTitle);
            stockV.setText(aStock);
            priceV.setText(aPrice);
/*
            Cara dari get TextView value type int untuk set ke TextView. setText

                     stockV.setText(String.valueOf(aStock));
                     priceV.setText(String.valueOf(aDoet));
*/

            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    Button Position 0   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            bQty = (EditText) findViewById(R.id.txtQty);
            totalV = (TextView) findViewById(R.id.TotalValue);

            btn3 = (Button) findViewById(R.id.btnShow);
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText( buyItem.this , " Show Location Seller Pressed " , Toast.LENGTH_SHORT).show();

                    Intent intenn = new Intent( v.getContext() , SellerLocation.class);
                    startActivity(intenn);

                }
            });

            btn = (Button) findViewById(R.id.btnTotalPrice);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if(TextUtils.isEmpty(bQty.getText().toString())){

                        bQty.setError(" Quantity must be filled");
                        bQty.requestFocus();

                    } else {

                        hasil = bQty.getText().toString();
                        jAngka = Integer.parseInt(hasil);

                        if( jAngka > vStock) {

                            bQty.setError(" Not enough stock");
                            bQty.requestFocus();

                        }  else {

                            totalPrice = jAngka * vDoet;
                            totalV.setText(String.valueOf(totalPrice));

                        }

                    }

                    btn2 = (Button) findViewById(R.id.btnBeli);
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            // Jika UserBalance Lebih kecik dari totalPrice
                            if( vUser < totalPrice ){

                                bQty.setError(" Unable to process payment: Low card balance ");
                                bQty.requestFocus();

                            } else {

                                Toast.makeText( buyItem.this , " Buy Item Success" , Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(buyItem.this, MenuForm.class);
                                startActivity(intent);
                                finish();

                            }

                        }
                    }); // Close button Buy

                }
            }); // Close btn totalPrice

        }

        //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Position  1   ~~~~~~~~~~~~~~~~~~~~~~~~

        if (position == 1){

            Intent myIntent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");

            //Get Stock Value
            // ~ Integer
            int vStock = myIntent.getIntExtra("stock0" , 0 );
            int vDoet = myIntent.getIntExtra("balance" , 0 );
            int vUser = myIntent.getIntExtra("userBalance" , 0);

            // ~ String
            String aTitle = myIntent.getStringExtra("title");
            String aStock = myIntent.getStringExtra("stock");
            String aPrice = myIntent.getStringExtra("price");

            imageView.setImageResource(pic);

            title.setText(aTitle);
            stockV.setText(String.valueOf(aStock));
            priceV.setText(String.valueOf(aPrice));

            //    actionBar.setTitle(aTitle);

            //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~   Position Button  1     ~~~~~~~~~~~~~~~~~~~

            btn = (Button) findViewById(R.id.btnTotalPrice);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if(TextUtils.isEmpty(bQty.getText().toString())){

                        bQty.setError(" Quantity must be filled");
                        bQty.requestFocus();

                    } else {

                        hasil = bQty.getText().toString();
                        jAngka = Integer.parseInt(hasil);

                        if( jAngka > vStock) {

                            bQty.setError(" Not enough stock");
                            bQty.requestFocus();

                        }  else {

                            totalPrice = jAngka * vDoet;
                            totalV.setText(String.valueOf(totalPrice));

                        }

                    }

                    btn2 = (Button) findViewById(R.id.btnBeli);
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            // Jika UserBalance Lebih kecik dari totalPrice
                            if( vUser < totalPrice ){

                                bQty.setError(" Unable to process payment: Low card balance ");
                                bQty.requestFocus();

                            } else {

                                Toast.makeText( buyItem.this , " Buy Item Success" , Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(buyItem.this, MenuForm.class);
                                startActivity(intent);
                                finish();

                            }

                        }
                    }); // Close button Buy

                }
            }); // Close btn totalPrice

        }

        //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Position  2   ~~~~~~~~~~~~~~~~~~~~~~~~

        if (position == 2){

            Intent myIntent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");

            //Get Stock Value
            // ~ Integer
            int vStock = myIntent.getIntExtra("stock0" , 0 );
            int vDoet = myIntent.getIntExtra("balance" , 0 );
            int vUser = myIntent.getIntExtra("userBalance" , 0);

            // ~ String
            String aTitle = myIntent.getStringExtra("title");
            String aStock = myIntent.getStringExtra("stock");
            String aPrice = myIntent.getStringExtra("price");

            imageView.setImageResource(pic);

            title.setText(aTitle);
            stockV.setText(String.valueOf(aStock));
            priceV.setText(String.valueOf(aPrice));

            //    actionBar.setTitle(aTitle);

            //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~   Position BUtton  2     ~~~~~~~~~~~~~~~~~~~

            btn = (Button) findViewById(R.id.btnTotalPrice);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if(TextUtils.isEmpty(bQty.getText().toString())){

                        bQty.setError(" Quantity must be filled");
                        bQty.requestFocus();

                    } else {

                        hasil = bQty.getText().toString();
                        jAngka = Integer.parseInt(hasil);

                        if( jAngka > vStock) {

                            bQty.setError(" Not enough stock");
                            bQty.requestFocus();

                        }  else {

                            totalPrice = jAngka * vDoet;
                            totalV.setText(String.valueOf(totalPrice));

                        }

                    }

                    btn2 = (Button) findViewById(R.id.btnBeli);
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            // Jika UserBalance Lebih kecik dari totalPrice
                            if( vUser < totalPrice ){

                                bQty.setError(" Unable to process payment: Low card balance ");
                                bQty.requestFocus();

                            } else {

                                Toast.makeText( buyItem.this , " Buy Item Success" , Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(buyItem.this, MenuForm.class);
                                startActivity(intent);
                                finish();

                            }

                        }
                    }); // Close button Buy

                }
            }); // Close btn totalPrice

        }

        //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Position  3  ~~~~~~~~~~~~~~~~~~~~~~~~

        if (position == 3){

            Intent myIntent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");

            //Get Stock Value
            // ~ Integer
            int vStock = myIntent.getIntExtra("stock0" , 0 );
            int vDoet = myIntent.getIntExtra("balance" , 0 );
            int vUser = myIntent.getIntExtra("userBalance" , 0);

            // ~ String
            String aTitle = myIntent.getStringExtra("title");
            String aStock = myIntent.getStringExtra("stock");
            String aPrice = myIntent.getStringExtra("price");

            imageView.setImageResource(pic);

            title.setText(aTitle);
            stockV.setText(aStock);
            priceV.setText(aPrice);

            // actionBar.setTitle(aTitle);

            //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~   Position BUtton  3     ~~~~~~~~~~~~~~~~~~~

            btn = (Button) findViewById(R.id.btnTotalPrice);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if(TextUtils.isEmpty(bQty.getText().toString())){

                        bQty.setError(" Quantity must be filled");
                        bQty.requestFocus();

                    } else {

                        hasil = bQty.getText().toString();
                        jAngka = Integer.parseInt(hasil);

                        if( jAngka > vStock) {

                            bQty.setError(" Not enough stock");
                            bQty.requestFocus();

                        }  else {

                            totalPrice = jAngka * vDoet;
                            totalV.setText(String.valueOf(totalPrice));

                        }

                    }

                    btn2 = (Button) findViewById(R.id.btnBeli);
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            // Jika UserBalance Lebih kecik dari totalPrice
                            if( vUser < totalPrice ){

                                bQty.setError(" Unable to process payment: Low card balance ");
                                bQty.requestFocus();

                            } else {

                                Toast.makeText( buyItem.this , " Buy Item Success" , Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(buyItem.this, MenuForm.class);
                                startActivity(intent);
                                finish();

                            }

                        }
                    }); // Close button Buy

                }
            }); // Close btn totalPrice

        }

        //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Position  4   ~~~~~~~~~~~~~~~~~~~~~~~~

        if (position == 4){

            Intent myIntent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");

            //Get Stock Value
            // ~ Integer
            int vStock = myIntent.getIntExtra("stock0" , 0 );
            int vDoet = myIntent.getIntExtra("balance" , 0 );
            int vUser = myIntent.getIntExtra("userBalance" , 0);

            // ~ String
            String aTitle = myIntent.getStringExtra("title");
            String aStock = myIntent.getStringExtra("stock");
            String aPrice = myIntent.getStringExtra("price");

            imageView.setImageResource(pic);

            title.setText(aTitle);
            stockV.setText(aStock);
            priceV.setText(aPrice);

            //   actionBar.setTitle(aTitle);

            //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~   Position BUtton  4     ~~~~~~~~~~~~~~~~~~~

            btn = (Button) findViewById(R.id.btnTotalPrice);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if(TextUtils.isEmpty(bQty.getText().toString())){

                        bQty.setError(" Quantity must be filled");
                        bQty.requestFocus();

                    } else {

                        hasil = bQty.getText().toString();
                        jAngka = Integer.parseInt(hasil);

                        if( jAngka > vStock) {

                            bQty.setError(" Not enough stock");
                            bQty.requestFocus();

                        }  else {

                            totalPrice = jAngka * vDoet;
                            totalV.setText(String.valueOf(totalPrice));

                        }

                    }

                    btn2 = (Button) findViewById(R.id.btnBeli);
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            // Jika UserBalance Lebih kecik dari totalPrice
                            if( vUser < totalPrice ){

                                bQty.setError(" Unable to process payment: Low card balance ");
                                bQty.requestFocus();

                            } else {

                                Toast.makeText( buyItem.this , " Buy Item Success" , Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(buyItem.this, MenuForm.class);
                                startActivity(intent);
                                finish();

                            }

                        }
                    }); // Close button Buy

                }
            }); // Close btn totalPrice

        } // CLose if position 4

    }// Close onCreate
}// CLose class
