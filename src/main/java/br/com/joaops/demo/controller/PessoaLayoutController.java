/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.demo.controller;

import br.com.joaops.demo.dto.PessoaDto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.com.joaops.demo.service.PessoaService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * FXML Controller class
 *
 * @author João Paulo
 */
@Controller
public class PessoaLayoutController implements Initializable {
    
    @FXML
    private TextField textFieldNome;
    
    @FXML
    private DatePicker datePickerNascimento;
    
    @FXML
    private TableView<PessoaDto> tableViewPessoa;
    
    @FXML
    private TableColumn<PessoaDto, Long> tableColumnId;
    
    @FXML
    private TableColumn<PessoaDto, String> tableColumnNome;
    
    @FXML
    private TableColumn<PessoaDto, LocalDate> tableColumnNascimento;
    
    @FXML
    private Pagination pagination;
    
    @Autowired
    private PessoaService pessoaService;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateLayout();
        tableViewPessoa.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                textFieldNome.setText(newValue.getNome());
                datePickerNascimento.setValue(newValue.getNascimento());
            }
        });
    }
    
    public void updateLayout() {
        int size = 10;
        Pageable p = new PageRequest(0, size);
        Page<PessoaDto> pessoas = pessoaService.findAll(p);
        pagination.setPageCount(pessoas.getTotalPages());
        pagination.setPageFactory((Integer param) -> {
            Page<PessoaDto> pessoas1 = pessoaService.findAll(new PageRequest(param, size));
            loadTableView(pessoas1.getContent());
            return new Label("");
        });
    }
    
    public void loadTableView(List<PessoaDto> pessoas) {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnNascimento.setCellValueFactory(new PropertyValueFactory<>("nascimento"));
        tableColumnNascimento.setCellFactory((TableColumn<PessoaDto, LocalDate> column) -> {
            return new TableCell<PessoaDto, LocalDate>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    }
                }
            };
        });
        ObservableList<PessoaDto> observableList = FXCollections.observableArrayList(pessoas);
        tableViewPessoa.setItems(observableList);
    }
    
    @FXML
    public void create() {
        if (textFieldNome.getText().isEmpty() || datePickerNascimento.getValue() == null) {
            return;
        }
        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setNome(textFieldNome.getText());
        pessoaDto.setNascimento(datePickerNascimento.getValue());
        pessoaService.save(pessoaDto);
        clear();
    }
    
    @FXML
    public void update() {
        PessoaDto pessoaDto = tableViewPessoa.getSelectionModel().getSelectedItem();
        if (pessoaDto == null) return;
        if (textFieldNome.getText().isEmpty() || datePickerNascimento.getValue() == null) {
            return;
        }
        pessoaDto.setNome(textFieldNome.getText());
        pessoaDto.setNascimento(datePickerNascimento.getValue());
        pessoaService.save(pessoaDto);
        clear();
    }
    
    @FXML
    public void delete() {
        PessoaDto pessoaDto = tableViewPessoa.getSelectionModel().getSelectedItem();
        if (pessoaDto == null) return;
        pessoaService.delete(pessoaDto.getId());
        clear();
    }
    
    @FXML
    public void clear() {
        tableViewPessoa.getSelectionModel().clearSelection();
        textFieldNome.setText("");
        datePickerNascimento.setValue(null);
        updateLayout();
    }
    
}