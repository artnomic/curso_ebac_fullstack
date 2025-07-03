package br.com.artnomic.adapter;

import java.io.File;

public class DropboxAdapter implements PersistenciaArquivos {

    private DropBox dropBox;

    public DropboxAdapter(DropBox dropbox) {
        this.dropBox = dropbox;
    }

    @Override
    public void gravar(File file) {
        dropBox.download(file.getAbsolutePath());
    }

    @Override
    public File ler(String caminho) {
        DropboxFile file = dropBox.download(caminho);
        return new File(file.getLocalPath());
    }
}
