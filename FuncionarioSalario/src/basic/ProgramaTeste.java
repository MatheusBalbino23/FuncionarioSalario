package basic;

import javax.swing.SwingUtilities;

public class ProgramaTeste {

	public static void main(String[] args) {
		//garante que a criação da interface ocorra
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Programa programa = new Programa();
				programa.CalculadoraComissao();
			}
		});
	}
}
