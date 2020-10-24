package com.example.DotaMarketPlace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import java.io.Serializable;

public class SellerLocation extends Activity implements Serializable {

    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellerlocation);

        imgBack = (ImageView) findViewById(R.id.btnBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                 * Saya return ke menuForm karena jika ke BuyItem ada beberapa "variabel" dengan value yang dikirim dengan "intent"
                 * dari MenuForm
                 * */
                Intent intent = new Intent(SellerLocation.this ,  MenuForm.class);
                startActivity(intent);

            }
        });

    }

}
