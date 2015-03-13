package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import common.statics.NUMBER;
import common.statics.PathOfFile;

public class DataPreparation {
	public DataPreparation() {
		this.handleFileOfTeam();
		this.handleFileOfMatch();
	}

	private void handleFileOfTeam() {
		try {
			BufferedReader teamReader = new BufferedReader(new FileReader(PathOfFile.TEAM_INFO + "teams"));
			teamReader.readLine();
			String formatdetail;
			for (int i = 0; i < NUMBER.NUMBER_OF_TEAM; i++) {
				formatdetail = teamReader.readLine();
				System.out.println(formatdetail);
				this.createAndWriteFileOfTeam(formatdetail);
			}
			teamReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// 创建球队信息文件，并写入球队基本信息

	private void handleFileOfMatch() {
		File matchFile = new File(PathOfFile.MATCH_INFO);
		String matchName[] = matchFile.list();
		for (int i = 0; i < matchName.length; i++) {
			OneMatch match = new OneMatch(matchName[i]);
			match.writeDetailInfoOfPlayerAndTeamToTxt();
		}
	}

	private void createAndWriteFileOfTeam(String formatdetail) {
		String[] part;
		String teamNameForShort;
		part = formatdetail.split("│");
		teamNameForShort = part[1].trim();
		String path = PathOfFile.TEAM_INFO + teamNameForShort;
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

}
