package faflo10.projet_meteo;

/**
 * Created by faflo10 on 03/06/2015.
 */
public class Meteo {
    private String date;
    private String[] T;
    private String[] C;
    private String[] XML;

    public Meteo(String date, String[] temp, String[] cond, String[] XML) {
        this.date = date;
        this.T = temp;
        this.C = cond;
        this.XML = XML;
    }

    public String[] getXML() {
        return XML;
    }

    public void setXML(String[] xml) {
        if(xml.length == XML.length) {
            XML = xml;
        } else {
            System.out.println("Non settable");
        }
    }

    public Meteo() {
        date = null;
        T = null;
        C = null;
        XML = null;

    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String[] getT() {
        return T;
    }

    public String[] getC() {
        return C;
    }

    public void setT(String[] t) {
        if(t.length == T.length) {
            T = t;
        } else {
            System.out.println("Non settable");
        }
    }

    public void setC(String[] c) {
        if(c.length == C.length) {
            C = c;
        } else {
            System.out.println("Non settable");
        }
    }
}