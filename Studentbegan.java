package student;

import java.util.Scanner;

/*
* 
*ѧ������ϵͳ��
*		1.ѧ���ࣺ
*			���ԣ�ID ���� ���� �Ա� �ɼ� 
*			�������⣺
*		
*		2.�༶�ࣺ
*			���ԣ�����
*				����ѧ��������
*			������
*				����ѧ��
*				ͨ��IDɾ��ѧ��
*				ͨ��ID����ѧ��
*				ͨ��ID�޸�ѧ����Ϣ
*				�������䣬�ɼ�������
*				չʾѧ��
*					1.����IDչʾ
*					2.ѡ���Ա�չʾ 
*
*			Ҫ��
*				ʹ�ý��콲���쳣��������
*
*/

public class Studentbegan {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		StudentManagement bm = StudentManagement.getInstance("����ѧԺ");
		System.out.println("��ӭ��¼" + bm.getName() + "��ѧ������ϵͳ");

		// ѡ�������Ϣ
		try {
			System.out.println("�����������ݣ�A:��ʦ��B:ѧ��");
			String ident = sc.nextLine();//���
			if ("a".equalsIgnoreCase(ident)) {
				System.out.println("------���е�ѧ������--------");
				nowStudentFunction(bm);//չʾ���е�ѧ����Ϣ
				bm.idShow();//�����е�ѧ����Ϣչʾ����
				functionSelect(bm);//��ʦ����ѡ��
			} else if ("b".equalsIgnoreCase(ident)) {
				nowStudentFunction(bm);//���е�ѧ����Ϣ
				System.out.println("���������id");
				int id3 = sc.nextInt();
				bm.findStudentInfo(id3);

			} else {
				System.exit(0);
				
			}
		} catch (TheObjectIsNullException e) {
			e.printStackTrace();
		} catch (TheIdIdNullException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void functionSelect(StudentManagement bm) throws TheObjectIsNullException, TheIdIdNullException {

		System.out.println("---------------------------");
		System.out.println("------�����¼��ֹ���-----------");
		System.out.println("------A.����ѧ��-------------");
		System.out.println("------B.ɾ��ѧ��-------------");
		System.out.println("------C.�޸���Ϣ-------------");
		System.out.println("------D.����ѧ��-------------");
		System.out.println("------E.ͨ�������ѧ����������---");
		System.out.println("------F.ͨ���ɼ���ѧ����������---");
		System.out.println("------G.����idչʾѧ����Ϣ-----");
		System.out.println("------H.�����Ա�չʾѧ����Ϣ----");
		System.out.println("------I.�˳�ϵͳ-------------");
		System.out.println("---------------------------");
		while (true) {
			String choose = sc.nextLine();
			switch (choose) {
			case "A":
				addStudentFunction(bm);
				break;
			case "B":
				System.out.println("��������Ҫɾ��ѧ����id");
				int id = sc.nextInt();
				bm.deleteStudent(id);
				functionSelect(bm);

				break;
			case "C":
				System.out.println("��������Ҫ�޸�ѧ����id");
				int id2 = sc.nextInt();
				bm.alterStudent(id2);
				functionSelect(bm);
				break;
			case "D":
				System.out.println("��������Ҫ����ѧ����id");
				int id3 = sc.nextInt();
				bm.findStudentInfo(id3);
				functionSelect(bm);
				break;
			case "E":
				bm.selectSort();
				functionSelect(bm);
				break;
			case "F":
				bm.bubbleSort();
				functionSelect(bm);
				break;
			case "G":
				bm.idShow();
				functionSelect(bm);
				break;
			case "H":
				System.out.println("�������Ա�");
				String sextoo = sc.nextLine();
				bm.sexShow(sextoo);
				functionSelect(bm);
			case "I":
				System.out.println("�����˳�ѧ������ϵͳ");
				System.exit(0);

			}
		}
	}

	// ����ѧ���ĵĺ���
	public static void nowStudentFunction(StudentManagement bm) throws TheObjectIsNullException {
		Student s1 = new Student("����", "��", 92.0, 22);
		Student s2 = new Student("���", "��", 93.0, 24);
		Student s3 = new Student("С��", "��", 90.0, 31);
		Student s4 = new Student("���Ӷ���", "Ů", 86.0, 18);
		Student s5 = new Student("ľͷ", "��", 99.0, 21);
		Student s6 = new Student("����", "��", 95.0, 20);
		Student s7 = new Student("����һ��", "Ů", 82.0, 19);
		Student s8 = new Student("��������", "Ů", 97.0, 24);

		bm.addStudent(s1);
		bm.addStudent(s2);
		bm.addStudent(s3);
		bm.addStudent(s4);
		bm.addStudent(s5);
		bm.addStudent(s6);
		bm.addStudent(s7);
		bm.addStudent(s8);
	}

	// ����ѧ��
	public static void addStudentFunction(StudentManagement bm) throws TheObjectIsNullException, TheIdIdNullException {

		System.out.println("��ֱ�����ѧ�������֡��Ա𡢷����Լ�����");
		System.out.print("������������֣� ");
		String n = sc.next();
		System.out.print("����������Ա� ");
		String s = sc.next();
		System.out.print("��������ĳɼ��� ");
		double g = sc.nextDouble();
		System.out.print("������������䣺 ");
		int a = sc.nextInt();
		bm.addStudent(new Student(n, s, g, a));

		functionSelect(bm);

	}

}