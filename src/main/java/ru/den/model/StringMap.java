package ru.den.model;



import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "parsing_statistic", catalog = "postgres")
public class StringMap {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "url_name")
    private String url;




    @ElementCollection
    @CollectionTable(name = "statistic_string",
    joinColumns = {@JoinColumn(name = "url_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "word_n")
    @Column(name = "statistic_w" )
    private Map<String, Integer> statistic = new HashMap<String, Integer>();

    public StringMap(String url, Map<String, Integer> statistic){
        this.url = url;
        this.statistic = statistic;
    }
    public StringMap(){}



    @Override
    public String toString() {
        return "StringMap{" +
                "url='" + url + '\'' +
                ", statistic=" + /*statistic*/ +
                '}';
    }
}
