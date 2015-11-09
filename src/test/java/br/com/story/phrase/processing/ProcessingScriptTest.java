package br.com.story.phrase.processing;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import br.com.story.phrase.model.Character;
import br.com.story.phrase.model.MovieSetting;
import br.com.story.phrase.model.Word;

public class ProcessingScriptTest {

    @Test
    public void testProcessFileV1() throws IOException {
    	
    	String filePath =  getClass().getResource("/screenplayV1.txt").getFile();

    	Set<MovieSetting> result = ProcessingScript.process(filePath);
    	
    	MovieSetting movieSettingExpected = new MovieSetting("REBEL BLOCKADE RUNNER");
    	Character characterExpected = new Character("THREEPIO");
    	characterExpected.setMovieSetting(movieSettingExpected);
    	List<Word> wordsExpected = new ArrayList<>();
    	wordsExpected.add(new Word("We're", characterExpected)); wordsExpected.add(new Word("the", characterExpected));
    	wordsExpected.add(new Word("doomed", characterExpected)); wordsExpected.add(new Word("There'll", characterExpected));
    	wordsExpected.add(new Word("be", characterExpected)); wordsExpected.add(new Word("no", characterExpected));
    	wordsExpected.add(new Word("escape", characterExpected)); wordsExpected.add(new Word("for", characterExpected)); 
    	wordsExpected.add(new Word("the", characterExpected));wordsExpected.add(new Word("Princess", characterExpected));
    	wordsExpected.add(new Word("this", characterExpected)); wordsExpected.add(new Word("time", characterExpected)); 
    	wordsExpected.add(new Word("What's", characterExpected)); wordsExpected.add(new Word("that", characterExpected));
    	characterExpected.setWords(wordsExpected);
    	
    	assertEquals(1, result.size());
    	for (MovieSetting movieSettingActual : result) {
    		assertEquals(movieSettingExpected, movieSettingActual);
    		assertEquals(1, movieSettingActual.getCharacters().size());
    		for (Character characterActual : movieSettingActual.getCharacters()) {
    			assertEquals(characterExpected, characterActual);
    			
    			assertEquals(wordsExpected, characterActual.getWords());
			}
		}
    }
    
