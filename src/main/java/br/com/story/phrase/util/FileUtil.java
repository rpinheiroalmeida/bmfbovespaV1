package br.com.story.phrase.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class FileUtil {

	public static String getContentFile(String path) throws IOException {
		FileInputStream inputStream = new FileInputStream(path);
		String content = "";
		try {
		    content = IOUtils.toString(inputStream);
		} finally {
		    inputStream.close();
		}
		return content;
	}

	public static String getContentFile(URL resource) throws IOException {
		return getContentFile(resource.getFile());
	}

	public static void saveFile(String content, String pathFile) throws IOException {
		File file = new File(pathFile);
		FileUtils.writeStringToFile(file, content);
	}

	public static boolean fileExists(String path) {
		return new File(path).exists();
	}

	public static void removeFile(String pathFileScript) throws IOException {
		if (fileExists(pathFileScript)) {
			FileUtils.forceDelete(new File(pathFileScript));
		}
	}
}
