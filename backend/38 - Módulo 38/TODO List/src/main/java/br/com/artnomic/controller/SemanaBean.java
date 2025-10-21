package br.com.artnomic.controller;

import br.com.artnomic.model.Tarefa;
import org.primefaces.PrimeFaces;
// REMOVIDO: import org.primefaces.event.DragDropEvent; // Não precisamos mais

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Named
@ViewScoped
public class SemanaBean implements Serializable {

    @PersistenceContext(unitName = "TodoPU")
    private EntityManager em;

    private static final DateTimeFormatter HEADER_FORMATTER = DateTimeFormatter.ofPattern("dd/MM");
    private static final DateTimeFormatter DIALOG_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // --- Dados da Semana ---
    private LocalDate dataSelecionada;
    private LocalDate inicioSemana;
    private List<Tarefa> tarefasSegunda;
    // **** CORREÇÃO: ADICIONANDO OS CAMPOS QUE FALTAVAM ****
    private List<Tarefa> tarefasTerca;
    private List<Tarefa> tarefasQuarta;
    private List<Tarefa> tarefasQuinta;
    private List<Tarefa> tarefasSexta;
    // **** FIM DA CORREÇÃO ****

    // --- Cabeçalhos Formatados ---
    private String headerSegunda;
    // **** CORREÇÃO: ADICIONANDO OS CAMPOS QUE FALTAVAM ****
    private String headerTerca;
    private String headerQuarta;
    private String headerQuinta;
    private String headerSexta;
    // **** FIM DA CORREÇÃO ****

    // --- Campos Nova Tarefa ---
    private String novaTarefaDescricao;
    private LocalDate dataNovaTarefa;
    private String dataNovaTarefaFormatada;

    // --- Campos Edição ---
    private Tarefa tarefaSelecionada;
    private LocalDate novaDataParaTarefaSelecionada;

    // Métodos @PostConstruct, carregarSemana, buscarTarefasDoDia, etc...
    // (O restante do código da resposta anterior está CORRETO e não precisa mudar)

    @PostConstruct
    public void init() {
        dataSelecionada = LocalDate.now();
        carregarSemana();
    }

    public void carregarSemana() {
        inicioSemana = dataSelecionada.with(DayOfWeek.MONDAY);
        tarefasSegunda = buscarTarefasDoDia(inicioSemana);
        tarefasTerca = buscarTarefasDoDia(inicioSemana.plusDays(1)); // Agora deve encontrar o campo
        tarefasQuarta = buscarTarefasDoDia(inicioSemana.plusDays(2)); // Agora deve encontrar o campo
        tarefasQuinta = buscarTarefasDoDia(inicioSemana.plusDays(3)); // Agora deve encontrar o campo
        tarefasSexta = buscarTarefasDoDia(inicioSemana.plusDays(4)); // Agora deve encontrar o campo
        headerSegunda = "Segunda (" + inicioSemana.plusDays(0).format(HEADER_FORMATTER) + ")";
        headerTerca = "Terça (" + inicioSemana.plusDays(1).format(HEADER_FORMATTER) + ")"; // Agora deve encontrar o campo
        headerQuarta = "Quarta (" + inicioSemana.plusDays(2).format(HEADER_FORMATTER) + ")"; // Agora deve encontrar o campo
        headerQuinta = "Quinta (" + inicioSemana.plusDays(3).format(HEADER_FORMATTER) + ")"; // Agora deve encontrar o campo
        headerSexta = "Sexta (" + inicioSemana.plusDays(4).format(HEADER_FORMATTER) + ")"; // Agora deve encontrar o campo
    }

    public List<Tarefa> buscarTarefasDoDia(LocalDate dia) {
        String jpql = "SELECT t FROM Tarefa t WHERE t.dataTarefa = :dia ORDER BY t.id";
        TypedQuery<Tarefa> query = em.createQuery(jpql, Tarefa.class);
        query.setParameter("dia", dia);
        return query.getResultList();
    }

