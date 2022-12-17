//Name - Parth Mehta
//This class creates the prompt and multiple choices for the users.
public class Prompt {
	//This is a list of prompts that will be randomly selected.
	private String[] words;
	//This is the array of answer choices for the users with one correct answer and two bad ones.
	private String[] answerChoices;
	//This is the actual prompt that will be returned later on.
	private String word;
	//This is the location in the answerChoices array for the correct prompt.
	private int wordSite = (int) (Math.random() * (2 - 0)) + 0;
	//This is the constructor for the prompt class.
	public Prompt() {
		words = new String[] {"House", "Car","Dog","Cat","Light Bulb","Phone","Rocket","Flag","Train","Flamingo"};
		answerChoices = new String[3];
	}
	//This sets the prompt and creates the answer choices as well.
	//This class does both and are not separate because they have to be connected and
	//interact together.
	public void setPrompt() {
		word = words[(int) (Math.random() * (9 - 0)) + 0];
		answerChoices[wordSite] = word;
		if ( wordSite == 0) {
			answerChoices[1] = words[(int) (Math.random() * (9 - 0)) + 0];
			answerChoices[2] = words[(int) (Math.random() * (9 - 0)) + 0];
			if (answerChoices[1].equals(word)) {
				answerChoices[1] = words[(int) (Math.random() * (9 - 0)) + 0];
			}
			if (answerChoices[2].equals(word)) {
				answerChoices[2] = words[(int) (Math.random() * (9 - 0)) + 0];
			}
		}else if( wordSite == 1) {
			answerChoices[0] = words[(int) (Math.random() * (9 - 0)) + 0];
			answerChoices[2] = words[(int) (Math.random() * (9 - 0)) + 0];
			if (answerChoices[0].equals(word)) {
				answerChoices[0] = words[(int) (Math.random() * (9 - 0)) + 0];
			}
			if (answerChoices[2].equals(word)) {
				answerChoices[2] = words[(int) (Math.random() * (9 - 0)) + 0];
			}
		}else if( wordSite == 2) {
			answerChoices[0] = words[(int) (Math.random() * (9 - 0)) + 0];
			answerChoices[1] = words[(int) (Math.random() * (9 - 0)) + 0];
			if (answerChoices[0].equals(word)) {
				answerChoices[0] = words[(int) (Math.random() * (9 - 0)) + 0];
			}
			if (answerChoices[1].equals(word)) {
				answerChoices[1] = words[(int) (Math.random() * (9 - 0)) + 0];
			}
		}
	}
	//This returns the prompt.
	public String getPrompt() {
		return word;
	}
	//This returns the answer choices array.
	public String[] getChoices() {
		return answerChoices;
	}
}
