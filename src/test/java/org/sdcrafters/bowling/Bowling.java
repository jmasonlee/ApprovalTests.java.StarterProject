package org.sdcrafters.bowling;

import java.util.ArrayList;

public class Bowling {

	ArrayList<Frame> frames = new ArrayList<>();

	public void roll(Integer... rolls) {
		int rollIndex = 0;
		int previousScore = 0;
		int frameNumber = 1;
		for (int i = 0; i < 5; i++) {

			Frame frame = new Frame(frameNumber, previousScore);
			frame.addRoll(rolls[rollIndex++]);
			frame.addRoll(rolls[rollIndex++]);

			if (frame.isSpare()) {

				frame.addRoll(rolls[rollIndex]);
			}
			frames.add(frame);
			previousScore = frame.getTotalScore();
			frameNumber++;
		}

	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		for (Frame frame : frames) {
			text.append(frame + "\n");
		}
		return text.toString();
	}

}
