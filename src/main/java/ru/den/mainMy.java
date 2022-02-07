package ru.den;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.den.DAO.StringMapDAO;
import ru.den.model.StringMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class mainMy {




    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        //https://www.google.ru/
        //https://www.simbirsoft.com/
        ParsURL parsURL = new ParsURL();
        parsURL.ranParsing("https://www.simbirsoft.com");
        parsURL.printResalt();

        //ParsURL kosta = new ParsURL("https://www.google.ru/");
        //StringMap kostaStr = kosta.getStringMap();




    }
}
