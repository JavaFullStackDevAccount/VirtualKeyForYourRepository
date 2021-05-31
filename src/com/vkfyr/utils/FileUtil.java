package com.vkfyr.utils;

import java.io.File;

public class FileUtil {

	public static boolean fileExists(File fileToCheck) {

		try {

			return fileToCheck.exists() && fileToCheck.isFile();

		} catch (Exception e) {

			return false;
		}

	}

	public static String getFileName(File file) {

		try {

			if (fileExists(file))

				return file.toPath().getFileName().toString();

			return null;

		} catch (Exception e) {

			return null;

		}

	}

}
