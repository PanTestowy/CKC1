import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.Key;

public class Game {
	public Game(){
		Screen gameScreen = TerminalFacade.createScreen();
		gameScreen.startScreen();
		Position pos = new Position();
		pos.setX(1);
		pos.setY(1);
		
		gameScreen.putString(pos.getX(), pos.getY(), "X", Terminal.Color.WHITE, Terminal.Color.WHITE);
		gameScreen.putString(0, 0, " ", Terminal.Color.BLACK, Terminal.Color.BLACK);

		gameScreen.refresh();
		boolean keepRunning=true;
		while(keepRunning){
			Key key = gameScreen.readInput();
			while(key==null){
				key=gameScreen.readInput();
			}
			switch(key.getKind()){
			case Escape:
				gameScreen.stopScreen();
				System.exit(0);
				break;
			case ArrowRight:
				gameScreen.putString(pos.getX(), pos.getY(), " ", Terminal.Color.BLACK, Terminal.Color.BLACK);
				pos.setX(pos.getX()+1);
				gameScreen.putString(pos.getX(), pos.getY(), "X", Terminal.Color.WHITE, Terminal.Color.WHITE);
				gameScreen.refresh();
				System.out.println(pos.getX()+" "+pos.getY());
				break;
			case ArrowLeft:
				gameScreen.putString(pos.getX(), pos.getY(), " ", Terminal.Color.BLACK, Terminal.Color.BLACK);
				pos.setX(pos.getX()-1);
				gameScreen.putString(pos.getX(), pos.getY(), "X", Terminal.Color.WHITE, Terminal.Color.WHITE);
				gameScreen.refresh();
				System.out.println(pos.getX()+" "+pos.getY());
				break;
			case ArrowDown:
				gameScreen.putString(pos.getX(), pos.getY(), " ", Terminal.Color.BLACK, Terminal.Color.BLACK);
				pos.setY(pos.getY()+1);
				gameScreen.putString(pos.getX(), pos.getY(), "X", Terminal.Color.WHITE, Terminal.Color.WHITE);
				gameScreen.refresh();
				System.out.println(pos.getX()+" "+pos.getY());
				break;
			case ArrowUp:
				gameScreen.putString(pos.getX(), pos.getY(), " ", Terminal.Color.BLACK, Terminal.Color.BLACK);
				pos.setY(pos.getY()-1);
				gameScreen.putString(pos.getX(), pos.getY(), "X", Terminal.Color.WHITE, Terminal.Color.WHITE);
				gameScreen.refresh();
				System.out.println(pos.getX()+" "+pos.getY());
				break;
			default: continue;
			}
		}
		gameScreen.stopScreen();
	}
}
