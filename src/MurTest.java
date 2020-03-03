import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MurTest {

	@Test
	void test_verifier() {
		Mur mur = new Mur();
    	
    	assert(mur.verifier('a', 1, 1));
    	assert(mur.verifier('b', 1, 2));
    	assert(mur.verifier('d', 1, 3));
    	assert(!mur.verifier('d', 1, 5));
	}

}
