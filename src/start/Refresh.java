package start;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import presentation.hotsport.HotSportPanel;

import common.statics.PathOfFile;

import databaseutility.OneMatch_add;

public class Refresh extends Thread {
	public void run() {
		try {
			final Path dir = FileSystems.getDefault().getPath(PathOfFile.MATCH_INFO);
			final WatchService watchService = dir.getFileSystem().newWatchService();
			final WatchKey watchKey = dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			while (true) {
				String matchName;
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
						matchName = event.context().toString();
						System.out.println(matchName);
						OneMatch_add oneMatch = new OneMatch_add(matchName);
						oneMatch.writeDetailInfoOfPlayerAndTeamToMEN();
						oneMatch.writeGeneralMatchInfo();
						// 第一步应该先将信息写入内存中
						oneMatch.writePlayerPerformToday();// 更新CACHE中的今日球员
						oneMatch.writeTeamNormalInfoToCACHE();// 第二步更新球队的普通数据
						oneMatch.writeTeamHighInfoToCACHE();// 第三步更新球队高级数据
						oneMatch.writePlayerNormalInfoToCACHE();// 第四步更新球员普通数据
						oneMatch.writePlayerHighInfoToCACHE();// 第五步更新球员高级数据//这一步一定是最后做，因为只有有了以上数据才能进行这一步
						HotSportPanel.showNew();
					}
				}
				if (!watchKey.reset()) {
					break;
				}
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
