package com;

public class JJO implements Cloneable {
    private String name;  //姓名
    private String sex;   //性别
    private int age;      //年龄
    private String experience; //工作经历

    public JJO(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExperience() {
        return experience;
    }

    public void displayResume() {
        System.out.println("姓名：" + name + " 性别：" + sex + " 年龄:" + age);
        System.out.println("工作经历：" + experience);
    }
    @Override
    protected JJO clone() throws CloneNotSupportedException {
        return (JJO)super.clone();
    }
    public static void main(String[] args){
        JJO zhangsan = new JJO("zhangsan","男",24);
        JJO zhangsan1=null;
        zhangsan.setExperience("2009-2013就读于家里蹲大学，精通JAVA,C,C++,C#等代码拷贝和粘贴");
        zhangsan.displayResume();
        try{
         zhangsan1 = zhangsan.clone();
        zhangsan1.displayResume();
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }


        zhangsan.setAge(11);

//        JJO zhangsan2 = (JJO)zhangsan.clone();
//        zhangsan2.setExperience("2009-2013就读于家里蹲大学，精通JAVA,C,C++,C#等代码");
//        zhangsan2.displayResume();
        zhangsan.displayResume();
        zhangsan1.displayResume();

    }
}

