package org.sdcrafters.bowling;

import java.util.ArrayList;

public class Frame {

	protected ArrayList<Integer> rolls = new ArrayList<>();
	private int frameNumber;
	private int previousScore;

	public Frame(int frameNumber, int previousScore) {
		super();
		this.frameNumber = frameNumber;
		this.previousScore = previousScore;
	}

	protected int getTotalScore() {
		return getFrameScore() + previousScore;
	}

	protected int getFrameScore() {
		return rolls.stream().mapToInt(Integer::intValue).sum();
	}

	protected String printFrameScores() {
		if (frameNumber == 10) {
			String text = "";
			for (int i = 0; i < rolls.size(); i++) {
				text += rolls.get(i) + ",";
			}
			return text.substring(0, text.length() - 1);
		}
		if (isStrike()) {
			return "10 ";
		}

		return rolls.get(0) + "," + rolls.get(1);
	}

	@Override
	public String toString() {
		return String.format("%s) %s [%s] = %s", frameNumber, printFrameScores(), getFrameScore(), getTotalScore());
	}

	public void addRoll(Integer roll) {
		rolls.add(roll);
	}

	public boolean isSpare() {
		return 10 == rolls.get(0) + rolls.get(1);
	}

	public boolean isStrike() {
		return 10 == rolls.get(0);
	}
}