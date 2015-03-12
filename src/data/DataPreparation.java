package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import common.statics.PathOfFile;
import common.statics.numbers.NUMBER;

public class DataPreparation {

	public void fillMatchInformationOfPlayer() {
		File matchFile = new File(PathOfFile.MATCH_INFO);
		String matchName[] = matchFile.list();
		for (int i = 0; i < matchName.length; i++) {
			try {
				BufferedReader matchReader = new BufferedReader(new FileReader(PathOfFile.MATCH_INFO + matchName[i]));
				String temp;
				String mainInfo = matchReader.readLine();
				String scoresOfEachPart = matchReader.readLine();
				String firstTeam = matchReader.readLine();
				String secondTeam = null;
				for (int j = 0; j < 6; j++) {
					temp = matchReader.readLine();
					this.writeOneMatchOfOnePlayer(temp);
				}
				while ((temp = matchReader.readLine()).length() != 3) {
					this.writeOneMatchOfOnePlayer(temp);
				}
				secondTeam = temp;
				while ((temp = matchReader.readLine()) != null) {
					this.writeOneMatchOfOnePlayer(temp);
				}
				matchReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void writeOneMatchOfOnePlayer(String detailInfo) {
		String[] eachInfoOfOneMatch;
		eachInfoOfOneMatch = detailInfo.split(";");
		String nameOfPlayer = eachInfoOfOneMatch[0];
		try {
			BufferedWriter matchWriter = new BufferedWriter(new FileWriter(PathOfFile.PLAYER_INFO + nameOfPlayer, true));
			matchWriter.write(detailInfo + "\n");
			matchWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void handleFileOfTeam() {
		try {
			BufferedReader teamReader = new BufferedReader(new FileReader(PathOfFile.TEAM_INFO + "teams"));
			teamReader.readLine();
			String formatdetail;
			for (int i = 0; i < NUMBER.NUMBER_OF_TEAM; i++) {
				formatdetail = teamReader.readLine();
				System.out.println(formatdetail);
				this.createAndWriteFile(formatdetail);
			}
			teamReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void createAndWriteFile(String formatdetail) {
		String[] part;
		String teamNameForShort;
		part = formatdetail.split("│");
		for (int i = 0; i < part.length; i++) {
			System.out.println(part[i]);
		}
		teamNameForShort = part[1].trim();
		String path = PathOfFile.TEAM_INFO + teamNameForShort;
		System.out.println(path);
		File teamFile = new File(path);
		if (!teamFile.exists()) {
			try {
				teamFile.createNewFile();
				BufferedWriter writerTeam = new BufferedWriter(new FileWriter(path, true));
				writerTeam.write(formatdetail.trim());
				writerTeam.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String arg[]) {
		new DataPreparation().handleFileOfTeam();
	}
}
