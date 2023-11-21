package io.github.mosser.arduinoml.externals.antlr.grammar;// Generated from C:/Users/Thoma/Desktop/ArduinoML-kernel-master/ArduinoML-kernel-master/externals/antlr/src/main/antlr4/io/github/mosser/arduinoml/externals/antlr/grammar/Arduinoml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ArduinomlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, PORT_NUMBER=11, IDENTIFIER=12, SIGNAL=13, NEWLINE=14, WS=15, 
		COMMENT=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "PORT_NUMBER", "IDENTIFIER", "SIGNAL", "LOWERCASE", "UPPERCASE", 
			"NEWLINE", "WS", "COMMENT"
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


	public ArduinomlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Arduinoml.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010\u0089\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\nY\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b^\b\u000b\u000b"+
		"\u000b\f\u000b_\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\fi\b\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0003"+
		"\u000fp\b\u000f\u0001\u000f\u0001\u000f\u0004\u000ft\b\u000f\u000b\u000f"+
		"\f\u000fu\u0001\u000f\u0001\u000f\u0001\u0010\u0004\u0010{\b\u0010\u000b"+
		"\u0010\f\u0010|\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0005"+
		"\u0011\u0083\b\u0011\n\u0011\f\u0011\u0086\t\u0011\u0001\u0011\u0001\u0011"+
		"\u0000\u0000\u0012\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u0000\u001d\u0000\u001f\u000e!\u000f#\u0010\u0001\u0000\u0005"+
		"\u0001\u000019\u0001\u0000az\u0001\u0000AZ\u0002\u0000\t\t  \u0002\u0000"+
		"\n\n\r\r\u0090\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0001%"+
		"\u0001\u0000\u0000\u0000\u00031\u0001\u0000\u0000\u0000\u00058\u0001\u0000"+
		"\u0000\u0000\u0007A\u0001\u0000\u0000\u0000\tC\u0001\u0000\u0000\u0000"+
		"\u000bE\u0001\u0000\u0000\u0000\rG\u0001\u0000\u0000\u0000\u000fJ\u0001"+
		"\u0000\u0000\u0000\u0011M\u0001\u0000\u0000\u0000\u0013P\u0001\u0000\u0000"+
		"\u0000\u0015X\u0001\u0000\u0000\u0000\u0017Z\u0001\u0000\u0000\u0000\u0019"+
		"h\u0001\u0000\u0000\u0000\u001bj\u0001\u0000\u0000\u0000\u001dl\u0001"+
		"\u0000\u0000\u0000\u001fs\u0001\u0000\u0000\u0000!z\u0001\u0000\u0000"+
		"\u0000#\u0080\u0001\u0000\u0000\u0000%&\u0005a\u0000\u0000&\'\u0005p\u0000"+
		"\u0000\'(\u0005p\u0000\u0000()\u0005l\u0000\u0000)*\u0005i\u0000\u0000"+
		"*+\u0005c\u0000\u0000+,\u0005a\u0000\u0000,-\u0005t\u0000\u0000-.\u0005"+
		"i\u0000\u0000./\u0005o\u0000\u0000/0\u0005n\u0000\u00000\u0002\u0001\u0000"+
		"\u0000\u000012\u0005s\u0000\u000023\u0005e\u0000\u000034\u0005n\u0000"+
		"\u000045\u0005s\u0000\u000056\u0005o\u0000\u000067\u0005r\u0000\u0000"+
		"7\u0004\u0001\u0000\u0000\u000089\u0005a\u0000\u00009:\u0005c\u0000\u0000"+
		":;\u0005t\u0000\u0000;<\u0005u\u0000\u0000<=\u0005a\u0000\u0000=>\u0005"+
		"t\u0000\u0000>?\u0005o\u0000\u0000?@\u0005r\u0000\u0000@\u0006\u0001\u0000"+
		"\u0000\u0000AB\u0005:\u0000\u0000B\b\u0001\u0000\u0000\u0000CD\u0005{"+
		"\u0000\u0000D\n\u0001\u0000\u0000\u0000EF\u0005}\u0000\u0000F\f\u0001"+
		"\u0000\u0000\u0000GH\u0005<\u0000\u0000HI\u0005=\u0000\u0000I\u000e\u0001"+
		"\u0000\u0000\u0000JK\u0005i\u0000\u0000KL\u0005s\u0000\u0000L\u0010\u0001"+
		"\u0000\u0000\u0000MN\u0005=\u0000\u0000NO\u0005>\u0000\u0000O\u0012\u0001"+
		"\u0000\u0000\u0000PQ\u0005-\u0000\u0000QR\u0005>\u0000\u0000R\u0014\u0001"+
		"\u0000\u0000\u0000SY\u0007\u0000\u0000\u0000TU\u00051\u0000\u0000UY\u0005"+
		"1\u0000\u0000VW\u00051\u0000\u0000WY\u00052\u0000\u0000XS\u0001\u0000"+
		"\u0000\u0000XT\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000Y\u0016"+
		"\u0001\u0000\u0000\u0000Z]\u0003\u001b\r\u0000[^\u0003\u001b\r\u0000\\"+
		"^\u0003\u001d\u000e\u0000][\u0001\u0000\u0000\u0000]\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000"+
		"\u0000\u0000`\u0018\u0001\u0000\u0000\u0000ab\u0005H\u0000\u0000bc\u0005"+
		"I\u0000\u0000cd\u0005G\u0000\u0000di\u0005H\u0000\u0000ef\u0005L\u0000"+
		"\u0000fg\u0005O\u0000\u0000gi\u0005W\u0000\u0000ha\u0001\u0000\u0000\u0000"+
		"he\u0001\u0000\u0000\u0000i\u001a\u0001\u0000\u0000\u0000jk\u0007\u0001"+
		"\u0000\u0000k\u001c\u0001\u0000\u0000\u0000lm\u0007\u0002\u0000\u0000"+
		"m\u001e\u0001\u0000\u0000\u0000np\u0005\r\u0000\u0000on\u0001\u0000\u0000"+
		"\u0000op\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qt\u0005\n\u0000"+
		"\u0000rt\u0005\r\u0000\u0000so\u0001\u0000\u0000\u0000sr\u0001\u0000\u0000"+
		"\u0000tu\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0006\u000f\u0000\u0000x \u0001"+
		"\u0000\u0000\u0000y{\u0007\u0003\u0000\u0000zy\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000"+
		"\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0006\u0010\u0000\u0000\u007f"+
		"\"\u0001\u0000\u0000\u0000\u0080\u0084\u0005#\u0000\u0000\u0081\u0083"+
		"\b\u0004\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0086\u0001"+
		"\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086\u0084\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0006\u0011\u0000\u0000\u0088$\u0001\u0000"+
		"\u0000\u0000\n\u0000X]_hosu|\u0084\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}