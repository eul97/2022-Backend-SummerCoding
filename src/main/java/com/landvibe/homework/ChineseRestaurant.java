package com.landvibe.homework;

import java.util.Scanner;
import java.util.Vector;

public class ChineseRestaurant {
    public static void main(String[] args){
        //고객 정보
        Customer customer = new Customer("심찬희",100000);
        //메뉴 정보
        Menu[] menu = new Menu[5];
        menu[1] = new Menu("1","짜장면",6000);
        menu[2] = new Menu("2","간짜장",6500);
        menu[3] = new Menu("3","짬뽕",7000);
        menu[4] = new Menu("4","짬뽕밥",7000);
        Scanner scanner = new Scanner(System.in);
        //무엇을 할까요
        System.out.println("1. 메뉴판 보기");
        System.out.println("2. 주문하기");
        System.out.println("3. 주문 내역 보기");
        System.out.println("4. 내 잔고 보기");
        System.out.println("5. 끝내기");
        System.out.println("\n무엇을 할까요?");
        String what;
        what = scanner.nextLine();
        while(!what.equals("끝내기")) {
            if (what.equals("메뉴판 보기")) {
                for (int i = 1; i <= 4; i++) {
                    System.out.println(menu[i].getMenuId() + ". " + menu[i].getMenuName() + " " + menu[i].getPrice() + "원");
                }
            } else if (what.equals("주문하기")) {
                String order;
                System.out.println("어떤 메뉴를 주문하시겠습니까? 주문번호 혹은 메뉴명을 적어주세요");
                order = scanner.next();
                scanner.nextLine();
                boolean yesOrder = false; // 주문 완료 되었는지 확인(메뉴의 존재 유무 확인)
                for (int i = 1; i <= 4; i++) {
                    if (order.equals(menu[i].getMenuId()) || order.equals(menu[i].getMenuName())) {
                        int menuPrice = menu[i].getPrice();
                        if (customer.checkBalance(menuPrice)) {//잔고 확인
                            customer.expenditure(menuPrice);// 잔고에서 금액 소비
                            System.out.println("주문이 완료되었습니다.");
                            customer.setOrderList(i);//주문 완료 후 고객의 주문 내역에 추가
                        } else {
                            System.out.println("잔고가 부족합니다");
                        }
                        yesOrder = true;
                        break;
                    }
                }
                if(!yesOrder){
                    System.out.println("해당 메뉴가 없습니다.");
                }
            } else if(what.equals("주문 내역 보기")){
                Vector orderList = customer.getOrderList(); // 고객의 주문 내역 가져오기
                for(Object i : orderList){
                    System.out.println("이름 : " + customer.getName());
                    System.out.println("메뉴 : " + menu[(int)i].getMenuName()+", 가격 : " + menu[(int)i].getPrice()+"원");
                }
            } else if(what.equals("내 잔고 보기")){
                System.out.println(customer.getBalance()+"원");
            }
            System.out.println("\n무엇을 할까요?");
            what = scanner.nextLine();
        }
        scanner.close();
    }
}
class Customer{
    private String name;
    private int balance;
    Vector<Integer> orderList = new Vector();
    void setOrderList(int id){
        orderList.add(id);
    }
    Vector getOrderList(){
        return orderList;
    }
    Customer(String name,int balance){
        this.name = name;
        this.balance = balance;
    }
    String getName(){
        return name;
    }
    int getBalance(){
        return balance;
    }
    boolean checkBalance(int price){
        return balance >= price;
    }
    void expenditure(int price){
        balance -= price;
    }
}
class Menu{
    private String menuId;
    private String menuName;
    private int price;
    Menu(String id,String name,int price){
        menuId = id;
        menuName = name;
        this.price = price;
    }
    String getMenuId(){
        return menuId;
    }
    String getMenuName(){
        return menuName;
    }
    int getPrice(){
        return price;
    }
}
