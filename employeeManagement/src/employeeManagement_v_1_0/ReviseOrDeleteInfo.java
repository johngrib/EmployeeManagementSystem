package employeeManagement_v_1_0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReviseOrDeleteInfo {
	int inputEmpId;

	String empId = "";
	String empNm = "";
	String phoneNumber = "";
	String empJobGrade = "";
	String emailAddr = "";

	String path_fileName = "C:\\Users\\NT930QAA\\eclipse-workspace\\employeeList.txt";
	String path_dummyFileName = "C:\\Users\\NT930QAA\\eclipse-workspace\\temp.txt";
	File file = new File(path_fileName);
	File dummyFile = new File(path_dummyFileName);

	// ����� �Է� - ���� ��ȣ
	Scanner scanner = new Scanner(System.in);

	void reviseInfo() {
		ReadOrCreateFile readOrCreateFile = new ReadOrCreateFile();
		empId = readOrCreateFile.readFile().get(readOrCreateFile.readFile().size() - 1);
		if (empId.equals("0")) {
			// ���� ���� ��
			System.out.println("������ �������� �ʾ� ������ ������ �����ϴ�.");
		} else {
			// ���� ���� ��
			System.out.print("������ ���� ��ȣ: ");
			inputEmpId = scanner.nextInt();

			try {
				if (dummyFile.createNewFile()) {
					System.out.println("���� ������ �����Ǿ����ϴ�.");
				} else {
					System.out.println("���� ������ �������� ���߽��ϴ�.");
				}
				FileReader fileReader = new FileReader(file); // �Է� ��Ʈ�� ����
				BufferedReader bufferedReader = new BufferedReader(fileReader); // �Է� ���� ����
				FileWriter fileWriter = new FileWriter(dummyFile, true); // ��� ��Ʈ�� ����
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // ��� ���� ����

				String readLine = "";
				String reviseLine = "";
				String temp;
				while ((readLine = bufferedReader.readLine()) != null) {
					// readLine()�� ���� ���� ���ڸ� �������� �ʴ´�.
					temp = readLine.split("\t")[0];

					if (inputEmpId == Integer.parseInt(temp)) {
						// ���� ��� - ���� ���� ���� ���� ���� �Է�
						System.out.println("���� ���� ����: " + readLine);
						System.out.print("�̸�: ");
						empNm = scanner.next();
						System.out.print("��ȭ��ȣ: ");
						do {
							phoneNumber = scanner.next();
						} while (!(RegularExpression.validationPhoneNumber(phoneNumber)));
						System.out.print("����: ");
						empJobGrade = scanner.next();
						System.out.print("�̸���: ");
						do {
							emailAddr = scanner.next();
						} while (!(RegularExpression.validationEmail(emailAddr)));

						reviseLine = temp + "\t" + empNm + "\t" + phoneNumber  + "\t" + empJobGrade + "\t" + emailAddr + "\r\n";
						System.out.println("������ ����: " + reviseLine);

						bufferedWriter.write(reviseLine);
					} else {
						// �ٸ� ��� - ���� ���� ���� ���� ���� ���� ����
						readLine = readLine + "\r\n";

						bufferedWriter.write(readLine);
					}
				}
				bufferedReader.close();
				bufferedWriter.flush();
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("������ �����ϴ� �������� ������ �߻��߽��ϴ�.");
			}
		}
	}

	void deleteInfo() {
		ReadOrCreateFile readOrCreateFile = new ReadOrCreateFile();
		empId = readOrCreateFile.readFile().get(readOrCreateFile.readFile().size() - 1);
		if (empId.equals("0")) {
			// ���� ���� ��
			System.out.println("������ �������� �ʾ� ������ ������ �����ϴ�.");
		} else {
			// ���� ���� ��
			System.out.print("������ ���� ��ȣ: ");
			inputEmpId = scanner.nextInt();

			try {
				if (dummyFile.createNewFile()) {
					System.out.println("���� ������ �����Ǿ����ϴ�.");
				} else {
					System.out.println("���� ������ �������� ���߽��ϴ�.");
				}

				FileReader fileReader = new FileReader(file); // �Է� ��Ʈ�� ����
				BufferedReader bufferedReader = new BufferedReader(fileReader); // �Է� ���� ����
				FileWriter fileWriter = new FileWriter(dummyFile, true); // ��� ��Ʈ�� ����
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // ��� ���� ����

				String readLine = "";
				String temp;
				while ((readLine = bufferedReader.readLine()) != null) {
					// readLine()�� ���� ���� ���ڸ� �������� �ʴ´�.
					temp = readLine.split("\t")[0];

					if (inputEmpId == Integer.parseInt(temp)) {
						// ���� ��� - ���� ���� ���� ���� ���� �Է�
						// bufferedWriter.write("\r\n");
						System.out.println("���� ���� ����: " + readLine);
					} else {
						// �ٸ� ��� - ���� ���� ���� ���� ���� ���� ����
						readLine = readLine + "\r\n";

						bufferedWriter.write(readLine);
					}
				}
				bufferedReader.close();
				bufferedWriter.flush();
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("������ �����ϴ� �������� ������ �߻��߽��ϴ�.");
			}
		}
	}

	void fromDummyToFile() {
		ReadOrCreateFile readOrCreateFile = new ReadOrCreateFile();
		empId = readOrCreateFile.readFile().get(readOrCreateFile.readFile().size() - 1);
		if (empId.equals("0")) {
			// ���� ���� ��
			System.out.println("������ �������� �ʾ� ���� ���� ���ʿ��մϴ�.");
		} else {
			// ���� ���� ��
			try {
				if (file.delete()) {
					file.createNewFile();
					System.out.println("������ �ʱ�ȭ �Ǿ����ϴ�.");
				} else {
					System.out.println("������ �ʱ�ȭ���� ���߽��ϴ�.");
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("������ �ʱ�ȭ�ϴ� �������� ������ �߻��߽��ϴ�.");
			}

			try {
				FileReader fileReader = new FileReader(dummyFile); // �Է� ��Ʈ�� ����
				BufferedReader bufferedReader = new BufferedReader(fileReader); // �Է� ���� ����
				FileWriter fileWriter = new FileWriter(file, true); // ��� ��Ʈ�� ����
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // ��� ���� ����

				String readLine = "";
				while ((readLine = bufferedReader.readLine()) != null) {
					readLine = readLine + "\r\n";
					bufferedWriter.write(readLine);
				}
				bufferedReader.close();
				bufferedWriter.flush();
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("���� ������ �����ϴ� �������� ������ �߻��߽��ϴ�.");
			}

			// ���� ���� ����
			if (dummyFile.delete()) {
				System.out.println("���� ���� ������ �����߽��ϴ�.");
			} else {
				System.out.println("���� ���� ������ �����߽��ϴ�.");
			}
		}
	}
}
