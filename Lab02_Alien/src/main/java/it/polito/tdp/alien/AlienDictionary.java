package it.polito.tdp.alien;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlienDictionary {
	
	private Map<String, Word> mappaTraduzioni;
	private Map<String, WordEnhanced> mappaListaTrad;

	public AlienDictionary() {
		this.mappaTraduzioni = new HashMap<>();
		this.mappaListaTrad = new HashMap<>();
	}
	
	public void addWord(String alienWord, String translation) {
		/*if(mappaTraduzioni.get(alienWord) == null) {
			Word w = new Word(alienWord, translation);
			mappaTraduzioni.put(alienWord, w);
		}
		else {
			Word wtemp = mappaTraduzioni.get(alienWord);
			mappaTraduzioni.put(alienWord, wtemp);
		}*/
		
		
		if(mappaListaTrad.get(alienWord) == null) {
			WordEnhanced we = new WordEnhanced(alienWord);
			we.aggiungiTraduzioniParola(translation);
			mappaListaTrad.put(alienWord, we);
		}
		else {
			WordEnhanced wetemp = mappaListaTrad.get(alienWord);
			wetemp.aggiungiTraduzioniParola(translation);
		}
		
	}
	
	public String translateWord(String alienWord) {
		if(mappaTraduzioni.get(alienWord)==null) {
			return null;
		}
		else {
			Word wtemp = mappaTraduzioni.get(alienWord);
			return wtemp.getTraduzione();
		}
	}

	public String translateWordEnhanced(String alienword){
		String rit = "";
		if(mappaListaTrad.get(alienword) == null) {
			return null;
		}
		else {
			for(String s: new LinkedList<String>(mappaListaTrad.get(alienword).getTraduzioniParola())) {
				rit+= s +"\n";
			}
			return rit.substring(0, rit.length()-1);
		}
		
	}
	

	
}
