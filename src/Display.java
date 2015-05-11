import processing.core.PApplet;

public class Display {
	private PApplet parent;
	private boolean debug;

	public Display(PApplet p) {
		this.parent = p;
		debug = true;
	}

	public void drawScreen(Engine e) {
		if (debug) {
			parent.fill(255);
			parent.text("DEBUG", 5, 10);
			parent.text("timeSpeed: " + e.getTimeSpeed() + " projectiles: "
					+ e.getProjectiles().size(), 5, 20);
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

	public void switchDebug() {
		debug = !debug;
	}

}
