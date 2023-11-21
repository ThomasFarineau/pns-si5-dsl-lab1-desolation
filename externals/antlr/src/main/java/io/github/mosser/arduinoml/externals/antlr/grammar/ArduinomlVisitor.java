package io.github.mosser.arduinoml.externals.antlr.grammar;// Generated from C:/Users/Thoma/Desktop/ArduinoML-kernel-master/ArduinoML-kernel-master/externals/antlr/src/main/antlr4/io/github/mosser/arduinoml/externals/antlr/grammar/Arduinoml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArduinomlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArduinomlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArduinomlParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(ArduinomlParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduinomlParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(ArduinomlParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduinomlParser#bricks}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBricks(ArduinomlParser.BricksContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduinomlParser#sensor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSensor(ArduinomlParser.SensorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduinomlParser#actuator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActuator(ArduinomlParser.ActuatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduinomlParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(ArduinomlParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduinomlParser#states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStates(ArduinomlParser.StatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduinomlParser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(ArduinomlParser.StateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduinomlParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(ArduinomlParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduinomlParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(ArduinomlParser.TransitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduinomlParser#initial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial(ArduinomlParser.InitialContext ctx);
}