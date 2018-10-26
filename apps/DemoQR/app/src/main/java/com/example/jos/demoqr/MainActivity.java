package com.example.jos.demoqr;

import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import android.net.Uri;





import java.math.BigDecimal;



import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;



import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;


public class MainActivity extends AppCompatActivity {

    public final static int QR_CODE_WIDTH = 500;
    public final static String IMAGE_DIRECTORY = "/QRcodeDemo";
    Bitmap bitmap;
    private EditText etqr;
    private ImageView iv;
    private Button btn;



    private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;

    private static final String CONFIG_CLIENT_ID = "ARkXR76O8bo3bONR1xHBJJJo1imebC9k1wXxGIj0BULQbqy1KD96EBUyw1sAh1AojtuV2B9V5ZIhkScg";
    private static final int REQUEST_CODE_PAYMENT = 1;





    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(CONFIG_ENVIRONMENT)
            .clientId(CONFIG_CLIENT_ID)

            // configuracion minima del ente
            .merchantName("Mi tienda")
            .merchantPrivacyPolicyUri(
                    Uri.parse("https://www.mi_tienda.com/privacy"))
            .merchantUserAgreementUri(
                    Uri.parse("https://www.mi_tienda.com/legal"));

    PayPalPayment thingToBuy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);
        findViewById(R.id.order).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                thingToBuy = new PayPalPayment(new BigDecimal("50"), "MXN",
                        "pelicula", PayPalPayment.PAYMENT_INTENT_SALE);
                Intent intent = new Intent(MainActivity.this,
                        PaymentActivity.class);

                intent.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy);

                startActivityForResult(intent, REQUEST_CODE_PAYMENT);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {
            PaymentConfirmation confirm = data
                    .getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
            if (confirm != null) {
                try {

                    // informacion extra del pedido
                    System.out.println(confirm.toJSONObject().toString(4));
                    System.out.println(confirm.getPayment().toJSONObject()
                            .toString(4));

                    Toast.makeText(getApplicationContext(), "Orden procesada",
                            Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            System.out.println("El usuario canceló el pago");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }









    private String saveImage(Bitmap bitmap) {

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress( Bitmap.CompressFormat.JPEG, 90, bytes );
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY
        );

        if( !wallpaperDirectory.exists() ){
            wallpaperDirectory.mkdirs();
        }

        try{
            File f = new File( wallpaperDirectory, Calendar.getInstance().getTimeInMillis()+".jpg");
            f.createNewFile();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write( bytes.toByteArray() );

            MediaScannerConnection.scanFile(this,
                    new String[]{ f.getPath()},
                    new String[]{"image/jpeg"},
                    null);
            fos.close();
            return f.getAbsolutePath();
        }
        catch( IOException e ){
            e.printStackTrace();
        }


        return "";
    }

    private Bitmap TextToImageEncode(String value ) throws WriterException {
        BitMatrix bitMatrix = null;

        try {
            bitMatrix = new MultiFormatWriter().encode(
                    value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QR_CODE_WIDTH,
                    QR_CODE_WIDTH,
                    null
            );
        }
        catch( IllegalArgumentException e ){
            e.printStackTrace();
        }

        int bitMatrixWidth = bitMatrix.getWidth();
        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[ bitMatrixWidth * bitMatrixHeight ];

        for( int y = 0; y < bitMatrixHeight; y++ ){
            int offset = y * bitMatrixWidth;
            for( int x = 0; x < bitMatrixWidth; x++ ){
                pixels[ offset + x ] = bitMatrix.get(x,y)?
                        getResources().getColor( R.color.black ):
                        getResources().getColor( R.color.white )
                ;
            }
        }


        Bitmap bitmap = Bitmap.createBitmap( bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444 );
        bitmap.setPixels(pixels,0,500,0,0,bitMatrixWidth,bitMatrixHeight );
        return bitmap;
    }
}
