import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.Component.Alignment;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Table;
import com.googlecode.lanterna.gui.component.Panel.Orientation;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.gui.layout.VerticalLayout;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		final GUIScreen screen = TerminalFacade.createGUIScreen();
		final Window window = new Window("Menu g³ówne");
		//System.out.println(window.getBorder());
		window.setWindowSizeOverride(new TerminalSize(20, 10));
		window.setSoloWindow(true);

		//Panel panelHolder = new Panel("", Orientation.VERTICAL);
		//panelHolder.setPreferredSize(new TerminalSize(40, 10));

		Panel panel = new Panel();

		panel.setLayoutManager(new VerticalLayout());
		Button graj = new Button("Graj", new Action(){
			public void doAction() {
				window.close();
				screen.getScreen().stopScreen();
				new Game();
			}
			
		});
		graj.setAlignment(Component.Alignment.CENTER);
		panel.addComponent(graj, LinearLayout.GROWS_HORIZONTALLY);
		
		Button sterowanie = new Button("Sterowanie");
		sterowanie.setAlignment(Component.Alignment.CENTER);
		panel.addComponent(sterowanie, LinearLayout.GROWS_HORIZONTALLY);
		
		Button wyjœcie = new Button("Wyjœcie", new Action(){
			public void doAction(){
				window.close();
			}
		});
		wyjœcie.setAlignment(Component.Alignment.CENTER);
		panel.addComponent(wyjœcie, LinearLayout.GROWS_HORIZONTALLY);

		//panelHolder.addComponent(panel);

		window.addComponent(panel);
		
		//window.addComponent(new EmptySpace());

		//final Window newWindow = new Window("This window should be of the same size as the previous one");

		/*Button quitButton = new Button("Show next window", new Action() {

			public void doAction() {

				newWindow.setWindowSizeOverride(new TerminalSize(130, 50));
				newWindow.setSoloWindow(true);

				Button exitBtn = new Button("Exit", new Action() {

					public void doAction() {
						// TODO Auto-generated method stub
						newWindow.close();
						window.close();
					}
				});

				exitBtn.setAlignment(Alignment.RIGHT_CENTER);

				newWindow.addComponent(exitBtn, LinearLayout.GROWS_HORIZONTALLY);

				guiScreen.showWindow(newWindow);
			}
		});
		quitButton.setAlignment(Component.Alignment.RIGHT_CENTER);
		window.addComponent(quitButton, LinearLayout.GROWS_HORIZONTALLY);*/

		screen.getScreen().startScreen();
		//screen.refresh();
		//Thread.sleep(1000);
		screen.showWindow(window);
		screen.getScreen().refresh();
		screen.getScreen().stopScreen();
		
		
		
		
		
		
		
		/*Screen screen = TerminalFacade.createScreen();
		int licznik=0;
		screen.startScreen();
		screen.putString(10, 5, "Graj", Terminal.Color.CYAN, Terminal.Color.BLACK);
		screen.putString(33, 1, "sss", Terminal.Color.CYAN, Terminal.Color.BLACK);
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
			case ArrowRight:
				
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
		}*/
	}
}
