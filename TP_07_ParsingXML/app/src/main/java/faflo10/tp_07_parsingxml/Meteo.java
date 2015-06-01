package faflo10.tp_07_parsingxml;

/**
 * Created by faflo10 on 01/06/2015.
 */
public class Meteo {
    private String date;
    private double t_mat;
    private double t_mid;
    private double t_aft;
    private double t_soi;
    private String c_mat;
    private String c_mid;
    private String c_aft;

    public Meteo(String date, String c_mat, double t_mat, String c_mid, double t_mid,
                 String c_aft, double t_aft, String c_soi, double t_soi) {
        this.date = date;
        this.c_mat = c_mat;
        this.c_mid = c_mid;
        this.c_aft = c_aft;
        this.c_soi = c_soi;
        this.t_mat = t_mat;
        this.t_mid = t_mid;
        this.t_aft = t_aft;
        this.t_soi = t_soi;
    }

    public Meteo() {
        this.date = null;
        this.c_mat = null;
        this.c_mid = null;
        this.c_aft = null;
        this.c_soi = null;
        this.t_mat = 0;
        this.t_mid = 0;
        this.t_aft = 0;
        this.t_soi = 0;
    }

    public void setC_soi(String c_soi) {
        this.c_soi = c_soi;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setT_mat(double t_mat) {
        this.t_mat = t_mat;
    }

    public void setT_mid(double t_mid) {
        this.t_mid = t_mid;
    }

    public void setT_aft(double t_aft) {
        this.t_aft = t_aft;
    }

    public void setT_soi(double t_soi) {
        this.t_soi = t_soi;
    }

    public void setC_mat(String c_mat) {
        this.c_mat = c_mat;
    }

    public void setC_mid(String c_mid) {
        this.c_mid = c_mid;
    }

    public void setC_aft(String c_aft) {
        this.c_aft = c_aft;
    }

    private String c_soi;

    public String getDate() {
        return date;
    }

    public double getT_mat() {
        return t_mat;
    }

    public double getT_mid() {
        return t_mid;
    }

    public double getT_aft() {
        return t_aft;
    }

    public double getT_soi() {
        return t_soi;
    }

    public String getC_mat() {
        return c_mat;
    }

    public String getC_mid() {
        return c_mid;
    }

    public String getC_aft() {
        return c_aft;
    }

    public String getC_soi() {
        return c_soi;
    }

}
