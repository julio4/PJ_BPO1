import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JeuDeCartesTest {

	@Test
	void test_init() {
		JeuDeCartes jdc = new JeuDeCartes();
		for(Carte c : jdc.jdc) {
			System.out.println(c.typeCarte);
		}
	}

}
