package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Test class for {@link Subtopic}.
 */
public class SubtopicTest {

	private Topic mainTopic;
	private Subtopic subtopic;

	/**
	 * This method sets up a Subtopic object before each test.
	 */
	@Before
	public void setup() {
		mainTopic = mock(Topic.class);
		subtopic = new Subtopic(mainTopic);
	}

	/**
	 * This method tests if {@link Subtopic#setMainTopic(Topic)} correctly throws an
	 * exception if the topic is null.
	 */
	@Test
	public void setMainTopicShouldThrowAnExceptionIfMainIsNull() {
		mainTopic = null;
		
		assertThrows(IllegalArgumentException.class, () -> subtopic.setMainTopic(mainTopic));
	}
	
	/**
	 * This method tests the hashCode method.
	 */
	@Test
	public void testIfHashCodeReturnsCorrectCode() {
		Subtopic subtopic2 = new Subtopic(mainTopic);
		assertEquals(subtopic.hashCode(), subtopic2.hashCode());
	}
	
	/**
	 * This method tests the equals method.
	 */
	@Test
	public void testIfEqualsWorksProperly() {
		Subtopic subtopic2 = new Subtopic(mainTopic);
		assertTrue(subtopic.equals(subtopic2));
	}

}
