package com.vkfyr.storagemanager;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.vkfyr.utils.FileUtil;

public class FileMovementManager {

	public boolean addFileToRootDirectory(File fileToAdd) {

		try {

			if (FileUtil.fileExists(fileToAdd) && RootDirectoryManager.rootDirectoryExists()) {

				File sourceFile = fileToAdd;

				String sourceFileName = FileUtil.getFileName(sourceFile);

				if (sourceFileName != null) {

					File destinationOfFile = new File(
							RootDirectoryManager.getRootDirectoryPath() + "/" + sourceFileName);

					Files.copy(sourceFile.toPath(), destinationOfFile.toPath());

					return true;

				} else {

					throw new Exception("Not a file !!!");

				}

			}

			return false;

		} catch (Exception e) {

			return false;

		}
	}

	public void deleteFileFromRootDirectory(String fileNameToDelete) {

		try {

			File fileToDelete = new File(RootDirectoryManager.getRootDirectoryPath() + "/" + fileNameToDelete);

			if (FileUtil.fileExists(fileToDelete))

				fileToDelete.delete();

			else

				throw new Exception("Problem deleting file");

		} catch (Exception e) {

		}
	}

	public List<String> showAllFiles() {

		try {

			List<String> allFilesInRootDirectory = Arrays.asList(RootDirectoryManager.getRootDirectory().list());

			Collections.sort(allFilesInRootDirectory);

			return allFilesInRootDirectory;

		} catch (Exception e) {

			return new ArrayList<String>();
		}

	}

	public List<String> showFileWithName(String fileName) {

		try {

			return showAllFiles().stream().filter(fileInRootDirectory -> {

				return (fileInRootDirectory.equalsIgnoreCase(fileName)
						|| fileInRootDirectory.toUpperCase().contains(fileName.toUpperCase()));

			}).collect(Collectors.toList());

		} catch (Exception e) {

			return null;

		}
	}

}
