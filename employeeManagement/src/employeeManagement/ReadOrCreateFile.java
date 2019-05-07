package employeeManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadOrCreateFile {
	String path_fileName = "C:\\Users\\NT930QAA\\eclipse-workspace\\employeeList.txt";
	File file = new File(path_fileName);

	// �޼ҵ� ���� ������ �ʱ�ȭ�Ǹ� �� ��
	static ArrayList<String> empIdList = new ArrayList<String>();

	// ���� ���� ���� Ȯ��
	boolean existFileTest() {
		if (file.isFile()) {
			System.out.println("������ �����մϴ�.");
			return true;
		} else {
			System.out.println("������ �������� �ʽ��ϴ�.");
			return false;
		}
	}

	// ���� ����
	void createFile() {
		try {
			if (file.createNewFile()) {
				System.out.println("������ �����Ǿ����ϴ�.");
			} else {
				System.out.println("������ �������� ���߽��ϴ�.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("������ �����ϴ� �������� ������ �߻��߽��ϴ�.");
		}
	}

	// ���� �б� - ��� ��ȣ ��� �迭 ����
	// �� ��ȣ�� ��� ��ȣ�� �ٸ� �� �ֱ� ������ ����
	ArrayList<String> readFile() {
		// try-catch�� �޼ҵ� �� ��� �Ұ�(��ü �޼ҵ� �� ���� ����)
		try {
			FileReader fileReader = new FileReader(file); // �Է� ��Ʈ�� ����
			BufferedReader bufferedReader = new BufferedReader(fileReader); // �Է� ���� ����

			String readLine = "";
			String[] temp;

			if ((readLine = bufferedReader.readLine()) == null) {
				// �� �ٵ� ���� ���
				empIdList.add("0");
				bufferedReader.close();
				return empIdList;
			} else {
				// �� �� �̻� �ִ� ���
				do {
					// readLine()�� ���� ���� ���ڸ� �������� �ʴ´�.
					// System.out.println(readLine);
					temp = readLine.split("\t");
					empIdList.add(temp[0]);
				} while ((readLine = bufferedReader.readLine()) != null);
				bufferedReader.close();
				return empIdList;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("������ �д� �������� ������ �߻��߽��ϴ�.");
			return null; // ���� �ʿ�
		}
	}
}
