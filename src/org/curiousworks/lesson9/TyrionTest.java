package org.curiousworks.lesson9;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class TyrionTest extends TestCase{
	
	@Test
	public void testDisposition () {
		Character tyrion = new Character("Tyrion Lannister", "House Lannister", "messages9287658288370.txt");
		assertTrue("Tyrion has a positive disposition.", (tyrion.calculateDisposition() > 0));
	}
}
