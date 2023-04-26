package com.savarino.presentation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.savarino.entities.Biglietto;
import com.savarino.services.BiglietteriaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class ControllerMVC {
	@Autowired
	private BiglietteriaService biglietteriaService;
	
	@GetMapping(value = {"index", "login", "/"})
	public String home(Model m, HttpSession session  ) {

		if (session.getAttribute("loggato")!=null) {
			System.out.println("Utente loggato");
		} else {
			m.addAttribute("titolo", "Pagina di login");
			return "login";
		}
		
		return "redirect:lista";
	}
	
	@PostMapping("login")
	public String doLogin(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, HttpSession session ) {
		
//		System.out.println(username);
//		System.out.println(password);
		
		if (username.equals("claudio") && password.equals("12345") ) {
			session.setAttribute("loggato", "claudio");
		}
			
		return "redirect:/";
		
	}
	
	@GetMapping(value = {"lista", "elenco"})
	public String lista(Model m) {
		
		m.addAttribute("titolo", "Elenco films");
		
		m.addAttribute("films",biglietteriaService.getfilms());
		
		return "lista";
	}

	@GetMapping(value = {"biglietto"})
	public String prenotazioni(Model m) {
		
		m.addAttribute("titolo", "Elenco delle prenotazioni");
		
		m.addAttribute("elenco", biglietteriaService.getBiglietto());
		
		return "biglietto";
	}
	@GetMapping(value = {"aquistaBiglietto/{id}","prenotaBiglietto/{id}"})
	public String prenota(@PathVariable int id,Model m) {
		
		m.addAttribute("titolo", "Informazioni sui biglietti");
		
		m.addAttribute("film", biglietteriaService.getFilmById(id));
		
		return "aquistaBiglietto";
	}
	@GetMapping(value = {"conferma/{id}"})
	public String conferma(@PathVariable int id,Model m) {
		
		m.addAttribute("titolo", "Conferma della prenotazione");
		
		m.addAttribute("dati", biglietteriaService.getBigliettoById(id));
		
		return "conferma";
	}
	
	@PostMapping("conferma")
	public String doConferma(Biglietto b) {
		System.out.println("metodo prenotazione confermata");
		Biglietto biglietto =null;
		if (b != null) {
			biglietto = biglietteriaService.addBiglietto(b);
		}
		
		return "redirect:conferma/"+biglietto.getId();
	}


}
	


