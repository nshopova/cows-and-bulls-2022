package pu.fmi.cowbull.model;

public class TryInfo {
	private String guessString;
	private int[] guess;
	private int bulls;
	private int cows;

	public int[] getGuess() {
		return guess;
	}

	public void setGuess(int[] guess) {
		this.guess = guess;
	}

	public int getBulls() {
		return bulls;
	}

	public void setBulls(int bulls) {
		this.bulls = bulls;
	}

	public int getCows() {
		return cows;
	}

	public void setCows(int cows) {
		this.cows = cows;
	}

	public String getGuessString() {
		return guessString;
	}

	public void setGuessString(String guessString) {
		this.guessString = guessString;
	}
}
