import processing.core.PApplet;

public class Display {
	private PApplet parent;
	private Button[] buttons;
	private boolean debug;
	private int clickedIndex;

	public Display(PApplet p) {
		this.parent = p;
		debug = true;
		buttons = new Button[1];
		
		buttons[0] = new Button("Test", "this is a test button", 550, 100, 30);
	}

	public void drawScreen(Engine e) {
		if (debug) {
			parent.fill(255);
			parent.textAlign(parent.LEFT);
			parent.text("DEBUG", 5, 10);
			parent.text("timeSpeed: " + e.getTimeSpeed() + " projectiles: "
					+ e.getProjectiles().size(), 5, 20);
		}
		for (Button b : buttons) {
			b.display(parent);
		}
		for (Projectile p : e.getProjectiles()) {
			if (debug) {
				parent.fill(255);
				parent.text(p.toString(), p.getX() - p.getRadius(), p.getY()
						- p.getRadius());
			}
			parent.ellipse(p.getX(), p.getY(), p.getRadius(), p.getRadius());
		}
	}
	
	public Button[] getButtons() {
		return buttons;
	}

	public void switchDebug() {
		debug = !debug;
	}

}
