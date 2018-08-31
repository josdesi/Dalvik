package mx.com.dalvik;

import mx.com.dalvik.model.dice.IDiceSimulator;
import mx.com.dalvik.model.dice.DiceSimulatorOptimized;
import mx.com.dalvik.model.dice.DiceSimulatorSimple;
import mx.com.dalvik.model.dice.Logger;

public class Test {

	public static void main(String[] args) {
		
		IDiceSimulator dice = new DiceSimulatorOptimized();
		
		dice.showFaces( dice.simulate( 100000 ), new Logger() {

			@Override
			public void print(Integer i, String face) {
				
				System.out.println( "Face( "+(i+1)+" ): " + face);
			}
			
		});

	}

}
