package employeeManagement_v_1_0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertInfo {
	String empId = ""; // �ڵ� ����
	String empNm = "";
	String phoneNumber = "";
	String empJobGrade = "";
	String emailAddr = "";
	String infoInserted = "";

	// ����� �Է�
	Scanner scanner = new Scanner(System.in);

	// ���� ���� ����
	String path_fileName = "C:\\Users\\NT930QAA\\eclipse-workspace\\employeeList.txt";
	File file = new File(path_fileName);

	void insertInfo() {
		System.out.println("���� ������ �Է����ּ���.");
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

		// ���� ���� �о���� - ���� ��ȣ = ���� ��ȣ + 1
		ReadOrCreateFile readOrCreateFile = new ReadOrCreateFile();
		// System.out.println(readOrCreateFile.readFile().size()); // �� Ȯ�� �ʿ�
		empId = readOrCreateFile.readFile().get(readOrCreateFile.readFile().size() - 1);
		empId = String.valueOf((int) Integer.parseInt(empId) + 1);

		// ���� ��ȣ ���� ����: ���� ǥ���� �̿� ���� �ʿ�
		if (Integer.parseInt(empId) < 10) {
			empId = "00" + empId;
		} else if (Integer.parseInt(empId) < 100) {
			empId = "0" + empId;
		} else if (Integer.parseInt(empId) < 1000) {
		}

		infoInserted = empId + "\t" + empNm + "\t" + phoneNumber + "\t" + empJobGrade + "\t" + emailAddr + "\r\n";
		System.out.println("�Էµ� ����: " + infoInserted);

		try {
			FileWriter fileWriter = new FileWriter(file, true); // ��� ��Ʈ�� ����
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // ��� ���� ����

			bufferedWriter.write(infoInserted);
			bufferedWriter.flush(); // �ľ� �ʿ�
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("������ ���� �������� ������ �߻��߽��ϴ�.");
		}
	}
}