    @Test
    public void testProcessFileV2() throws FileNotFoundException {
    	String filePath =  getClass().getResource("/screenplayV2.txt").getFile();

    	Set<MovieSetting> result = ProcessingScript.process(filePath);
    	
    	MovieSetting msExpectedRebel = new MovieSetting("REBEL BLOCKADE RUNNER");
    	MovieSetting msExpectedMain = new MovieSetting("MAIN HANGAR DECK");
    	MovieSetting msExpectedMassari = new MovieSetting("MASSASSI OUTPOST");
    	
    	Character cExpectedThreepio = new Character("THREEPIO");
    	cExpectedThreepio.setMovieSetting(msExpectedRebel);
    	List<Word> wordsExpectedThreepio = Arrays.asList(new Word("We're",cExpectedThreepio), 
    			new Word("doomed",cExpectedThreepio), 
    			new Word("There'll",cExpectedThreepio), new Word("be",cExpectedThreepio), 
    			new Word("no",cExpectedThreepio),
    			new Word("escape",cExpectedThreepio), new Word("for",cExpectedThreepio), 
    			new Word("the",cExpectedThreepio), new Word("Princess",cExpectedThreepio),
    			new Word("this"), new Word("time",cExpectedThreepio), new Word("What's",cExpectedThreepio), 
    			new Word("that",cExpectedThreepio));
    	cExpectedThreepio.setWords(new ArrayList<>(wordsExpectedThreepio) );
    	
    	Character cExpectedLeia = new Character("LEIA");
    	cExpectedLeia.setMovieSetting(msExpectedMain);
    	List<Word> wordsExpectedLeia = Arrays.asList(new Word("What's", cExpectedLeia), new Word("wrong", cExpectedLeia), 
    			new Word("He's", cExpectedLeia), new Word("got", cExpectedLeia), new Word("to", cExpectedLeia),
    			new Word("follow", cExpectedLeia), new Word("his", cExpectedLeia), new Word("own", cExpectedLeia),
    			new Word("path", cExpectedLeia));
    	cExpectedLeia.setWords(wordsExpectedLeia);
    	
    	Character cExpectedLuke = new Character("LUKE");
    	cExpectedLuke.setMovieSetting(msExpectedMain);
    	List<Word> wordsExpectedLuke = Arrays.asList(new Word("Oh",cExpectedLuke), new Word("it's",cExpectedLuke), 
    			new Word("Han",cExpectedLuke), new Word("I",cExpectedLuke), new Word("don't",cExpectedLuke), 
    			new Word("know",cExpectedLuke), new Word("I",cExpectedLuke), new Word("really",cExpectedLuke),
    			new Word("thought",cExpectedLuke), new Word("he'd",cExpectedLuke), new Word("change",cExpectedLuke), new Word("his",cExpectedLuke),
    			new Word("mind",cExpectedLuke), new Word("I",cExpectedLuke), new Word("only",cExpectedLuke), 
    			new Word("wish",cExpectedLuke),new Word("Ben",cExpectedLuke), new Word("were",cExpectedLuke), 
    			new Word("here",cExpectedLuke), new Word("Biggs",cExpectedLuke),new Word("Of",cExpectedLuke), 
    			new Word("course",cExpectedLuke), new Word("have",cExpectedLuke), new Word("I",cExpectedLuke),
    			new Word("got",cExpectedLuke), new Word("some",cExpectedLuke), new Word("stories",cExpectedLuke), new Word("to",cExpectedLuke),
    			new Word("tell",cExpectedLuke), new Word("Thank",cExpectedLuke), new Word("you",cExpectedLuke), 
    			new Word("sir",cExpectedLuke), new Word("I'll",cExpectedLuke), new Word("try",cExpectedLuke), 
    			new Word("I",cExpectedLuke), new Word("told",cExpectedLuke), new Word("you",cExpectedLuke), 
    			new Word("I'd",cExpectedLuke), new Word("make",cExpectedLuke), new Word("it",cExpectedLuke),
    			new Word("someday",cExpectedLuke), new Word("Biggs",cExpectedLuke), new Word("Not",cExpectedLuke), new Word("on",cExpectedLuke),
    			new Word("your",cExpectedLuke), new Word("life",cExpectedLuke), new Word("You",cExpectedLuke),
    			new Word("okay",cExpectedLuke), new Word("Artoo",cExpectedLuke));
    	cExpectedLuke.setWords(wordsExpectedLuke);
    	
    	Character cExpectedBiggs = new Character("BIGGS");
    	cExpectedBiggs.setMovieSetting(msExpectedMain);
    	List<Word> wordsExpectedBiggs = Arrays.asList(new Word("Luke",cExpectedBiggs), new Word("I",cExpectedBiggs), 
    			new Word("don't",cExpectedBiggs), new Word("believe",cExpectedBiggs), new Word("it",cExpectedBiggs),
    			new Word("How'd",cExpectedBiggs), new Word("you",cExpectedBiggs), new Word("get",cExpectedBiggs), 
    			new Word("here",cExpectedBiggs),new Word("are",cExpectedBiggs), new Word("you",cExpectedBiggs), 
    			new Word("going",cExpectedBiggs), new Word("out",cExpectedBiggs),
    			new Word("with",cExpectedBiggs), new Word("us",cExpectedBiggs), new Word("Sir",cExpectedBiggs), new Word("Luke",cExpectedBiggs),
    			new Word("is",cExpectedBiggs), new Word("the",cExpectedBiggs), new Word("best",cExpectedBiggs), 
    			new Word("bushpilot",cExpectedBiggs),new Word("in",cExpectedBiggs), new Word("the",cExpectedBiggs), 
    			new Word("outer",cExpectedBiggs), new Word("rim",cExpectedBiggs),
    			new Word("territories",cExpectedBiggs), new Word("I've",cExpectedBiggs), new Word("got",cExpectedBiggs), 
    			new Word("to",cExpectedBiggs), new Word("get",cExpectedBiggs), new Word("aboard",cExpectedBiggs), 
    			new Word("You",cExpectedBiggs), new Word("did",cExpectedBiggs),
    			new Word("all",cExpectedBiggs), new Word("right",cExpectedBiggs));
    	cExpectedBiggs.setWords(wordsExpectedBiggs);
    	
    	Character cExpectedRedLeader = new Character("RED LEADER");
    	List<Word> wordsExpectedRedLeader = Arrays.asList(new Word("Are",cExpectedRedLeader), new Word("you",cExpectedRedLeader), 
    			new Word("Luke",cExpectedRedLeader), new Word("Skywalker",cExpectedRedLeader), new Word("Have",cExpectedRedLeader),
    			new Word("you",cExpectedRedLeader), new Word("been",cExpectedRedLeader), new Word("checked",cExpectedRedLeader), 
    			new Word("out",cExpectedRedLeader),new Word("on",cExpectedRedLeader), new Word("the",cExpectedRedLeader), 
    			new Word("Incom",cExpectedRedLeader), new Word("T-sixty-",cExpectedRedLeader), new Word("five",cExpectedRedLeader),
    			new Word("I",cExpectedRedLeader), new Word("met",cExpectedRedLeader), new Word("your",cExpectedRedLeader), new Word("father",cExpectedRedLeader),
    			new Word("once",cExpectedRedLeader), new Word("when",cExpectedRedLeader), new Word("I",cExpectedRedLeader), 
    			new Word("was",cExpectedRedLeader), new Word("just",cExpectedRedLeader), new Word("a",cExpectedRedLeader), 
    			new Word("boy",cExpectedRedLeader), new Word("he",cExpectedRedLeader),
    			new Word("was",cExpectedRedLeader), new Word("a",cExpectedRedLeader), new Word("great",cExpectedRedLeader), new Word("pilot",cExpectedRedLeader));
    	cExpectedRedLeader.setWords(wordsExpectedRedLeader);
    	
    	
    	cExpectedRedLeader.setMovieSetting(msExpectedMain);
    	Character cExpectedChief = new Character("CHIEF");
    	List<Word> wordsExpectedChief = Arrays.asList(new Word("This"), new Word("R2"), 
    			new Word("unit"), new Word("of"), new Word("your"),
    			new Word("seems"), new Word("a"), new Word("bit"), new Word("beat"),
    			new Word("up"), new Word("Do"), new Word("you"), new Word("want"),
    			new Word("a"), new Word("new"), new Word("one"), new Word("Okay"),
    			new Word("easy"), new Word("she"), new Word("goes"));
    	cExpectedChief.setWords(wordsExpectedChief);
    	cExpectedChief.setMovieSetting(msExpectedMain);
    	
    	Character cExpectedThreepio2 = new Character("THREEPIO");
    	cExpectedThreepio2.setMovieSetting(msExpectedMain);
    	List<Word> wordsExpectedThreepio2 = Arrays.asList(new Word("Hang"), new Word("on"), 
    			new Word("tight"), new Word("Artoo"), new Word("you've"),
    			new Word("got"), new Word("to"), new Word("come"), new Word("back"),
    			new Word("You"), new Word("wouldn't"), new Word("want"), new Word("my"),
    			new Word("life"), new Word("to"), new Word("get"), new Word("boring"),
    			new Word("would"), new Word("you"));
    	cExpectedThreepio2.setWords(wordsExpectedThreepio2);
    	
    	Character cExpectedBenVoice = new Character("BEN'S VOICE");
    	cExpectedBenVoice.setMovieSetting(msExpectedMain);
    	List<Word> wordsExpectedBenVoice = Arrays.asList(new Word("Luke"), new Word("the"), 
    			new Word("Force"), new Word("will"), new Word("be"),
    			new Word("with"), new Word("you"));
    	cExpectedBenVoice.setWords(wordsExpectedBenVoice);
    	
    	
    	Set<Character> cExpectedRebel = new HashSet<>();
    	cExpectedRebel.add(cExpectedThreepio);
    	msExpectedRebel.setCharacters(cExpectedRebel);
    	
    	Set<Character> cExpectedMain = new HashSet<>();
    	cExpectedMain.add(cExpectedLeia);
    	cExpectedMain.add(cExpectedLuke);
    	cExpectedMain.add(cExpectedBiggs);
    	cExpectedMain.add(cExpectedRedLeader);
    	cExpectedMain.add(cExpectedChief);
    	cExpectedMain.add(cExpectedThreepio2);
    	cExpectedMain.add(cExpectedBenVoice);
    	msExpectedMain.setCharacters(cExpectedMain);
    	
    	Set<MovieSetting> moviesSettingExpected = new HashSet<MovieSetting>();
    	moviesSettingExpected.add(msExpectedRebel);
    	moviesSettingExpected.add(msExpectedMassari);
    	moviesSettingExpected.add(msExpectedMain);
    	
    	assertEquals(moviesSettingExpected, result);
    	
    	Map<String, MovieSetting> mapMSExpected = new HashMap<>();
    	mapMSExpected.put(msExpectedRebel.getName(), msExpectedRebel);
    	mapMSExpected.put(msExpectedMain.getName(), msExpectedMain);
    	mapMSExpected.put(msExpectedMassari.getName(), msExpectedMassari);
    	
    	for (MovieSetting msActual : result) {
			MovieSetting msExpected = mapMSExpected.get(msActual.getName());
			assertEquals(msExpected.getCharacters(), msActual.getCharacters());
			
			for (Character cActual : msActual.getCharacters()) {
				if (msActual.equals(msExpectedRebel)) {
					assertEquals(cExpectedThreepio.getWords(), cActual.getWords());
				} else if (msActual.equals(msExpectedMain)) {
					if (cActual.equals(cExpectedBenVoice)) {
						assertEquals(cExpectedBenVoice.getWords(), cActual.getWords());
					} else if (cActual.equals(cExpectedBiggs)) {
						assertEquals(cExpectedBiggs.getWords(), cActual.getWords());
					} else if (cActual.equals(cExpectedChief)) {
						assertEquals(cExpectedChief.getWords(), cActual.getWords());
					} else if (cActual.equals(cExpectedLeia)) {
						assertEquals(cExpectedLeia.getWords(), cActual.getWords());
					} else if (cActual.equals(cExpectedLuke)) {
						assertEquals(cExpectedLuke.getWords(), cActual.getWords());
					} else if (cActual.equals(cExpectedRedLeader)) {
						assertEquals(cExpectedRedLeader.getWords(), cActual.getWords());
					} else if (cActual.equals(cExpectedThreepio2)) {
						assertEquals(cExpectedThreepio2.getWords(), cActual.getWords());
					}
				}
			}
		}
//    	assertEquals(1, result.size());
//    	for (MovieSetting movieSettingActual : result) {
//    		assertEquals(movieSettingExpected, movieSettingActual);
//    		assertEquals(1, movieSettingActual.getCharacters().size());
//    		for (Character characterActual : movieSettingActual.getCharacters()) {
//    			assertEquals(characterExpected, characterActual);
//    			
//    			assertEquals(wordsExpected, characterActual.getWords());
//			}
//		}
    }
    
}

