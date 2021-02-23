package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for {@link Topic}.
 */
public class TopicTest {
	
	private Topic topic1 = new Topic();
	private Topic topic2 = new Topic();
	
	/**
	 * This method tests the hashCode method.
	 */
	@Test
	public void testIfHashCodeReturnsCorrectCode() {
		assertEquals(topic1.hashCode(), topic2.hashCode());
	}
	
	/**
	 * This method tests the equals method.
	 */
	@Test
	public void testIfEqualsWorksProperly() {
		assertTrue(topic1.equals(topic2));
	}
	
}
