package com.directmedia.onlinestore.core;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalog;
import com.directmedia.onlinestore.core.entity.Work;

public class Startup {

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		Artist tomCruise = new Artist("Tom Cruise");
        Artist michaelJackson = new Artist("Michael Jackson");
        Artist louisDeFunes = new Artist("Louis De Funes");
        
        Work minorityReport = new Work("Minority Report");
        Work bad = new Work("Bad");
        Work leGendarmeDeSaintTropez = new Work("Le Gendarme De Saint Tropez");
    
        minorityReport.setMainArtist(tomCruise);
        bad.setMainArtist(michaelJackson);
        leGendarmeDeSaintTropez.setMainArtist(louisDeFunes);
        
        minorityReport.setRelease(2002);
        bad.setRelease(1987);
        leGendarmeDeSaintTropez.setRelease(1964);
        
        minorityReport.setSummary("Résumé Minority Report");
        bad.setSummary("Résumé Bad");
        leGendarmeDeSaintTropez.setSummary("Résumé Le GDST");
        
        minorityReport.setGenre("Science Fiction");
        bad.setGenre("Pop");
        leGendarmeDeSaintTropez.setGenre("Comédie");
        
        Catalog.listOfWorks.add(minorityReport);
        Catalog.listOfWorks.add(bad);
        Catalog.listOfWorks.add(leGendarmeDeSaintTropez);
        
        for (Work work: Catalog.listOfWorks) {
            System.out.println(work.getTitle() + " (" + work.getRelease() + ")");
        }
	}

}
