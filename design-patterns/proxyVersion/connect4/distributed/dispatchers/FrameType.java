package proxyVersion.connect4.distributed.dispatchers;

public enum FrameType { 
	START,
	STATE,
	UNDO, 
	REDO, 
	UNDOABLE, 
	REDOABLE,
	CONNECT4,
	ERRORS_PUT,
	PUT_TOKEN,
	NEXT,
	CLOSE,
	TOKEN_CHAR,
	NEW_GAME;

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}
