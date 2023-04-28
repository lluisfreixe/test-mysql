package cat.dgp.openshift;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cat.dgp.openshift.Individuo;
import cat.dgp.openshift.IndividuoDao;

@Controller
public class Controlador {
	
	@Autowired
	private IndividuoDao individuoDao;
	
	String appName = "test-mysql";

	@GetMapping("/entrada")
	public String entrada(Model model) {
		esborrarDades();
		inserirDades();
		Iterable<Individuo> individuos = individuoDao.findAll();
		String data = obtenirData();
		String hora = obtenirHora();
		String capacitat = "1000";
		model.addAttribute("appName", appName);
		model.addAttribute("capacitat", capacitat);
		model.addAttribute("data", data);
		model.addAttribute("hora", hora);
		model.addAttribute("individuos", individuos);
	    return "inici";
	  }
	
	private String obtenirData () {
		Date date = new Date();
		DateFormat formatData = DateFormat.getDateInstance(DateFormat.SHORT);
		String data = formatData.format(date);
		return data;
	}

	private String obtenirHora () {
		Date date = new Date();
		DateFormat formatHora = new SimpleDateFormat("HH:mm:ss");
		String hora = formatHora.format(date);
		return hora;
	}

	private boolean esborrarDades () {
		boolean correcte = true;
		individuoDao.deleteAll();
		System.out.println("metode esborrarDades executat.");
		return correcte;
	}

	private boolean inserirDades () {
		boolean correcte = true;
		for (int i=1; i <= 1000; i++) {
			Individuo individuo = new Individuo();
			individuo.setId_individuo(i);
			individuo.setNombre("Nom"+i);
			individuo.setApellido("Cognom"+i);
			individuo.setEdad("22");
			individuo.setTelefono("1111"+i);
			individuo.setCorreo(i+"correu@correu.cat");
			individuoDao.save(individuo);
		}
		System.out.println("metode inserirDades executat.");
		return correcte;
	}

}
