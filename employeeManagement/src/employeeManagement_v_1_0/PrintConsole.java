package employeeManagement_v_1_0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrintConsole {
	String path_fileName = "C:\\Users\\NT930QAA\\eclipse-workspace\\employeeList.txt";
	File file = new File(path_fileName);
	String empId = "";

	void printList() {
		ReadOrCreateFile readOrCreateFile = new ReadOrCreateFile();
		empId = readOrCreateFile.readFile().get(readOrCreateFile.readFile().size() - 1);
		if (empId.equals("0")) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} else {
			try {
				FileReader fileReader = new FileReader(file); // �Է� ��Ʈ�� ����
				BufferedReader bufferedReader = new BufferedReader(fileReader); // �Է� ���� ����
				System.out.println("������ȣ" + "\t" + "�̸�");
				System.out.println("==============");
				String readLine = "";
				String[] temp = new String[5];
				while ((readLine = bufferedReader.readLine()) != null) {
					temp = null;
					temp = readLine.split("\t");
					System.out.println(temp[0] + "\t" + temp[1]);
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("��� ��� �������� ������ �߻��߽��ϴ�.");
			}
		}
	}

	void printDetailList() {
		ReadOrCreateFile readOrCreateFile = new ReadOrCreateFile();
		empId = readOrCreateFile.readFile().get(readOrCreateFile.readFile().size() - 1);
		if (empId.equals("0")) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} else {
			try {
				FileReader fileReader = new FileReader(file); // �Է� ��Ʈ�� ����
				BufferedReader bufferedReader = new BufferedReader(fileReader); // �Է� ���� ����
				System.out.println("������ȣ" + "\t" + "�̸�" + "\t" + "��ȭ��ȣ" + "\t" + "����" + "\t" + "�̸���");
				System.out.println("====================================");
				String readLine = "";
				while ((readLine = bufferedReader.readLine()) != null) {
					System.out.println(readLine);
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("�� ��� �������� ������ �߻��߽��ϴ�.");
			}
		}
	}
}
