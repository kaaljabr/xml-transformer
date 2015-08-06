package com.transform.util;

import java.io.IOException;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

public class CharacterEscapeHandlerManager {

	private static Logger log = LoggerFactory.getLogger(CharacterEscapeHandlerManager.class);

	private volatile static CharacterEscapeHandlerManager _instance;

	private CharacterEscapeHandler characterEscapeHandler;

	private CharacterEscapeHandlerManager() {
		initCharacterEscapedHandler();
	}

	public static CharacterEscapeHandlerManager getInstance() {
		if (_instance == null) {
			synchronized (CharacterEscapeHandlerManager.class) {
				if (CharacterEscapeHandlerManager._instance == null) {
					CharacterEscapeHandlerManager._instance = new CharacterEscapeHandlerManager();
				}
			}
		}
		return _instance;
	}

	public CharacterEscapeHandler getCharacterEscapeHandler() {
		return characterEscapeHandler;
	}

	private void initCharacterEscapedHandler() {
		characterEscapeHandler = new CharacterEscapeHandler() {
			@Override
			public void escape(char[] ch, int start, int length, boolean isAttVal, Writer out) throws IOException {
				out.write("Called escape for characters = " + ch.toString());
			}
		};

	}

}