    public void alternarConclusaoSelecionada() {
        if (tarefaSelecionada != null) {
            tarefaSelecionada.setConcluida(!tarefaSelecionada.isConcluida());
        }
    }

    public void prepararNovaTarefa(LocalDate dia) {
        this.dataNovaTarefa = dia;
        this.novaTarefaDescricao = null;
        if (dia != null) {
            this.dataNovaTarefaFormatada = dia.format(DIALOG_FORMATTER);
        } else {
            this.dataNovaTarefaFormatada = "";
        }
    }

    @Transactional
    public void salvarNovaTarefa() {
        try {
            if (novaTarefaDescricao == null || novaTarefaDescricao.trim().isEmpty()) {
                addMensagem("Erro", "A descrição não pode estar vazia.", FacesMessage.SEVERITY_WARN);
                PrimeFaces.current().ajax().addCallbackParam("validationFailed", true);
                return;
            }
            Tarefa nova = new Tarefa();
            nova.setDescricao(novaTarefaDescricao);
            nova.setDataTarefa(dataNovaTarefa);
            nova.setConcluida(false);
            em.persist(nova);
            addMensagem("Sucesso", "Tarefa adicionada.", FacesMessage.SEVERITY_INFO);
            carregarSemana();
        } catch (Exception e) {
            addMensagem("Erro", "Não foi possível salvar a tarefa.", FacesMessage.SEVERITY_ERROR);
            PrimeFaces.current().ajax().addCallbackParam("validationFailed", true);
        }
    }

    public void selecionarTarefaParaEdicao(Tarefa tarefa) {
        if (tarefa == null) {
            System.err.println("Tentativa de selecionar tarefa nula para edição!");
            return;
        }
        this.tarefaSelecionada = em.find(Tarefa.class, tarefa.getId());
        if (this.tarefaSelecionada != null) {
            this.novaDataParaTarefaSelecionada = this.tarefaSelecionada.getDataTarefa();
            System.out.println("Tarefa ID: " + this.tarefaSelecionada.getId() + " selecionada para edição.");
        } else {
            System.err.println("Tarefa ID: " + tarefa.getId() + " não encontrada no EntityManager ao selecionar para edição!");
            addMensagem("Erro", "Tarefa não encontrada para edição.", FacesMessage.SEVERITY_ERROR);
        }
    }

    @Transactional
    public void salvarEdicaoTarefa() {
        System.out.println("--- salvarEdicaoTarefa INICIOU ---");
        if (tarefaSelecionada == null || tarefaSelecionada.getId() == null) {
            addMensagem("Erro", "Nenhuma tarefa selecionada para salvar.", FacesMessage.SEVERITY_ERROR);
            PrimeFaces.current().ajax().addCallbackParam("validationFailed", true);
            System.err.println("ERRO: tarefaSelecionada é null ou sem ID.");
            return;
        }
        if (novaDataParaTarefaSelecionada == null) {
            addMensagem("Erro", "A nova data não pode ser vazia.", FacesMessage.SEVERITY_WARN);
            PrimeFaces.current().ajax().addCallbackParam("validationFailed", true);
            System.err.println("ERRO: novaDataParaTarefaSelecionada é null.");
            return;
        }

        try {
            Tarefa tarefaParaAtualizar = em.find(Tarefa.class, tarefaSelecionada.getId());
            if (tarefaParaAtualizar == null) {
                addMensagem("Erro", "Tarefa não existe mais no banco.", FacesMessage.SEVERITY_ERROR);
                PrimeFaces.current().ajax().addCallbackParam("validationFailed", true);
                System.err.println("ERRO: Tarefa ID: " + tarefaSelecionada.getId() + " não encontrada no find para salvar.");
                return;
            }

            boolean mudouStatus = tarefaParaAtualizar.isConcluida() != tarefaSelecionada.isConcluida();
            boolean mudouData = !Objects.equals(tarefaParaAtualizar.getDataTarefa(), novaDataParaTarefaSelecionada);

            if (mudouStatus || mudouData) {
                if (mudouStatus) {
                    tarefaParaAtualizar.setConcluida(tarefaSelecionada.isConcluida());
                    System.out.println("Atualizando status para: " + tarefaParaAtualizar.isConcluida());
                }
                if (mudouData) {
                    tarefaParaAtualizar.setDataTarefa(novaDataParaTarefaSelecionada);
                    System.out.println("Atualizando data para: " + tarefaParaAtualizar.getDataTarefa());
                }
                em.merge(tarefaParaAtualizar);
                addMensagem("Sucesso", "Tarefa atualizada.", FacesMessage.SEVERITY_INFO);
                carregarSemana();
            } else {
                addMensagem("Info", "Nenhuma alteração detectada.", FacesMessage.SEVERITY_INFO);
                PrimeFaces.current().ajax().addCallbackParam("validationFailed", true);
            }

        } catch (Exception e) {
            addMensagem("Erro", "Não foi possível salvar as alterações.", FacesMessage.SEVERITY_ERROR);
            PrimeFaces.current().ajax().addCallbackParam("validationFailed", true);
            System.err.println("--- ERRO NO salvarEdicaoTarefa ---");
            e.printStackTrace();
        }
        System.out.println("--- salvarEdicaoTarefa TERMINOU ---");
    }


