package com.deyvis.initialartifactms;

import com.deyvis.initialartifactms.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * InitialArtifactMsApplication Main class.
 *
 * @author David G.
 * @version 1.0
 */

@SpringBootApplication
public class InitialArtifactMsApplication implements CommandLineRunner {

	/**
	 * Method main where start spring application.
	 * @param args params.
	 */
	public static void main(String[] args) {
		SpringApplication.run(InitialArtifactMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
