package exo8;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class TestLongAction extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JButton btnAction;
	private final JProgressBar jProgressBar;
	private final SwingWorker<Void, Void> sw;

	public TestLongAction() {
		// Construction de la fenetre de test
		btnAction = new JButton("Start");
		jProgressBar = new JProgressBar(0, 100);

		sw = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				// new LongAction().traitementLong();
				
				for (int i = 0; i < 255; i++) {

					try {
						Thread.sleep(10L);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
					
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							int progress = TestLongAction.this.jProgressBar.getValue();
							
							TestLongAction.this.jProgressBar.setValue(progress + 1);
							TestLongAction.this.jProgressBar.setBackground(new Color(progress * 2, 50 + progress/2, 250 - progress));
							TestLongAction.this.jProgressBar.setForeground(new Color(50 + progress * 2, (int) (250 - progress*1.5), 250 - progress));
							TestLongAction.this.jProgressBar.repaint();
						}
					});
				}
				return null;
			}
		};

		// Ajout du listener du bouton
		btnAction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sw.execute();
			}
		});

		final Container contentPane = getContentPane();
		
		contentPane.setLayout(new GridLayout(2, 1));
		contentPane.add(btnAction);
		contentPane.add(jProgressBar);
		
		setTitle("Test de LongAction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new TestLongAction();
	}
}
