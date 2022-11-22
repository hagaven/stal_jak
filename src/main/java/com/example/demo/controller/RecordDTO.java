package com.example.demo.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class RecordDTO {
    private String pranal;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datai;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataz;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datap;
    private String gat;
    private String koment;
    private String zatw;
    private String przygot;
    private String przygot_c;
    private String przygot_h;
    private String przygot_o;
    private String przygot_n;
    private String robo;
    private String _C;
    private String _Mn;
    private String _Si;
    private String _P;
    private String _S;
    private String _Cu;
    private String _Cr;
    private String _Ni;
    private String _Mo;
    private String _V;
    private String _W;
    private String _As;
    private String _Alc;
    private String _Alr;
    private String _Sn;
    private String _Sb;
    private String _Co;
    private String _Pb;
    private String _Tic;
    private String _Tir;
    private String _Nb;
    private String _Bc;
    private String _Bro;
    private String _Ca;
    private String _Zn;
    private String _Hc;
    private String _Hd;
    private String _O2;
    private String _N2;
    private String _Fe;
    private String Ce1;
    private String Ce2;
    private String Rm;

    public RecordDTO() {
    }

    public RecordDTO(String pranal, Date datai, Date datao, Date dataz, Date datap, String gat, String koment, String zatw, String przygot, String przygot_c, String przygot_h, String przygot_o, String przygot_n, String robo, String _C, String _Mn, String _Si, String _P, String _S, String _Cu, String _Cr, String _Ni, String _Mo, String _V, String _W, String _As, String _Alc, String _Alr, String _Sn, String _Sb, String _Co, String _Pb, String _Tic, String _Tir, String _Nb, String _Bc, String _Bro, String _Ca, String _Zn, String _Hc, String _Hd, String _O2, String _N2, String _Fe, String ce1, String ce2, String rm) {
        this.pranal = pranal;
        this.datai = datai;
        this.datao = datao;
        this.dataz = dataz;
        this.datap = datap;
        this.gat = gat;
        this.koment = koment;
        this.zatw = zatw;
        this.przygot = przygot;
        this.przygot_c = przygot_c;
        this.przygot_h = przygot_h;
        this.przygot_o = przygot_o;
        this.przygot_n = przygot_n;
        this.robo = robo;
        this._C = _C;
        this._Mn = _Mn;
        this._Si = _Si;
        this._P = _P;
        this._S = _S;
        this._Cu = _Cu;
        this._Cr = _Cr;
        this._Ni = _Ni;
        this._Mo = _Mo;
        this._V = _V;
        this._W = _W;
        this._As = _As;
        this._Alc = _Alc;
        this._Alr = _Alr;
        this._Sn = _Sn;
        this._Sb = _Sb;
        this._Co = _Co;
        this._Pb = _Pb;
        this._Tic = _Tic;
        this._Tir = _Tir;
        this._Nb = _Nb;
        this._Bc = _Bc;
        this._Bro = _Bro;
        this._Ca = _Ca;
        this._Zn = _Zn;
        this._Hc = _Hc;
        this._Hd = _Hd;
        this._O2 = _O2;
        this._N2 = _N2;
        this._Fe = _Fe;
        this.Ce1 = ce1;
        this.Ce2 = ce2;
        this.Rm = rm;
    }

    @Override
    public String toString() {
        return "RekordDTO{" +
                "pranal='" + pranal + '\'' +
                ", datai=" + datai +
                ", datao=" + datao +
                ", dataz=" + dataz +
                ", datap=" + datap +
                ", gat='" + gat + '\'' +
                ", koment='" + koment + '\'' +
                ", zatw='" + zatw + '\'' +
                ", przygot='" + przygot + '\'' +
                ", przygot_c='" + przygot_c + '\'' +
                ", przygot_h='" + przygot_h + '\'' +
                ", przygot_o='" + przygot_o + '\'' +
                ", przygot_n='" + przygot_n + '\'' +
                ", robo='" + robo + '\'' +
                ", _C='" + _C + '\'' +
                ", _Mn='" + _Mn + '\'' +
                ", _Si='" + _Si + '\'' +
                ", _P='" + _P + '\'' +
                ", _S='" + _S + '\'' +
                ", _Cu='" + _Cu + '\'' +
                ", _Cr='" + _Cr + '\'' +
                ", _Ni='" + _Ni + '\'' +
                ", _Mo='" + _Mo + '\'' +
                ", _V='" + _V + '\'' +
                ", _W='" + _W + '\'' +
                ", _As='" + _As + '\'' +
                ", _Alc='" + _Alc + '\'' +
                ", _Alr='" + _Alr + '\'' +
                ", _Sn='" + _Sn + '\'' +
                ", _Sb='" + _Sb + '\'' +
                ", _Co='" + _Co + '\'' +
                ", _Pb='" + _Pb + '\'' +
                ", _Tic='" + _Tic + '\'' +
                ", _Tir='" + _Tir + '\'' +
                ", _Nb='" + _Nb + '\'' +
                ", _Bc='" + _Bc + '\'' +
                ", _Bro='" + _Bro + '\'' +
                ", _Ca='" + _Ca + '\'' +
                ", _Zn='" + _Zn + '\'' +
                ", _Hc='" + _Hc + '\'' +
                ", _Hd='" + _Hd + '\'' +
                ", _O2='" + _O2 + '\'' +
                ", _N2='" + _N2 + '\'' +
                ", _Fe='" + _Fe + '\'' +
                ", Ce1='" + Ce1 + '\'' +
                ", Ce2='" + Ce2 + '\'' +
                ", Rm='" + Rm + '\'' +
                '}';
    }

    public String getPranal() {
        return pranal;
    }

    public void setPranal(String pranal) {
        this.pranal = pranal;
    }

    public Date getDatai() {
        return datai;
    }

    public void setDatai(Date datai) {
        this.datai = datai;
    }

    public Date getDatao() {
        return datao;
    }

    public Date getDataz() {
        return dataz;
    }

    public void setDataz(Date dataz) {
        this.dataz = dataz;
    }

    public void setDatao(Date datao) {
        this.datao = datao;
    }

    public Date getDatap() {
        return datap;
    }

    public void setDatap(Date datap) {
        this.datap = datap;
    }

    public String getGat() {
        return gat;
    }

    public void setGat(String gat) {
        this.gat = gat;
    }

    public String getKoment() {
        return koment;
    }

    public void setKoment(String koment) {
        this.koment = koment;
    }

    public String getZatw() {
        return zatw;
    }

    public void setZatw(String zatw) {
        this.zatw = zatw;
    }

    public String getPrzygot() {
        return przygot;
    }

    public void setPrzygot(String przygot) {
        this.przygot = przygot;
    }

    public String getPrzygot_c() {
        return przygot_c;
    }

    public void setPrzygot_c(String przygot_c) {
        this.przygot_c = przygot_c;
    }

    public String getPrzygot_h() {
        return przygot_h;
    }

    public void setPrzygot_h(String przygot_h) {
        this.przygot_h = przygot_h;
    }

    public String getPrzygot_o() {
        return przygot_o;
    }

    public void setPrzygot_o(String przygot_o) {
        this.przygot_o = przygot_o;
    }

    public String getPrzygot_n() {
        return przygot_n;
    }

    public void setPrzygot_n(String przygot_n) {
        this.przygot_n = przygot_n;
    }

    public String getRobo() {
        return robo;
    }

    public void setRobo(String robo) {
        this.robo = robo;
    }

    public String get_C() {
        return _C;
    }

    public void set_C(String _C) {
        this._C = _C;
    }

    public String get_Mn() {
        return _Mn;
    }

    public void set_Mn(String _Mn) {
        this._Mn = _Mn;
    }

    public String get_Si() {
        return _Si;
    }

    public void set_Si(String _Si) {
        this._Si = _Si;
    }

    public String get_P() {
        return _P;
    }

    public void set_P(String _P) {
        this._P = _P;
    }

    public String get_S() {
        return _S;
    }

    public void set_S(String _S) {
        this._S = _S;
    }

    public String get_Cu() {
        return _Cu;
    }

    public void set_Cu(String _Cu) {
        this._Cu = _Cu;
    }

    public String get_Cr() {
        return _Cr;
    }

    public void set_Cr(String _Cr) {
        this._Cr = _Cr;
    }

    public String get_Ni() {
        return _Ni;
    }

    public void set_Ni(String _Ni) {
        this._Ni = _Ni;
    }

    public String get_Mo() {
        return _Mo;
    }

    public void set_Mo(String _Mo) {
        this._Mo = _Mo;
    }

    public String get_V() {
        return _V;
    }

    public void set_V(String _V) {
        this._V = _V;
    }

    public String get_W() {
        return _W;
    }

    public void set_W(String _W) {
        this._W = _W;
    }

    public String get_As() {
        return _As;
    }

    public void set_As(String _As) {
        this._As = _As;
    }

    public String get_Alc() {
        return _Alc;
    }

    public void set_Alc(String _Alc) {
        this._Alc = _Alc;
    }

    public String get_Alr() {
        return _Alr;
    }

    public void set_Alr(String _Alr) {
        this._Alr = _Alr;
    }

    public String get_Sn() {
        return _Sn;
    }

    public void set_Sn(String _Sn) {
        this._Sn = _Sn;
    }

    public String get_Sb() {
        return _Sb;
    }

    public void set_Sb(String _Sb) {
        this._Sb = _Sb;
    }

    public String get_Co() {
        return _Co;
    }

    public void set_Co(String _Co) {
        this._Co = _Co;
    }

    public String get_Pb() {
        return _Pb;
    }

    public void set_Pb(String _Pb) {
        this._Pb = _Pb;
    }

    public String get_Tic() {
        return _Tic;
    }

    public void set_Tic(String _Tic) {
        this._Tic = _Tic;
    }

    public String get_Tir() {
        return _Tir;
    }

    public void set_Tir(String _Tir) {
        this._Tir = _Tir;
    }

    public String get_Nb() {
        return _Nb;
    }

    public void set_Nb(String _Nb) {
        this._Nb = _Nb;
    }

    public String get_Bc() {
        return _Bc;
    }

    public void set_Bc(String _Bc) {
        this._Bc = _Bc;
    }

    public String get_Bro() {
        return _Bro;
    }

    public void set_Bro(String _Bro) {
        this._Bro = _Bro;
    }

    public String get_Ca() {
        return _Ca;
    }

    public void set_Ca(String _Ca) {
        this._Ca = _Ca;
    }

    public String get_Zn() {
        return _Zn;
    }

    public void set_Zn(String _Zn) {
        this._Zn = _Zn;
    }

    public String get_Hc() {
        return _Hc;
    }

    public void set_Hc(String _Hc) {
        this._Hc = _Hc;
    }

    public String get_Hd() {
        return _Hd;
    }

    public void set_Hd(String _Hd) {
        this._Hd = _Hd;
    }

    public String get_O2() {
        return _O2;
    }

    public void set_O2(String _O2) {
        this._O2 = _O2;
    }

    public String get_N2() {
        return _N2;
    }

    public void set_N2(String _N2) {
        this._N2 = _N2;
    }

    public String get_Fe() {
        return _Fe;
    }

    public void set_Fe(String _Fe) {
        this._Fe = _Fe;
    }

    public String getCe1() {
        return Ce1;
    }

    public void setCe1(String ce1) {
        Ce1 = ce1;
    }

    public String getCe2() {
        return Ce2;
    }

    public void setCe2(String ce2) {
        Ce2 = ce2;
    }

    public String getRm() {
        return Rm;
    }

    public void setRm(String rm) {
        Rm = rm;
    }
}
