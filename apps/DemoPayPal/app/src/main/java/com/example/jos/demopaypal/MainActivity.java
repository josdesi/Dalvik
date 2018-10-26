package com.example.jos.demopaypal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;
    private static final String CONFIG_CLIENT_ID = "AVzac_j_KSSv-F21hzGNxftuvWAMAxP2XXyjdbJaT98NrxjeB8cRcxK4pIkqFAGjUCLoYH9rllHlphMG";
    private static final int REQUEST_CODE_PAYMENT = 1;
    private PayPalConfiguration config = new PayPalConfiguration()
            .environment( CONFIG_ENVIRONMENT )
            .clientId( CONFIG_CLIENT_ID )
            .merchantName("Tienda")
            .merchantPrivacyPolicyUri(
                    Uri.parse("https://www.tienda.com/privacy"))
            .merchantUserAgreementUri(
                    Uri.parse("https://www.tienda.com/legacy")
            );
    PayPalPayment thingToBy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent( this, PayPalService.class );
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService( intent );
        findViewById(R.id.btnOrder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thingToBy = new PayPalPayment( new BigDecimal("50"), "MXN",
                        "movie", PayPalPayment.PAYMENT_INTENT_SALE);

                Intent intent = new Intent( MainActivity.this, PaymentActivity.class );
                intent.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBy );
                startActivityForResult( intent, REQUEST_CODE_PAYMENT );
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data ){
        if( resultCode == Activity.RESULT_OK ){
            PaymentConfirmation confirm = data.getParcelableExtra( PaymentActivity.EXTRA_RESULT_CONFIRMATION);
            if( confirm != null ){
                try {
                    Log.d( TAG, "Confirm: "+ confirm.toJSONObject().toString(4) );
                    Log.d( TAG, "Confirm: "+ confirm.getPayment().toJSONObject().toString(4) );
                    Toast.makeText( getApplicationContext(), "Orden procesada", Toast.LENGTH_LONG).show();
                }
                catch (JSONException e ){
                    e.printStackTrace();
                }
            }
        }
        else if( resultCode == Activity.RESULT_CANCELED ){
            Log.d( TAG, "Usuario canceló la compra");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
