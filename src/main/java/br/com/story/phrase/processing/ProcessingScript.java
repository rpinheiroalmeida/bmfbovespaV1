package br.com.story.phrase.processing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import br.com.story.phrase.model.Character;
import br.com.story.phrase.model.MovieSetting;
import br.com.story.phrase.model.Word;

public class ProcessingScript {

	private static final String CLOSE_BRACKETS = ")";
	private static final String OPEN_BRACKETS = "(";
	private static final String REGEX_PUNCTUATION = "(;)|(:)|(\\!)|(\\?)|(,)|(\\.)";
	private static final String COMMA = ",";
	private static final String DOT = ".";

	public static Set<MovieSetting> process(String filePath) throws FileNotFoundException {
		LineIterator lt = IOUtils.lineIterator(new FileReader(filePath));
		Map<MovieSetting, Map<Character, List<Word>>> mapMovies = processLine(lt);
		loadEntities(mapMovies);

		return mapMovies.keySet();
	}



	private static void loadEntities(Map<MovieSetting, Map<Character, List<Word>>> mapMovies) {
		for (Map.Entry<MovieSetting, Map<Character, List<Word>>> entry : mapMovies.entrySet()) {
			for (Map.Entry<Character, List<Word>> entryCharacter : entry.getValue().entrySet()) {
				entryCharacter.getKey().setMovieSetting(entry.getKey());
				entryCharacter.getKey().setWords(entryCharacter.getValue());
				for (Word word : entryCharacter.getValue()) {
					word.setCharacter(entryCharacter.getKey());
				}
			}
			entry.getKey().setCharacters(entry.getValue().keySet());
		}
	}

	private static String getNameMovieSetting(String line) {
		String[] words = line.split(" ");
		StringBuilder nameSetting = new StringBuilder();

		for (int i = 1; i < words.length; i++) {
			if (!words[i].equals("-")) {
				nameSetting.append(words[i] + " ");
			} else {
				break;
			}
		}
		return nameSetting.toString().trim();
	}

	private static Map<MovieSetting, Map<Character, List<Word>>> processLine(LineIterator lineIterator) {
		MovieSetting movieSettingCurrent = null;
		Character characterCurrent = null;
		Map<MovieSetting, Map<Character, List<Word>>> mapMovieCharacter = new HashMap<>();

		for (LineIterator iterator = lineIterator; iterator.hasNext();) {
			String line = iterator.nextLine();
			if (isMovieSettings(line)) {
				movieSettingCurrent = getMovieSettingKey(line);
				if (!mapMovieCharacter.containsKey(movieSettingCurrent)) {
					mapMovieCharacter.put(movieSettingCurrent, new HashMap<Character, List<Word>>());
				}
			} else if (movieSettingCurrent!= null && isCharacterName(line)) {
				characterCurrent = getCharacterKey(movieSettingCurrent, line);

				Map<Character, List<Word>> mapCharacter = mapMovieCharacter.get(movieSettingCurrent);

				if (!mapCharacter.containsKey(characterCurrent)) {
					mapCharacter.put(characterCurrent, new ArrayList<Word>());
				}
				characterCurrent.setWords(new ArrayList<Word>());
				movieSettingCurrent.getCharacters().add(characterCurrent);

			} else if (characterCurrent != null && isSpeakWord(line)) {

				List<Word> words = mapMovieCharacter.get(movieSettingCurrent).get(characterCurrent);
				words.addAll(getWordsFromLine(characterCurrent, line));
				characterCurrent.getWords().addAll(words);
			}
		}
		return mapMovieCharacter;
	}



	private static List<Word> getWordsFromLine(Character characterCurrent, String line) {
		String[] strings = line.trim().split(" ");
		List<Word> words = new ArrayList<>();
		for (String word : strings) {
			if ( isAValidWord(word) ) {
				if (word.contains(DOT)) {
					words.addAll(processesWordWithDot(word, characterCurrent));
				}
				else if (word.contains(COMMA)) {
					words.addAll(processWordWithComma(word, characterCurrent));
				}
				else {
					words.add(new Word(removePunctuation(word), characterCurrent));
				}
			}
		}
		return words;
	}



	private static List<Word> processWordWithComma(String word, Character characterCurrent) {
		List<Word> words = new ArrayList<>();
		if (word.indexOf(COMMA) == word.length()-1) {
			words.add(new Word(removePunctuation(word), characterCurrent));
		} else {
			String[] splitDot = word.split(COMMA);
			for (String wordSplitDot : splitDot) {
				words.add(new Word(removePunctuation(wordSplitDot), characterCurrent));
			}
		}
		return words;
	}

	private static String removePunctuation(String word) {
		return word.replaceAll(REGEX_PUNCTUATION, "");
	}

	private static List<Word> processesWordWithDot(String word, Character characterCurrent) {
		List<Word> words = new ArrayList<>();
		if (word.endsWith(DOT)) {
			words.add(new Word(removePunctuation(word), characterCurrent));
		} else {
			String[] splitDot = word.split(DOT);
			for (String wordSplitDot : splitDot) {
				words.add(new Word(removePunctuation(wordSplitDot), characterCurrent));
			}
		}
		return words;
	}



	private static boolean isAValidWord(String word) {
		return !word.startsWith(OPEN_BRACKETS) && !word.endsWith(CLOSE_BRACKETS);
	}



	private static Character getCharacterKey(MovieSetting movieSettingCurrent, String line) {
		Character characterKey = new Character();
		characterKey.setMovieSetting(movieSettingCurrent);
		characterKey.setName(line.trim());
		return characterKey;
	}



	private static MovieSetting getMovieSettingKey(String line) {
		String nameSetting = getNameMovieSetting(line);

		MovieSetting movieSettingkey = new MovieSetting();
		movieSettingkey.setName(nameSetting.toString().trim());
		movieSettingkey = new MovieSetting();
		movieSettingkey.setName(nameSetting.toString().trim());
		movieSettingkey.setCharacters(new HashSet<Character>());

		return movieSettingkey;
	}



	private static boolean isSpeakWord(String line) {
		return line.startsWith("          ") && !line.trim().equals("FADE OUT:") &&
				!line.trim().equals("THE END");
	}

	private static boolean isMovieSettings(String line) {
		return line.startsWith("INT.") || line.startsWith("EXT.") || line.startsWith("INT./EXT.");
	}

	private static boolean isCharacterName(String line) {
		return line.startsWith("                      ") && !line.trim().equals("FADE OUT:") &&
				!line.trim().equals("THE END");
	}

	public static void main(String[] args) {
		System.out.println( "++" + "reactor.".replaceAll("\\.", "") );
	}

}
