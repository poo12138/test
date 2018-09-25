package com;


public class llklk implements Cloneable {
        private int[] arr;
        private int age;
        private static int q;
//        public llklk() {
//
//            arr = new int[10];
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = i;
//            }
//        }

        protected class InnerClass {
            int x=100;
        }
        private InnerClass qss;
        public llklk(int age) {
            arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            this.age=age;
            qss=new InnerClass();
        }
        public void setAge(int age) {
            this.age = age;

        }
         public int getAge() {
             return age;
        }
        public void set(int index, int value) {
            arr[index] = value;
            int qqw=q;
            int sy=age;
        }

        public int get(int index) {
            return arr[index];
        }

        public int getProtect() {
            return qss.x;
        }
        @Override
        protected llklk clone() throws CloneNotSupportedException {
            return (llklk) super.clone();
        }

    public static void main(String[] args) {
        llklk e1 = new llklk(12);

        llklk e2 = null;
        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
//        e1.set(2, 222);
        System.out.println(e2.get(2)); // 222
        System.out.println(e2.getAge());

        e2.set(3,221);
        e1.setAge(22);
        System.out.println(e2.get(2)); // 222
        System.out.println(e2.getAge());
        System.out.println(e1.getAge());
        System.out.println(e1.getProtect());

    }
}
