package com.vkfyr.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.vkfyr.storagemanager.FileMovementManager;

public class MainMenuController {

	private static final String PROJECT_NAME = "LockedMe.com (Prototype)";

	private static final String DEVELOPER_NAME = "Dev";

	private static final String COMPANY_NAME = "Company Lockers Pvt. Ltd";

	private static String getWelcomeText() {

		StringBuilder welcomeText = new StringBuilder();

		welcomeText.append("-------------------------------------------------------\n");

		welcomeText.append("Project name :- ");

		welcomeText.append(PROJECT_NAME);

		welcomeText.append("\n");

		welcomeText.append("Company name:- ");

		welcomeText.append(COMPANY_NAME);

		welcomeText.append("\n");

		welcomeText.append("Developer details :- ");

		welcomeText.append("\n");

		welcomeText.append("\t\t\tName:- ");

		welcomeText.append(DEVELOPER_NAME);

		welcomeText.append("\n-------------------------------------------------------\n");

		return welcomeText.toString();

	}

	private static String getMainMenuText() {

		StringBuilder mainMenu = new StringBuilder();

		mainMenu.append("\nMain menu\n");

		mainMenu.append("1. Show all files\n2. Search file\n3. Add file\n4. Delete file\n*. Exit\n");

		mainMenu.append("Select an option: ");

		return mainMenu.toString();

	}

	public static void getMenu() {

		try {

			System.out.println(getWelcomeText());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			FileOperationsController fileOperationsController = new FileOperationsController();

			while (true) {

				System.out.println(getMainMenuText());

				// 1. Show all files 2. Search file 3. Add file 4. Delete file *. Exit

				switch (Integer.parseInt(br.readLine())) {

				case 1:
					fileOperationsController.showAllFiles();
					break;

				case 2:
					fileOperationsController.searchFile();
					break;

				case 3:
					fileOperationsController.addFile();
					break;

				case 4:
					fileOperationsController.deleteFile();
					break;

				default:
					throw new Exception("Exit");

				}

			}

		} catch (Exception e) {

			System.out.println("\n!!! Exit !!!\n");

		}

	}

}
