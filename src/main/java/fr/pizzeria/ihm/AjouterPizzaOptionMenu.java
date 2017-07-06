package fr.pizzeria.ihm;

import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	static Scanner questionAjout = new Scanner(System.in).useLocale(Locale.US);

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihm.OptionMenu#getLibelle()
	 */
	@Override
	public String getLibelle() {
		return "2. Ajouter une nouvelle pizza";
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihm.OptionMenu#execute(fr.pizzeria.dao.IPizzaDao)
	 */
	@Override
	public boolean execute(IPizzaDao dao) {
		System.out.println("Veuillez saisir le code");
		String codePizza = questionAjout.next();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String nomPizza = questionAjout.next();

		System.out.println("Veuillez saisir le prix");
		double prixPizza = questionAjout.nextDouble();

		Pizza pizza = new Pizza(codePizza, nomPizza, prixPizza);
		dao.saveNewPizza(pizza);

		System.out.println("Pizza Ajouté !");
		System.out.println("");
		
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihm.OptionMenu#getTitle()
	 */
	@Override
	public String getTitle() {
		return "Ajout d’une nouvelle pizza";
	}
}
