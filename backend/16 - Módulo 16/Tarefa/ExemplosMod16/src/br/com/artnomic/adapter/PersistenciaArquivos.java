package br.com.artnomic.adapter;

import java.io.File;

public interface PersistenciaArquivos {

    //To convert file to byte
    //byte[] bytes = Files.readAllBytes(file.toPath());
    public void gravar(File file);

    public File ler(String caminho);
}
