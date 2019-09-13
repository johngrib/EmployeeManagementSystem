package employeeManagement_v_1_0;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// ���� ���� ���� Ȯ��
		ReadOrCreateFile readOrCreateFile = new ReadOrCreateFile();
		if (readOrCreateFile.existFileTest()) {
			// ���� �����ϴ� ��� - ���� ���� �о����
			readOrCreateFile.readFile();
		} else {
			// ���� �������� �ʴ� ��� - ���� ����
			readOrCreateFile.createFile();
		}

		Scanner scanner = new Scanner(System.in);
		int menuInput;
		do {
			// ���α׷� ����
			System.out.println("�ܼ� �޴� ����");
			System.out.println("0. ����");
			System.out.println("1. ���� ���� �Է�");
			System.out.println("2. ���� ����Ʈ");
			System.out.println("3. ���� �� ���� ���");
			System.out.println("4. ���� ���� ����");
			System.out.println("5. ���� ���� ����");
			System.out.print("���� �޴�: ");
			menuInput = scanner.nextInt();

			switch (menuInput) {
			case 0:
				System.out.println("���α׷� ����");
				System.exit(0);
				// break;
			case 1:
				InsertInfo insertInfo = new InsertInfo();
				insertInfo.insertInfo();
				break;
			case 2:
				PrintConsole printConsole1 = new PrintConsole();
				printConsole1.printList();
				break;
			case 3:
				PrintConsole printConsole2 = new PrintConsole();
				printConsole2.printDetailList();
				break;
			case 4:
				ReviseOrDeleteInfo reviseOrDeleteInfo1 = new ReviseOrDeleteInfo();
				reviseOrDeleteInfo1.reviseInfo();
				reviseOrDeleteInfo1.fromDummyToFile();
				break;
			case 5:
				ReviseOrDeleteInfo reviseOrDeleteInfo2 = new ReviseOrDeleteInfo();
				reviseOrDeleteInfo2.deleteInfo();
				reviseOrDeleteInfo2.fromDummyToFile();
				break;
			default:
				System.out.println("0~5������ ���ڸ� �Է����ּ���.");
				break;
			}
		} while (!(menuInput == 0));
		scanner.close();
	}

}
