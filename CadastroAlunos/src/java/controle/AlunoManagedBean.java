/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.DAOAlunosDerby;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.Axis;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Aluno;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Aluno
 */
@Named(value = "alunoManagedBean")
@ApplicationScoped
public class AlunoManagedBean {

    private DAOAlunosDerby dao;
    private Aluno aluno;
    private List<Aluno> listaAlunos;
    private List<Aluno> alunosFiltrados;
    /**
     * Creates a new instance of PassagensManagedBean
     */
    public AlunoManagedBean() {
        this.aluno = new Aluno();
        this.dao = new DAOAlunosDerby();
        this.listaAlunos = new ArrayList<>();
        
    }

    public List<Aluno> getAlunosFiltrados() {
        return alunosFiltrados;
    }

    public void setAlunosFiltrados(List<Aluno> alunosFiltrados) {
        this.alunosFiltrados = alunosFiltrados;
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    @PostConstruct
    public void init() {
        atualizar();
        //createBarModel();
        //createBubbleModels();
    }

    public void atualizar() {
        listaAlunos = dao.getAllAlunos();
        alunosFiltrados = getAlunosFiltrados();
        createBarModel();
        createBubbleModels();
    }

    public List<Aluno> getAlunos() {
        return listaAlunos;
    }

    public void cadastrar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            //context.addMessage(null, new FacesMessage("Nome",  "O nome é "+this.getPassagem().getNome() ) );

            dao.addAluno(this.getAluno());
            context.addMessage(null, new FacesMessage("Aluno", "Aluno cadastrado com sucesso"));

        } catch (Exception ex) {
            Logger.getLogger(AlunoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            context.addMessage(null, new FacesMessage("Aluno", "Problemas"));

        }

    }

    public void buscar() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Buscar", "Busca feita com sucesso"));

    }

    public List<Aluno> buscarByName() {
        return dao.buscarByName(this.getAluno());
    }

    public void onRowEdit(RowEditEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        //Aluno a = (Aluno) event.getObject();
        boolean resultado = false;

        try {
            resultado = dao.updateAluno((Aluno) event.getObject());
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização", "Aluno atualizado com sucesso!"));
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atualização", ex.getMessage()));
        }

    }

    public void onRowCancel(RowEditEvent event) {
        //FacesMessage msg = new FacesMessage("Edit Cancelled", ((Aluno) event.getObject()).getNome());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public BubbleChartModel getBubbleModel1() {
        return bubbleModel1;
    }

    private void createBarModel() {
        barModel = new BarChartModel();
        ChartSeries notas = new ChartSeries();
        notas.setLabel("Notas");
        try {
            notas.set("Nota 1", dao.mediaNota1());
            notas.set("Nota 2", dao.mediaNota2());
            notas.set("Nota 3", dao.mediaNota3());

        } catch (SQLException ex) {
            Logger.getLogger(AlunoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        barModel.addSeries(notas);

        barModel.setTitle("MÉDIA DE NOTAS DOS ALUNOS");
        barModel.setLegendPosition("ne");

        org.primefaces.model.chart.Axis xAxis = barModel.getAxis(AxisType.X);
        //xAxis.setLabel("Gender");

        org.primefaces.model.chart.Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Média");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    private void createBubbleModels() {
        bubbleModel1 = initBubbleModel();
        bubbleModel1.setTitle("Grafico Aluno Bolhas");
        bubbleModel1.getAxis(AxisType.X).setLabel("Primeira nota");
        bubbleModel1.setShadow(false);
        bubbleModel1.setBubbleGradients(true);
        bubbleModel1.setBubbleAlpha(0.5);
        org.primefaces.model.chart.Axis yAxis = bubbleModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10.0);
        yAxis.setLabel("Media");

    }

    private BubbleChartModel initBubbleModel() {
        BubbleChartModel model = new BubbleChartModel();
        
        List<Aluno> list = this.getAlunos();
        list.forEach((l) -> {
            model.add(new BubbleChartSeries(l.getNome(), (int) l.getNota1(),(int)l.getMedia(),(int)l.getMedia())); // nome, x = media do aluno, y =  , raio = media do aluno 
        });

        /*
        model.add(new BubbleChartSeries("Acura", 70, 183,55));
        model.add(new BubbleChartSeries("Alfa Romeo", 45, 92, 36));
        model.add(new BubbleChartSeries("AM General", 24, 104, 40));
        model.add(new BubbleChartSeries("Bugatti", 50, 123, 60));
        model.add(new BubbleChartSeries("BMW", 15, 89, 25));
        model.add(new BubbleChartSeries("Audi", 40, 180, 80));
        model.add(new BubbleChartSeries("Aston Martin", 70, 70, 48));
       */

        return model;
    }

    private BubbleChartModel bubbleModel1;
    private BarChartModel barModel;
}
