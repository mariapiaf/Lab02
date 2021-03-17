package it.polito.tdp.alien;
import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {
	
	private Map<String, Word> mappaTraduzioni;

	public AlienDictionary() {
		this.mappaTraduzioni = new HashMap<>();
	}
	
	public void addWord(String alienWord, String translation) {
		if(mappaTraduzioni.get(alienWord) == null) {
			Word w = new Word(alienWord, translation);
			mappaTraduzioni.put(alienWord, w);
		}
		else {
			Word wtemp = mappaTraduzioni.get(alienWord);
			mappaTraduzioni.put(alienWord, wtemp);
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

	
	

	
}
