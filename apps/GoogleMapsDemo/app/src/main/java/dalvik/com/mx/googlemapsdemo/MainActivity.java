package dalvik.com.mx.googlemapsdemo;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if( isServiceOk() ){
            Toast.makeText( this, "Map Service OK", Toast.LENGTH_SHORT).show();
            init();
        }

    }

    private void init() {
        Button btnMap = findViewById( R.id.btnMap );

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, MapActivity.class );
                startActivity( intent );
            }
        });
    }

    private boolean isServiceOk() {
        // Verifica la disponibilidad del servicio de Google Maps
        Log.d( TAG, "isServiceOk: checking google services version ... ");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable( MainActivity.this );

        if( available == ConnectionResult.SUCCESS ){
            // Servicio disponible
            Log.d( TAG, "isServiceOk: SUCCESS ... ");
            return true;
        }
        else if( GoogleApiAvailability.getInstance().isUserResolvableError( available )){
            // Error en el servicio
            Log.d( TAG, "isServiceOk: ERROR ... ");
            Dialog dialog = GoogleApiAvailability
                    .getInstance()
                    .getErrorDialog(this, available, ERROR_DIALOG_REQUEST );
            dialog.show();
        }
        else
            Toast.makeText( this, "No ...", Toast.LENGTH_SHORT).show();
        return false;
    }
}
