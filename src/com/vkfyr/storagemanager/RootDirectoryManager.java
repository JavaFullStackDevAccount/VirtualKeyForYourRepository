package com.vkfyr.storagemanager;

import java.io.File;
import java.io.FileNotFoundException;

public class RootDirectoryManager {

	private static final String ROOT_DIRECTORY_PATH = "./root";

	public static boolean createRootDirectory() {

		try {

			File rootDirectory = new File(ROOT_DIRECTORY_PATH);

			return rootDirectory.mkdir();

		} catch (Exception e) {

			return false;

		}

	}

	public static boolean rootDirectoryExists() {

		try {

			return !createRootDirectory();

		} catch (Exception e) {

			return false;

		}

	}

	public static File getRootDirectory() {

		try {

			if (rootDirectoryExists())

				return new File(ROOT_DIRECTORY_PATH);

			throw new FileNotFoundException("Root directory not found !!!");

		} catch (Exception e) {

			return null;
		}

	}

	public static String getRootDirectoryPath() {

		return ROOT_DIRECTORY_PATH;

	}

}
