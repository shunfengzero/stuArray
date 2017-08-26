package student;

import java.util.Arrays;
import java.util.Scanner;

// 学生管理
class StudentManagement {
	private String name;
	private static StudentManagement s = null;// 保存地址
	private static int count = 0;

	Student[] student;// 保存学生的数组

	private StudentManagement(String name) {
		this.name = name;
		student = new Student[3];// 先创建一个能够保存10个学生的数组
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
	 * 增加学生
	 */
	public void addStudent(Student s) throws TheObjectIsNullException {

		if (s == null) {
			throw new TheObjectIsNullException("对象不能为空");
		}

		if (student[this.student.length - 1] != null) {// 如果数组满了，则数组的最后一位不是空的
			student = grow();
		}

		for (int i = 0; i < this.student.length; i++) {
			if (student[i] == null) {// 判断如果该位是空的说明可以赋值
				student[i] = s;
				count++;// 用来计数数组是否装满
				break;
			}
		}

	}

	/*
	 * 数组增长
	 */
	public Student[] grow() {
		// 新书组的长度
		int newLength = this.student.length + (this.student.length >> 1);
		// 创建新的数组
		Student[] newStudent = new Student[newLength];
		// 拷贝数组
		newStudent = Arrays.copyOf(this.student, newLength);

		// 遍历赋值
		/*
		 * for (int i = 0; i < this.student.length; i++) { newStudent[i] = student[i]; }
		 */
		return newStudent;

	}

	/*
	 * 通过ID删除学生
	 */

	public void deleteStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > count) {
			throw new TheIdIdNullException("这个删除的id不合法");
		}

		int index = findStudent(id);
			if (index !=-1) {
		for (int i = index; i < count - 1; i++) {// 数组左移
			this.student[i] = this.student[i + 1];

		}
		this.student[this.student.length - 1] = null;
		count--;
	} else {
		System.out.println("删除失败");
		
	}
	}

	/*
	 * 通过ID查找学生
	 */
	public int findStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > count) {
			throw new TheIdIdNullException("这个查找的id不合法");
		}

		int index = -1;
		for (int i = 0; i < count; i++) {
			if (this.student[i].getId() == id) {
				index = i;
			}

		}
		return index;
	}

	// 展示查找id的学生信息
	public void findStudentInfo(int id) throws TheIdIdNullException {

		if (id <= 0 || id > count) {
			throw new TheIdIdNullException("这个查找的id不合法");
		}
		int index = findStudent(id);
		if (index != -1) {
		System.out.println("该名学生的信息如下");
		System.out.println("学生姓名： " + this.student[index].getName() + " 年龄： " + this.student[index].getAge() + " 性别： "
				+ this.student[index].getSex() + " 成绩： " + this.student[index].getGrade());
	} else {
		System.out.println("没有这个学生");
	}
	}

	/*
	 * 通过Id修改学生的信息
	 */
	public void alterStudent(int id) throws TheIdIdNullException {

		if (id <= 0 || id > count) {
			throw new TheIdIdNullException("这个查找的id不合法");
		}

		int index = findStudent(id);
		
		if (index != -1) {
		Scanner sc = new Scanner(System.in);
		int flag = 1;

		while (true) {
			System.out.println("该学生的信息如下");
			System.out.println("姓名： " + this.student[index].getName());
			System.out.println("性别： " + this.student[index].getSex());
			System.out.println("成绩： " + this.student[index].getGrade());
			System.out.println("年龄： " + this.student[index].getAge());
			System.out.println("请输入你想修改的信息：1.姓名; 2.性别; 3. 成绩; 4.年龄; 5.退出");
			int select = sc.nextInt();
			switch (select) {

			case 1:
				System.out.println("请输入你想修改的名字");
				String newName = sc.next();
				this.student[index].setName(newName);
				break;
			case 2:
				System.out.println("请输入你修改的性别");
				String newSex = sc.next();
				this.student[index].setSex(newSex);
				break;
			case 3:
				System.out.println("请输入你的正确的成绩");
				double newGrade = sc.nextDouble();
				this.student[index].setGrade(newGrade);
				break;
			case 4:
				System.out.println("请输入你的正确的年龄");
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
			System.out.println("没有这个学生");
		}
	}

	// 选择排序 按照年龄排序
	public void selectSort() {
		//为了不影响id的绑定，所以需要新建一个新的数组将旧的数组赋值给新的数组，然后展示新的数组
		int newLength = count;
		Student[] stu = new Student[newLength];

		stu = Arrays.copyOf(student, newLength);
		for (int i = 0; i < count - 1; i++) {
			int index = i;
			for (int j = i + 1; j < count; j++) {
				if (this.student[index].getAge() > this.student[j].getAge()) {
					index = j;// 记录最小值的下标
				} // if
			} // for
			if (index != i) {
				Student temp = stu[index];
				stu[index] = stu[i];
				stu[i] = temp;
			}
		}
		// 遍历
		for (int i = 0; i < count; i++) {
			System.out.println(" 学生Id " + stu[i].getId() + " 学生姓名： " + stu[i].getName() + " 年龄： " + stu[i].getAge()
					+ " 性别： " + stu[i].getSex() + " 成绩： " + stu[i].getGrade());
		}

	}

	// 冒泡排序 按照成绩排序
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

		// 遍历
		for (int i = 0; i < count; i++) {
			System.out.println(" 学生Id " + stu[i].getId() + " 学生姓名： " + stu[i].getName() + " 年龄： " + stu[i].getAge()
					+ " 性别： " + stu[i].getSex() + " 成绩： " + stu[i].getGrade());
		}

	}

	/*
	 * 展示学生 1.按照ID展示 2.选择性别展示
	 */
	// 按照ID展示
	public void idShow() {

		
		// 遍历
		for (int i = 0; i < count; i++) {
			System.out.println(" 学生Id " + this.student[i].getId() + " 学生姓名： " + this.student[i].getName() + " 年龄： "
					+ this.student[i].getAge() + " 性别： " + this.student[i].getSex() + " 成绩： "
					+ this.student[i].getGrade());
		}

	}

	// 2选择性别展示
	public void sexShow(String sex) {
		
		int newLength = count;
		Student[] stu = new Student[newLength];

		stu = Arrays.copyOf(student, newLength);

		for (int i = 0; i < count; i++) {
			if (sex.equals(this.student[i].getSex())) {
				System.out.println("学生Id " + stu[i].getId() + " 学生姓名： " + stu[i].getName() + " 年龄： "
						+ stu[i].getAge() + " 性别： " + stu[i].getSex() + " 成绩： "
						+ stu[i].getGrade());
			}
		}

	}

}
