package student;

import java.util.Scanner;

/*
* 
*学生管理系统：
*		1.学生类：
*			属性：ID 姓名 年龄 性别 成绩 
*			方法随意：
*		
*		2.班级类：
*			属性：名字
*				保存学生的数组
*			方法：
*				增加学生
*				通过ID删除学生
*				通过ID查找学生
*				通过ID修改学生信息
*				按照年龄，成绩，排序
*				展示学生
*					1.按照ID展示
*					2.选择性别展示 
*
*			要求：
*				使用今天讲的异常处理！！！
*
*/

public class Studentbegan {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		StudentManagement bm = StudentManagement.getInstance("逗比学院");
		System.out.println("欢迎登录" + bm.getName() + "的学生管理系统");

		// 选择身份信息
		try {
			System.out.println("请输入你的身份：A:教师，B:学生");
			String ident = sc.nextLine();//身份
			if ("a".equalsIgnoreCase(ident)) {
				System.out.println("------现有的学生如下--------");
				nowStudentFunction(bm);//展示现有的学生信息
				bm.idShow();//将现有的学生信息展示出来
				functionSelect(bm);//教师功能选择
			} else if ("b".equalsIgnoreCase(ident)) {
				nowStudentFunction(bm);//现有的学生信息
				System.out.println("请输入你的id");
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
		System.out.println("------有如下几种功能-----------");
		System.out.println("------A.增加学生-------------");
		System.out.println("------B.删除学生-------------");
		System.out.println("------C.修改信息-------------");
		System.out.println("------D.查找学生-------------");
		System.out.println("------E.通过年龄对学生进行排序---");
		System.out.println("------F.通过成绩对学生进行排序---");
		System.out.println("------G.按照id展示学生信息-----");
		System.out.println("------H.按照性别展示学生信息----");
		System.out.println("------I.退出系统-------------");
		System.out.println("---------------------------");
		while (true) {
			String choose = sc.nextLine();
			switch (choose) {
			case "A":
				addStudentFunction(bm);
				break;
			case "B":
				System.out.println("请输入你要删除学生的id");
				int id = sc.nextInt();
				bm.deleteStudent(id);
				functionSelect(bm);

				break;
			case "C":
				System.out.println("请输入你要修改学生的id");
				int id2 = sc.nextInt();
				bm.alterStudent(id2);
				functionSelect(bm);
				break;
			case "D":
				System.out.println("请输入你要查找学生的id");
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
				System.out.println("请输入性别：");
				String sextoo = sc.nextLine();
				bm.sexShow(sextoo);
				functionSelect(bm);
			case "I":
				System.out.println("你已退出学生管理系统");
				System.exit(0);

			}
		}
	}

	// 现有学生的的函数
	public static void nowStudentFunction(StudentManagement bm) throws TheObjectIsNullException {
		Student s1 = new Student("何力", "男", 92.0, 22);
		Student s2 = new Student("马灿", "男", 93.0, 24);
		Student s3 = new Student("小三", "男", 90.0, 31);
		Student s4 = new Student("妹子二号", "女", 86.0, 18);
		Student s5 = new Student("木头", "男", 99.0, 21);
		Student s6 = new Student("耿青", "男", 95.0, 20);
		Student s7 = new Student("妹子一号", "女", 82.0, 19);
		Student s8 = new Student("妹子三号", "女", 97.0, 24);

		bm.addStudent(s1);
		bm.addStudent(s2);
		bm.addStudent(s3);
		bm.addStudent(s4);
		bm.addStudent(s5);
		bm.addStudent(s6);
		bm.addStudent(s7);
		bm.addStudent(s8);
	}

	// 增加学生
	public static void addStudentFunction(StudentManagement bm) throws TheObjectIsNullException, TheIdIdNullException {

		System.out.println("请分别输入学生的名字、性别、分数以及年龄");
		System.out.print("请输入你的名字： ");
		String n = sc.next();
		System.out.print("请输入你的性别： ");
		String s = sc.next();
		System.out.print("请输入你的成绩： ");
		double g = sc.nextDouble();
		System.out.print("请输入你的年龄： ");
		int a = sc.nextInt();
		bm.addStudent(new Student(n, s, g, a));

		functionSelect(bm);

	}

}