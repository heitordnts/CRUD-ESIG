/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esig.lembreteapp.bean;

import com.esig.lembreteapp.dao.LembreteDAO;
import com.esig.lembreteapp.model.Lembrete;
import java.util.Comparator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeFacesContext;

/**
 *
 * @author heitor
 */
@ManagedBean(name = "lembreteBean")
@ApplicationScoped
public class LembreteBean {

    private List<Lembrete> lembretes;
    private LembreteDAO ldao = null;
    private Lembrete linput;

    public LembreteBean() {
        System.out.println("CRIANDO LEMBRETE BEAN");
        linput = new Lembrete();
        ldao = LembreteDAO.getInstance();

        lembretes = ldao.listarLembretes();
    }

    public void adicionarLembrete() {
        if (!linput.getTexto().isEmpty()) {
            System.out.println("Bean: Inserindo Lembrete " + linput.getTexto());
            ldao.adicionarLembrete(linput);
            linput = new Lembrete();
            lembretes = ldao.listarLembretes();
        }

    }

    public void removerLembrete(Lembrete l) {
        System.out.println("Bean: Removendo Lembrete " + "id:" + l.getId());
        if (l.getId() != null) {
            //System.out.println("Bean: Removendo Lembrete " + "id:" + l.getId() + "texto:" + l.getTexto());
            ldao.excluirLembrete(l);
            lembretes = ldao.listarLembretes();
        }
    }
    public void editarLembrete(Lembrete l) {

        if (l.getId() != null) {
            System.out.println("Bean: Editando Lembrete " + "id:" + l.getId() + "texto:" + l.getTexto());
            ldao.atualizarLembrete(l);
            lembretes = ldao.listarLembretes();
        }
    }
    public void cancelEdit(){
        System.out.println("Cancelando edicao");
    }
    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }

    public LembreteDAO getLdao() {
        return ldao;
    }

    public void setLdao(LembreteDAO ldao) {
        this.ldao = ldao;
    }

    public Lembrete getLinput() {
        return this.linput;
    }
}
