package leaning.vargrul;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class MyFirstGame {

	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		// init OpenGL
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		while (!Display.isCloseRequested()) {
			
			// Clear the screen and depth buffer
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	

			if (Mouse.isButtonDown(0)) {
				GL11.glColor3f(0.0f,0.0f,1.0f);
			}else{
				GL11.glColor3f(0.0f,0.0f,0.0f);
			}

			// draw quad
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(100,100);
			GL11.glVertex2f(100+200,100);
			GL11.glVertex2f(100+200,100+200);
			GL11.glVertex2f(100,100+200);
			GL11.glEnd();

			Display.update();
		}

		Display.destroy();
	}

	public static void main(String[] argv) {
		MyFirstGame displayExample = new MyFirstGame();
		displayExample.start();
	}

}
