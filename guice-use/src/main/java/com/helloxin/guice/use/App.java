package com.helloxin.guice.use;

import com.google.inject.Inject;

/**
 * Hello world!
 *
 */
public class App {
	
	private AnimalService animalService;
	
	@Inject
    public App(AnimalService animalService) {
        this.animalService = animalService;
    }
	
    public static void main( String[] args )
    {
       	
    }
}
