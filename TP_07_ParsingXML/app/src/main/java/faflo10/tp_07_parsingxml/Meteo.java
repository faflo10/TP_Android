package faflo10.tp_07_parsingxml;

/**
 * Created by faflo10 on 01/06/2015.
 */
public class Meteo {
    private String date;
    private String[] T;
    private String[] C;

    public Meteo(String date, String c_mat, String t_mat, String c_mid, String t_mid,
                 String c_aft, String t_aft, String c_soi, String t_soi) {
        this.date = date;
        T = new String[4];
        T[0] = t_mat;
        T[1] = t_mid;
        T[2] = t_aft;
        T[3] = t_soi;
        C = new String[4];
        C[0] = c_mat;
        C[1] = c_mid;
        C[2] = c_aft;
        C[3] = c_soi;
    }

    public Meteo() {
        date = null;
        T = null;
        C = null;
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
