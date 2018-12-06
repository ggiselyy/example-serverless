package com.example;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

import java.util.stream.*;


public class Function {

    @FunctionName("criarcidade")
        public Cidade criar (
            @HttpTrigger(
                name = "criarcidaderest", 
                methods = { HttpMethod.POST }, 
                route = "cidade")

            Cidade cidade) {

            return cidade;
        }

        @FunctionName ("listarcidade")
        public List<Cidade> listar (            
           @HttpTrigger( 
                   name = "listarcidade", 
                   methods = {HttpMethod.GET}, 
                   route = "cidade" )  String x){ 

                Estado sp = new Estado(new Long(1), "São Paulo");
                Cidade spo = new Cidade(new Long(1), "São Paulo", sp);

                Estado pr = new Estado(new Long(2), "Parana");
                Cidade cp = new Cidade(new Long(2), "Cornélio Procópio", pr);

                return Stream.of(spo, cp).collect(Collectors.toList());
            }

        
        @FunctionName("atualizarcidade")
        public Cidade atualizar(
            @HttpTrigger(
                name = "atualizarcidaderest", 
                methods = { HttpMethod.PUT }, 
                route = "cidade")

            Cidade cidade) {
                cidade.setNome(cidade.getNome() +  " - Atualizada");
                
                return cidade;
            }


        @FunctionName("deletarcidade")
        public int deletar(
            @HttpTrigger(
                name = "deletarcidaderest", 
                methods = { HttpMethod.DELETE }, 
                route = "cidade/{id}")

            @BindingName("id") Long id) {

            return 200;
        }  
}



class Estado {
    private Long id;
    private String nome;

    public Estado() {

    }

    public Estado(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Cidade {
    private Long id;
    private String nome;
    private Estado estado;

    public Cidade() {
    }

    public Cidade(Long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
    