    private void addMensagem(String sumario, String detalhe, FacesMessage.Severity severidade) {
        FacesMessage message = new FacesMessage(severidade, sumario, detalhe);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // --- GETTERS E SETTERS ---
    public LocalDate getDataSelecionada() {
        return dataSelecionada;
    }

    public void setDataSelecionada(LocalDate dataSelecionada) {
        this.dataSelecionada = dataSelecionada;
    }

    public LocalDate getInicioSemana() {
        return inicioSemana;
    }

    public List<Tarefa> getTarefasSegunda() {
        return tarefasSegunda;
    }

    public List<Tarefa> getTarefasTerca() {
        return tarefasTerca;
    } // Getter já existia

    public List<Tarefa> getTarefasQuarta() {
        return tarefasQuarta;
    } // Getter já existia

    public List<Tarefa> getTarefasQuinta() {
        return tarefasQuinta;
    } // Getter já existia

    public List<Tarefa> getTarefasSexta() {
        return tarefasSexta;
    } // Getter já existia

    public String getHeaderSegunda() {
        return headerSegunda;
    }

    public String getHeaderTerca() {
        return headerTerca;
    } // Getter já existia

    public String getHeaderQuarta() {
        return headerQuarta;
    } // Getter já existia

    public String getHeaderQuinta() {
        return headerQuinta;
    } // Getter já existia

    public String getHeaderSexta() {
        return headerSexta;
    } // Getter já existia

    public String getNovaTarefaDescricao() {
        return novaTarefaDescricao;
    }

    public void setNovaTarefaDescricao(String novaTarefaDescricao) {
        this.novaTarefaDescricao = novaTarefaDescricao;
    }

    public LocalDate getDataNovaTarefa() {
        return dataNovaTarefa;
    }

    public void setDataNovaTarefa(LocalDate dataNovaTarefa) {
        this.dataNovaTarefa = dataNovaTarefa;
    }

    public String getDataNovaTarefaFormatada() {
        return dataNovaTarefaFormatada;
    }

    public Tarefa getTarefaSelecionada() {
        return tarefaSelecionada;
    }

    public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
        this.tarefaSelecionada = tarefaSelecionada;
    }

    public LocalDate getNovaDataParaTarefaSelecionada() {
        return novaDataParaTarefaSelecionada;
    }

    public void setNovaDataParaTarefaSelecionada(LocalDate novaDataParaTarefaSelecionada) {
        this.novaDataParaTarefaSelecionada = novaDataParaTarefaSelecionada;
    }
}