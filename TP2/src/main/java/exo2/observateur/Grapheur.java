package exo2.observateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Cette classe affiche dans un rep�re orthonorm� une courbe de temp�ratures �
 * partir de donn�es m�t�orologiques notifi�es.
 * 
 * Cette classe est un observateur.
 * 
 * @author V579656
 * @since 10/11/2014
 * @version 1.0
 */
public class Grapheur extends JFrame implements Observateur {

	private static final long serialVersionUID = 1L;

	private final JpDessin jpDessin;

	/**
	 * Constructeur par d�faut.
	 */
	public Grapheur() {
		this.setLayout(new BorderLayout());
		this.jpDessin = new JpDessin();
		add(jpDessin, BorderLayout.CENTER);
		this.setSize(400, 300);
		this.setTitle("Grapheur");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private static class JpDessin extends JPanel {

		private static final long serialVersionUID = 1L;

		private static final int D = 10;
		private static final int X = 10;
		private static final int Y = 100;

		private final Polygon polygone;

		public JpDessin() {
			this.polygone = new Polygon();
		}

		public void addPoint(int x, int y) {
			polygone.addPoint(x + JpDessin.X + JpDessin.D * polygone.npoints,
					JpDessin.Y - y);
		}

		protected void paintComponent(Graphics g) {
			// Axe
			g.drawLine(JpDessin.X, JpDessin.Y, 380, JpDessin.Y);
			g.drawLine(JpDessin.X, 10, JpDessin.X, 170);

			g.setColor(Color.red);

			// Barre
			for (int i = 0; i < polygone.npoints; i++) {
				g.drawLine(polygone.xpoints[i], JpDessin.Y,
						polygone.xpoints[i], polygone.ypoints[i]);
			}

			// Courbe
			g.drawPolyline(polygone.xpoints, polygone.ypoints, polygone.npoints);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pattern.exo2.observateur.Observateur#modifier(pattern.exo2.observateur
	 * .Donnee)
	 */
	@Override
	public void modifier(final Donnee donnee) {
		// Confinement EDT
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				jpDessin.addPoint(0, (int) donnee.getTemperature());
				Grapheur.this.repaint();
			}
		});

	}
}
