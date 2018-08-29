package dalvik.com.mx.dicesimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mx.com.dalvik.model.DiceSimulator;

public class MainActivity extends AppCompatActivity {

    private Button btnSimulate;
    private TextView txtRolls;

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

                DiceSimulator dice = new DiceSimulator();

                Log.i("Dalvik", "Starting the simulation ... ");
                int [] faces = dice.simulate( Integer.valueOf( rolls ) );

                dice.showFaces( faces, new DiceSimulator.Logger(){

                    @Override
                    public void print(Integer i, String face ) {
                        Log.i("Dalvik", "Face( "+(i+1)+" ): " + face );
                    }
                });
            }
        });
    }
}
