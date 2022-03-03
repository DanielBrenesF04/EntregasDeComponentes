package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testbean.MySpringCodificar;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite 1 para trabajar con codificacion de Cesar\nDigite 2 para trabajar con codificacion de Vignere");
        int MenuOpc = sc.nextInt();
        switch (MenuOpc) {
            case 1:
                ApplicationContext contextC = new ClassPathXmlApplicationContext("file:META-INF/beansC.xml");
                BeanFactory factoryC = contextC;
                MySpringCodificar testC = (MySpringCodificar) factoryC.getBean("MySpringCodificar");
                testC.run();
                break;
            case 2:
                ApplicationContext contextV = new ClassPathXmlApplicationContext("file:META-INF/beansV.xml");
                BeanFactory factoryV = contextV;
                MySpringCodificar testV = (MySpringCodificar) factoryV.getBean("MySpringCodificar");
                testV.run();
                break;
        }


    }

}
