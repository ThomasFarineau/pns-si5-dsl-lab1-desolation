package io.github.mosser.arduinoml.externals.antlr.grammar;// Generated from C:/Users/Thoma/Desktop/ArduinoML-kernel-master/ArduinoML-kernel-master/externals/antlr/src/main/antlr4/io/github/mosser/arduinoml/externals/antlr/grammar/Arduinoml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ArduinomlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, PORT_NUMBER=11, IDENTIFIER=12, SIGNAL=13, NEWLINE=14, WS=15, 
		COMMENT=16;
	public static final int
		RULE_root = 0, RULE_declaration = 1, RULE_bricks = 2, RULE_sensor = 3, 
		RULE_actuator = 4, RULE_location = 5, RULE_states = 6, RULE_state = 7, 
		RULE_action = 8, RULE_transition = 9, RULE_initial = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "declaration", "bricks", "sensor", "actuator", "location", "states", 
			"state", "action", "transition", "initial"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'application'", "'sensor'", "'actuator'", "':'", "'{'", "'}'", 
			"'<='", "'is'", "'=>'", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "PORT_NUMBER", 
			"IDENTIFIER", "SIGNAL", "NEWLINE", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Arduinoml.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArduinomlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public BricksContext bricks() {
			return getRuleContext(BricksContext.class,0);
		}
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ArduinomlParser.EOF, 0); }
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			declaration();
			setState(23);
			bricks();
			setState(24);
			states();
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public Token name;
		public TerminalNode IDENTIFIER() { return getToken(ArduinomlParser.IDENTIFIER, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(T__0);
			setState(28);
			((DeclarationContext)_localctx).name = match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BricksContext extends ParserRuleContext {
		public List<SensorContext> sensor() {
			return getRuleContexts(SensorContext.class);
		}
		public SensorContext sensor(int i) {
			return getRuleContext(SensorContext.class,i);
		}
		public List<ActuatorContext> actuator() {
			return getRuleContexts(ActuatorContext.class);
		}
		public ActuatorContext actuator(int i) {
			return getRuleContext(ActuatorContext.class,i);
		}
		public BricksContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bricks; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterBricks(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitBricks(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitBricks(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BricksContext bricks() throws RecognitionException {
		BricksContext _localctx = new BricksContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bricks);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(32);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(30);
					sensor();
					}
					break;
				case T__2:
					{
					setState(31);
					actuator();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 || _la==T__2 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SensorContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public SensorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sensor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterSensor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitSensor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitSensor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SensorContext sensor() throws RecognitionException {
		SensorContext _localctx = new SensorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sensor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__1);
			setState(37);
			location();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActuatorContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public ActuatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actuator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterActuator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitActuator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitActuator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActuatorContext actuator() throws RecognitionException {
		ActuatorContext _localctx = new ActuatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_actuator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__2);
			setState(40);
			location();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocationContext extends ParserRuleContext {
		public Token id;
		public Token port;
		public TerminalNode IDENTIFIER() { return getToken(ArduinomlParser.IDENTIFIER, 0); }
		public TerminalNode PORT_NUMBER() { return getToken(ArduinomlParser.PORT_NUMBER, 0); }
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			((LocationContext)_localctx).id = match(IDENTIFIER);
			setState(43);
			match(T__3);
			setState(44);
			((LocationContext)_localctx).port = match(PORT_NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatesContext extends ParserRuleContext {
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterStates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitStates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitStates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatesContext states() throws RecognitionException {
		StatesContext _localctx = new StatesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				state();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 || _la==IDENTIFIER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateContext extends ParserRuleContext {
		public Token name;
		public TransitionContext transition() {
			return getRuleContext(TransitionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ArduinomlParser.IDENTIFIER, 0); }
		public InitialContext initial() {
			return getRuleContext(InitialContext.class,0);
		}
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_state);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(51);
				initial();
				}
			}

			setState(54);
			((StateContext)_localctx).name = match(IDENTIFIER);
			setState(55);
			match(T__4);
			setState(57); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(56);
					action();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(59); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(61);
			transition();
			setState(62);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActionContext extends ParserRuleContext {
		public Token receiver;
		public Token value;
		public TerminalNode IDENTIFIER() { return getToken(ArduinomlParser.IDENTIFIER, 0); }
		public TerminalNode SIGNAL() { return getToken(ArduinomlParser.SIGNAL, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			((ActionContext)_localctx).receiver = match(IDENTIFIER);
			setState(65);
			match(T__6);
			setState(66);
			((ActionContext)_localctx).value = match(SIGNAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TransitionContext extends ParserRuleContext {
		public Token trigger;
		public Token value;
		public Token next;
		public List<TerminalNode> IDENTIFIER() { return getTokens(ArduinomlParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ArduinomlParser.IDENTIFIER, i);
		}
		public TerminalNode SIGNAL() { return getToken(ArduinomlParser.SIGNAL, 0); }
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitTransition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitTransition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			((TransitionContext)_localctx).trigger = match(IDENTIFIER);
			setState(69);
			match(T__7);
			setState(70);
			((TransitionContext)_localctx).value = match(SIGNAL);
			setState(71);
			match(T__8);
			setState(72);
			((TransitionContext)_localctx).next = match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitialContext extends ParserRuleContext {
		public InitialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterInitial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitInitial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitInitial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialContext initial() throws RecognitionException {
		InitialContext _localctx = new InitialContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_initial);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0010M\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0004\u0002!\b\u0002\u000b\u0002\f\u0002\"\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0004\u00060\b\u0006"+
		"\u000b\u0006\f\u00061\u0001\u0007\u0003\u00075\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0004\u0007:\b\u0007\u000b\u0007\f\u0007;\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0000\u0000"+
		"\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0000"+
		"F\u0000\u0016\u0001\u0000\u0000\u0000\u0002\u001b\u0001\u0000\u0000\u0000"+
		"\u0004 \u0001\u0000\u0000\u0000\u0006$\u0001\u0000\u0000\u0000\b\'\u0001"+
		"\u0000\u0000\u0000\n*\u0001\u0000\u0000\u0000\f/\u0001\u0000\u0000\u0000"+
		"\u000e4\u0001\u0000\u0000\u0000\u0010@\u0001\u0000\u0000\u0000\u0012D"+
		"\u0001\u0000\u0000\u0000\u0014J\u0001\u0000\u0000\u0000\u0016\u0017\u0003"+
		"\u0002\u0001\u0000\u0017\u0018\u0003\u0004\u0002\u0000\u0018\u0019\u0003"+
		"\f\u0006\u0000\u0019\u001a\u0005\u0000\u0000\u0001\u001a\u0001\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0005\u0001\u0000\u0000\u001c\u001d\u0005\f\u0000"+
		"\u0000\u001d\u0003\u0001\u0000\u0000\u0000\u001e!\u0003\u0006\u0003\u0000"+
		"\u001f!\u0003\b\u0004\u0000 \u001e\u0001\u0000\u0000\u0000 \u001f\u0001"+
		"\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000"+
		"\"#\u0001\u0000\u0000\u0000#\u0005\u0001\u0000\u0000\u0000$%\u0005\u0002"+
		"\u0000\u0000%&\u0003\n\u0005\u0000&\u0007\u0001\u0000\u0000\u0000\'(\u0005"+
		"\u0003\u0000\u0000()\u0003\n\u0005\u0000)\t\u0001\u0000\u0000\u0000*+"+
		"\u0005\f\u0000\u0000+,\u0005\u0004\u0000\u0000,-\u0005\u000b\u0000\u0000"+
		"-\u000b\u0001\u0000\u0000\u0000.0\u0003\u000e\u0007\u0000/.\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001"+
		"\u0000\u0000\u00002\r\u0001\u0000\u0000\u000035\u0003\u0014\n\u000043"+
		"\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000067\u0005\f\u0000\u000079\u0005\u0005\u0000\u00008:\u0003\u0010\b"+
		"\u000098\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;9\u0001\u0000"+
		"\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0003"+
		"\u0012\t\u0000>?\u0005\u0006\u0000\u0000?\u000f\u0001\u0000\u0000\u0000"+
		"@A\u0005\f\u0000\u0000AB\u0005\u0007\u0000\u0000BC\u0005\r\u0000\u0000"+
		"C\u0011\u0001\u0000\u0000\u0000DE\u0005\f\u0000\u0000EF\u0005\b\u0000"+
		"\u0000FG\u0005\r\u0000\u0000GH\u0005\t\u0000\u0000HI\u0005\f\u0000\u0000"+
		"I\u0013\u0001\u0000\u0000\u0000JK\u0005\n\u0000\u0000K\u0015\u0001\u0000"+
		"\u0000\u0000\u0005 \"14;";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}