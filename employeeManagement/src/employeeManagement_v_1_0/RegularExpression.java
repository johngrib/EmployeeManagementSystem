package employeeManagement_v_1_0;

public class RegularExpression {
	final static String patternPhoneNumber = "^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$";
	final static String patternEmail = "(^[0-9a-zA-Z_-]+@[0-9a-zA-Z]+[.][a-zA-Z]{2,4}$)";

	static boolean validationPhoneNumber(String param) {
		if (param.matches(patternPhoneNumber)) {
			System.out.println("�ùٸ� ��ȭ��ȣ �����Դϴ�.");
			return true;
		} else {
			System.out.println("��ȭ��ȣ�� �Է� ���İ� ��ġ���� �ʽ��ϴ�.");
			System.out.println("�ٽ� �Է����ּ���.");
			return false;
		}
	}

	static boolean validationEmail(String param) {
		if (param.matches(patternEmail)) {
			System.out.println("�ùٸ� �̸��� �����Դϴ�.");
			return true;
		} else {
			System.out.println("�̸����� �Է� ���İ� ��ġ���� �ʽ��ϴ�.");
			System.out.println("�ٽ� �Է����ּ���.");
			return false;
		}
	}
}
