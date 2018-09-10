package dalvik.com.mx.shopcart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SplashScreen extends AppCompatActivity {

    private static  final String TAG = "SplashScreen";
    private static final int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d( TAG, "run: Start app main activity ... ");
                Intent intent = new Intent( SplashScreen.this, MainActivity.class  );
                startActivity( intent );

                finish();
            }
        }, SPLASH_TIME_OUT );
    }
}
