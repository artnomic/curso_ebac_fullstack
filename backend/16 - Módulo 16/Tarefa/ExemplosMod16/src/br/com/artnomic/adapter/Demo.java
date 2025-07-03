package br.com.artnomic.adapter;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        String file = "teste.txt";
        DropBox drop = new DropBox();
        PersistenciaArquivos arquivos = new DropboxAdapter(drop);

        arquivos.gravar(new File(file));
    }
}
