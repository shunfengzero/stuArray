package student;

import java.util.Arrays;
import java.util.Scanner;

// ѧ������
class StudentManagement {
	private String name;
	private static StudentManagement s = null;// �����ַ
	private static int count = 0;

	Student[] student;// ����ѧ��������

	private StudentManagement(String name) {
		this.name = name;
		student = new Student[3];// �ȴ���һ���ܹ�����10��ѧ��������
	}

	public String getName() {
		return name;
	}

	public static StudentManagement getInstance(String name) {
		if (s == null) {
			s = new StudentManagement(name);
		}

		return s;
	}

	/*
	 * ����ѧ��
	 */
	public void addStudent(Student s) throws TheObjectIsNullException {

		if (s == null) {
			throw new TheObjectIsNullException("������Ϊ��");
		}

		if (student[this.student.length - 1] != null) {// ����������ˣ�����������һλ���ǿյ�
			student = grow();
		}

		for (int i = 0; i < this.student.length; i++) {
			if (student[i] == null) {// �ж������λ�ǿյ�˵�����Ը�ֵ
				student[i] = s;
				count++;// �������������Ƿ�װ��
				break;
			}
		}

	}

	/*
	 * ��������
	 */
	public Student[] grow() {
		// ������ĳ���
		int newLength = this.student.length + (this.student.length >> 1);
		// �����µ�����
		Student[] newStudent = new Student[newLength];
		// ��������
		newStudent = Arrays.copyOf(this.student, newLength);

		// ������ֵ
		/*
		 * for (int i = 0; i < this.student.length; i++) { newStudent[i] = student[i]; }
		 */
		return newStudent;

	}

	/*
	 * ͨ��IDɾ��ѧ��
	 */

