package ck.edu.com.ptanque2000;

import java.io.Serializable;

public class Game implements Serializable {


    private Integer id;
    private String J1;
    private String J2;
    private String scoreJ1;
    private String scoreJ2;

    public Game (Integer id, String J1, String J2, String scoreJ1, String scoreJ2) {

        this.id = id;
        this.J1 = J1;
        this.J2 = J2;
        this.scoreJ1 = scoreJ1;
        this.scoreJ2 = scoreJ2;
    }


    public Integer getid() {return id;}

    public String getJ1() {return J1;}

    public String getJ2() {return J2;}

    public String getScoreJ1() {return scoreJ1;}

    public String getScoreJ2() {return scoreJ2;}

    }