package ru.den;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import ru.den.DAO.StringMapDAO;
import ru.den.model.StringMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParsURL {
    private String url;
    private String parsString;
    private Map<String, Integer> statistic = new HashMap<>();
    private StringMap stringMap;
    private String regex = "[ ,;!?\\-:'\"\n\r\t#\\[\\]]";


    static StringMapDAO stringMapDAO = new StringMapDAO();

    /*@Autowired
    public void setStringMapDAO(StringMapDAO stringMapDAO) {
        ParsURL.stringMapDAO = stringMapDAO;
    }*/

    public void ranParsing(String url) throws IOException {
        this.url = url;
        System.out.println(url);
        getParsString();
        //System.out.println(parsString);
        splitParsString();
        getStringMap();
        saveStringMapDB();

    }

    private void getParsString() throws IOException {
        Document doc = Jsoup.connect(url).get();

        parsString =  doc.text();

    }

    private void splitParsString(){
        String[] str = parsString.split(regex);
        /*for(String st:str){
            System.out.println(st);
        }*/
        for(String s:str){
            if(statistic.containsKey(s)){
                int n = statistic.get(s);
                statistic.put(s, n++);
            }else{
                statistic.put(s, 1);
            }
        }
    }

    private void getStringMap(){
        stringMap = new StringMap(url, statistic);
    }

    private void saveStringMapDB(){
        stringMapDAO.save(stringMap);
    }

    public void printResalt(){
        System.out.println(url);

        for(String key:statistic.keySet()){
            System.out.println(key + " - " + statistic.get(key));
        }
    }

}
