package dalvik.com.mx.dicesimulator;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mx.com.dalvik.model.dice.DiceSimulator;
import mx.com.dalvik.model.dice.DiceSimulatorOptimized;
import mx.com.dalvik.model.dice.DiceSimulatorSimple;
import mx.com.dalvik.model.dice.IDiceSimulator;
import mx.com.dalvik.model.dice.Logger;

public class MainActivity extends AppCompatActivity {

    private Button btnSimulate;
    private TextView txtRolls;
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRolls = findViewById( R.id.txtRolls );
        btnSimulate = findViewById( R.id.btnSimulate );


        btnSimulate.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick( View v ){
                String rolls = txtRolls.getText().toString();

                if( rolls.equals("") ) return;

                IDiceSimulator dice = new DiceSimulatorOptimized();

                Log.i("Dalvik", "Starting the simulation ... ");
                int [] faces = dice.simulate( Integer.valueOf( rolls ) );

                dice.showFaces( faces, new Logger(){

                    TextView txtMultiple = findViewById( R.id.txtMultiple );
                    String str = "";
                    StringBuilder sb = new StringBuilder();

                    @Override
                    public void print(Integer i, String face ) {

//                        str += "Face "+(i+1)+": " + face +"\n";
                        sb.append( "Face "+(i+1)+": " + face +"\n" );

                        Log.i("Dalvik", "Face( "+(i+1)+" ): " + face );

//                        txtMultiple.setText( str );
                        txtMultiple.setText( sb );

                    }
                });

                AlertDialog.Builder alert  = new AlertDialog.Builder( context );
                alert
                        .setTitle("Notification")
                        .setMessage("Finished simulation")
                        .setCancelable( false )
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which ) {
                                dialog.cancel();
                            }
                        })
                        .create()
                        .show();
            }
        });
    }
}
