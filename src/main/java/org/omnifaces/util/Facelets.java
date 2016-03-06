package org.omnifaces.util;

import javax.el.ValueExpression;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;

/**
 * <p>
 * Collection of utility methods for Facelets code.
 *
 *@author Arjan Tijms
 *@since 2.0
*/
public final class Facelets {

	private Facelets() {
		// Hide constructor.
	}

	/**
	 * Returns the String value of the given tag attribute.
	 * @param context The involved Facelet context.
	 * @param tagAttribute The tag attribute to retrieve the value from.
	 * @return The String value of the given tag attribute, or null if the tag attribute is null.
	 */
	public static String getString(FaceletContext context, TagAttribute tagAttribute) {
		return tagAttribute != null ? tagAttribute.getValue(context) : null;
	}

	/**
	 * Returns the boolean value of the given tag attribute.
	 * @param context The involved Facelet context.
	 * @param tagAttribute The tag attribute to retrieve the value from.
	 * @return The boolean value of the given tag attribute, or false if the tag attribute is null.
	 */
	public static boolean getBoolean(FaceletContext context, TagAttribute tagAttribute) {
		return tagAttribute != null ? tagAttribute.getBoolean(context) : false;
	}

	/**
	 * Returns the Object value of the given tag attribute
	 * @param context The involved Facelet context.
	 * @param tagAttribute The tag attribute to retrieve the value from.
	 * @return The Object value of the given tag attribute, or null if the tag attribute is null.
	 */
	public static Object getObject(FaceletContext context, TagAttribute tagAttribute) {
		return tagAttribute != null ? tagAttribute.getObject(context) : null;
	}

	/**
	 * Returns the typed Object value of the given tag attribute
	 * @param <T> The expected return type.
	 * @param context The involved Facelet context.
	 * @param tagAttribute The tag attribute to retrieve the value from.
	 * @param type The expected type of the Object value.
	 * @return The typed Object value of the given tag attribute, or null if the tag attribute is null.
	 * @throws ClassCastException When <code>T</code> is of wrong type.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObject(FaceletContext context, TagAttribute tagAttribute, Class<?> type) {
		return tagAttribute != null ? (T) tagAttribute.getValueExpression(context, type).getValue(context) : null;
	}

	/**
	 * Returns the value of the given tag attribute as a value expression, so it can be carried around and evaluated at
	 * a later moment in the lifecycle without needing the Facelet context.
	 * @param context The involved Facelet context.
	 * @param tagAttribute The tag attribute to extract the value expression from.
	 * @param type The expected type of the value behind the value expression.
	 * @return The value of the given tag attribute as a value expression, or null if the tag attribute is null.
	 */
	public static ValueExpression getValueExpression(FaceletContext context, TagAttribute tagAttribute, Class<?> type) {
		return tagAttribute != null ? tagAttribute.getValueExpression(context, type) : null;
	}

}
