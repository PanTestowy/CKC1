import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Screen screen = TerminalFacade.createScreen();
		screen.startScreen();
		screen.putString(10, 5, "Dobry wieczór, coœ siê... coœ siê popsu³o i nie by³o mnie s³ychaæ...", Terminal.Color.CYAN, Terminal.Color.BLACK);
		screen.refresh();
		
		StringBuilder sb = new StringBuilder();
		
		boolean keepRunning = true;
		while(keepRunning){
			Key key = screen.readInput();
			while(key == null){
				key = screen.readInput();
			}
			
			System.out.println("Key pressed: " + key.getKind().toString());
			
			switch(key.getKind()){
			case Escape:
				screen.stopScreen();
				System.exit(0);
				break;
			case ArrowDown:
				screen.putString(20, 7, "Szerokoœæ: "+screen.getTerminalSize().getColumns(), Terminal.Color.WHITE, Terminal.Color.BLACK);
				screen.putString(20, 8, "Wysokoœæ: "+screen.getTerminalSize().getRows(), Terminal.Color.WHITE, Terminal.Color.BLACK);
				screen.refresh();
				break;
			case NormalKey:
				sb.append(key.getCharacter());
				System.out.println(key.getCharacter());
				break;
			case Enter:
				screen.clear();
				screen.putString(20, 10, sb.toString(), Terminal.Color.WHITE, Terminal.Color.BLACK);
				System.out.println(sb.toString());
				screen.refresh();
				break;
			case ArrowUp:
				for(int i=20; i<80; i++){
					screen.putString(i, 25, "x", Terminal.Color.WHITE, Terminal.Color.WHITE);
					Thread.sleep(100);
					screen.refresh();
				}
				break;
			default: continue;
			}			
		}
	}
}
