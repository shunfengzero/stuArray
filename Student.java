package student;

public class Student {
	private int id;
	private String name;
	private int age;
	private String sex;
	private double grade;
	private static int count = 1;
	
	{
		id = count;
		count++;
	}

	Student(String name, String sex, Double grade, int age) {
		setName(name);
		setSex(sex);
		setGrade(grade);
		setAge(age);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		 if (name == null) {
			 System.out.println("����������ֲ���Ϊ��");
			 this.name = "������";
		 }
			this.name = name;
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age <= 0) {
			System.out.println("����������벻�Ϸ�");
			this.age = 18;
		} else {
			this.age = age;
		}
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		if (sex.equals("��") || sex.equals("Ů")) {
			this.sex = sex;
		} else {
			System.out.println("��ȷ������������");
			this.sex = "��";
		}
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		if (this.grade < 0 || this.grade > 100) {
			System.out.println("������ĳɼ�����");
			this.grade = 0;
		} else {
		this.grade = grade; 
		}
	}

}
