package mx.com.dalvik;

public class UI {
	
	// Asociaciones fuertemente acopladas
	LogMessage logMessage;
	
	public void init() {
		
		// instancia de la asociaci�n fuertemente acoplada
		this.logMessage = new LogMessage();
		
		// Asociaciones d�bilmente acopladas
		LogMessage logMessage = new LogMessage();
		
		Screen screen = new ScreenT1();
		Screen _screen = new ScreenT2();
	}
}

class LogMessage {
	
}

interface Screen {
	
}

class ScreenT1 implements Screen {
	//... A
}

class ScreenT2 implements Screen {
	// ... B
}