	public void deleteStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > count) {
			throw new TheIdIdNullException("���ɾ����id���Ϸ�");
		}

		int index = findStudent(id);
			if (index !=-1) {
		for (int i = index; i < count - 1; i++) {// ��������
			this.student[i] = this.student[i + 1];

		}
		this.student[this.student.length - 1] = null;
		count--;
	} else {
		System.out.println("ɾ��ʧ��");
		
	}
	}

	/*
	 * ͨ��ID����ѧ��
	 */
	public int findStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > count) {
			throw new TheIdIdNullException("������ҵ�id���Ϸ�");
		}

		int index = -1;
		for (int i = 0; i < count; i++) {
			if (this.student[i].getId() == id) {
				index = i;
			}

		}
		return index;
	}

	// չʾ����id��ѧ����Ϣ
	public void findStudentInfo(int id) throws TheIdIdNullException {

		if (id <= 0 || id > count) {
			throw new TheIdIdNullException("������ҵ�id���Ϸ�");
		}
		int index = findStudent(id);
		if (index != -1) {
		System.out.println("����ѧ������Ϣ����");
		System.out.println("ѧ�������� " + this.student[index].getName() + " ���䣺 " + this.student[index].getAge() + " �Ա� "
				+ this.student[index].getSex() + " �ɼ��� " + this.student[index].getGrade());
	} else {
		System.out.println("û�����ѧ��");
	}
	}

	/*
	 * ͨ��Id�޸�ѧ������Ϣ
	 */
	public void alterStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > count) {
			throw new TheIdIdNullException("������ҵ�id���Ϸ�");
		}

		int index = findStudent(id);
		
		if (index != -1) {
		Scanner sc = new Scanner(System.in);
		int flag = 1;

		while (true) {
			System.out.println("��ѧ������Ϣ����");
			System.out.println("������ " + this.student[index].getName());
			System.out.println("�Ա� " + this.student[index].getSex());
			System.out.println("�ɼ��� " + this.student[index].getGrade());
			System.out.println("���䣺 " + this.student[index].getAge());
			System.out.println("�����������޸ĵ���Ϣ��1.����; 2.�Ա�; 3. �ɼ�; 4.����; 5.�˳�");
			int select = sc.nextInt();
			switch (select) {

			case 1:
				System.out.println("�����������޸ĵ�����");
				String newName = sc.next();
				this.student[index].setName(newName);
				break;
			case 2:
				System.out.println("���������޸ĵ��Ա�");
				String newSex = sc.next();
				this.student[index].setSex(newSex);
				break;
			case 3:
				System.out.println("�����������ȷ�ĳɼ�");
				double newGrade = sc.nextDouble();
				this.student[index].setGrade(newGrade);
				break;
			case 4:
				System.out.println("�����������ȷ������");
				int newAge = sc.nextInt();
				this.student[index].setAge(newAge);
				break;
			case 5:
				flag = 0;
				break;

			}
			if (flag == 0) {
				break;
			}

		}
		} else {
			System.out.println("û�����ѧ��");
		}
	}

	// ѡ������ ������������
	public void selectSort() {
		//Ϊ�˲�Ӱ��id�İ󶨣�������Ҫ�½�һ���µ����齫�ɵ����鸳ֵ���µ����飬Ȼ��չʾ�µ�����
		int newLength = count;
		Student[] stu = new Student[newLength];

		stu = Arrays.copyOf(student, newLength);
		for (int i = 0; i < count - 1; i++) {
			int index = i;
			for (int j = i + 1; j < count; j++) {
				if (this.student[index].getAge() > this.student[j].getAge()) {
					index = j;// ��¼��Сֵ���±�
				} // if
			} // for
			if (index != i) {
				Student temp = stu[index];
				stu[index] = stu[i];
				stu[i] = temp;
			}
		}
		// ����
		for (int i = 0; i < count; i++) {
			System.out.println(" ѧ��Id " + stu[i].getId() + " ѧ�������� " + stu[i].getName() + " ���䣺 " + stu[i].getAge()
					+ " �Ա� " + stu[i].getSex() + " �ɼ��� " + stu[i].getGrade());
		}

	}

	// ð������ ���ճɼ�����
	public void bubbleSort() {
		int newLength = count;
		Student[] stu = new Student[newLength];

		stu = Arrays.copyOf(student, newLength);

		int flag = 1;
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - 1 - i; j++) {
				if (stu[j].getGrade() < stu[j + 1].getGrade()) {
					Student temp = stu[j];
					stu[j] = stu[j + 1];
					stu[j + 1] = temp;

					flag = 0;
				}
			} // for
			if (flag == 1) {
				break;
			}
			flag = 1;

		} // for

		// ����
		for (int i = 0; i < count; i++) {
			System.out.println(" ѧ��Id " + stu[i].getId() + " ѧ�������� " + stu[i].getName() + " ���䣺 " + stu[i].getAge()
					+ " �Ա� " + stu[i].getSex() + " �ɼ��� " + stu[i].getGrade());
		}

	}

	/*
	 * չʾѧ�� 1.����IDչʾ 2.ѡ���Ա�չʾ
	 */
	// ����IDչʾ
	public void idShow() {

		
		// ����
		for (int i = 0; i < count; i++) {
			System.out.println(" ѧ��Id " + this.student[i].getId() + " ѧ�������� " + this.student[i].getName() + " ���䣺 "
					+ this.student[i].getAge() + " �Ա� " + this.student[i].getSex() + " �ɼ��� "
					+ this.student[i].getGrade());
		}

	}

	// 2ѡ���Ա�չʾ
	public void sexShow(String sex) {
		
		int newLength = count;
		Student[] stu = new Student[newLength];

		stu = Arrays.copyOf(student, newLength);

		for (int i = 0; i < count; i++) {
			if (sex.equals(this.student[i].getSex())) {
				System.out.println("ѧ��Id " + stu[i].getId() + " ѧ�������� " + stu[i].getName() + " ���䣺 "
						+ stu[i].getAge() + " �Ա� " + stu[i].getSex() + " �ɼ��� "
						+ stu[i].getGrade());
			}
		}

	}

}
