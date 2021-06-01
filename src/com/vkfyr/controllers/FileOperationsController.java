package com.vkfyr.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import com.vkfyr.storagemanager.FileMovementManager;

public class FileOperationsController {

	private final FileMovementManager fileManager;

	public FileOperationsController() {

		this.fileManager = new FileMovementManager();

	}

	private void showMessage(String message, boolean isError) {

		if (isError)
			System.out.println("\n!!!! " + message);
		else
			System.out.println("\n---> " + message);
	}

	public void showAllFiles() {

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("\nShow all files menu\n1. Show all files\n*.Go back\nSelect an option:");

			if (Integer.parseInt(br.readLine()) == 1) {

				List<String> allFiles = fileManager.showAllFiles();

				if (allFiles.size() <= 0) {

					showMessage("Directory empty ", false);

				} else {

					System.out.println("- root");

					allFiles.forEach(fileNameInRootDirectory -> {

						System.out.println("   - " + fileNameInRootDirectory);

					});

				}
			} else {
				
				throw new Exception("Go to main menu");
				
			}

		} catch (Exception e) {

			showMessage("Back to main menu", false);

		}

	}

	public void addFile() {

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("\nAdd file menu\n1. Add file path\n*.Go back\nSelect an option:");

			if (Integer.parseInt(br.readLine()) == 1) {

				System.out.print("Enter path of file to add :- ");

				if (this.fileManager.addFileToRootDirectory(new File(br.readLine()))) {

					showMessage("File added successfully", false);

				} else {

					showMessage(
							"Unable to add file\n\tReasons:\n\tThis file already exists (or)\n\tFile dose not exists",
							true);

				}

			} else {

				throw new Exception("Add file exit");

			}

		} catch (Exception e) {

			showMessage("Back to main menu", false);

		}
	}

	public void deleteFile() {

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("\nDelete file menu\n1. Delete file\n*.Go back\nSelect an option:");

			if (Integer.parseInt(br.readLine()) == 1) {

				System.out.print("Enter file name to delete (Case Sensitive) :- ");

				this.fileManager.deleteFileFromRootDirectory(br.readLine());

				showMessage("File deleted successfully", false);

			} else {

				throw new Exception("Delete file exit");

			}

		} catch (Exception e) {

			showMessage("Back to main menu", false);

		}
	}

	public void searchFile() {

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("\nSearch file menu\n1. Search file\n*.Go back\nSelect an option:");

			if (Integer.parseInt(br.readLine()) == 1) {

				System.out.print("Enter file name to search :- ");

				List<String> filesFound = this.fileManager.showFileWithName(br.readLine());

				if (filesFound.size() == 0) {

					showMessage("File not found", true);

				} else {

					showMessage(filesFound.size() + " File(s) found ", false);

					filesFound.forEach(fileName -> {

						System.out.println("  - " + fileName);

					});

				}

			} else {

				throw new Exception("Search file exit");

			}

		} catch (Exception e) {

			showMessage("Back to main menu", false);

		}
	}

}
