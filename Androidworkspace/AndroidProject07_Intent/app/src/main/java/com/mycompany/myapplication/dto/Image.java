package com.mycompany.myapplication.dto;

/**
 * Created by ijeongsu on 2017. 6. 29..
 */

public class Image {
    private int ino;
    private String iname;
    private int iphoto;
    private int istar;
    private String idesc;

    public int getIno() {
        return ino;
    }

    public void setIno(int ino) {
        this.ino = ino;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public int getIphoto() {
        return iphoto;
    }

    public void setIphoto(int iphoto) {
        this.iphoto = iphoto;
    }

    public int getIstar() {
        return istar;
    }

    public void setIstar(int istar) {
        this.istar = istar;
    }

    public String getIdesc() {
        return idesc;
    }

    public void setIdesc(String idesc) {
        this.idesc = idesc;
    }
}
