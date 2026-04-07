package com.nika.GerenciamentoDeFornecedores.controller;

import com.nika.GerenciamentoDeFornecedores.model.FornecedorModel;
import com.nika.GerenciamentoDeFornecedores.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService service;

    //201
    @PostMapping
    public ResponseEntity<FornecedorModel> criar(@RequestBody FornecedorModel fornecedor){
        FornecedorModel save = service.criar(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorModel> atualizar(@PathVariable Long id, @RequestBody FornecedorModel fornecedorAtualizado){
        try{
            FornecedorModel fornecedor = service.atualizar(id, fornecedorAtualizado);
            return ResponseEntity.ok(fornecedor);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<FornecedorModel>> listar(){
        List<FornecedorModel> fornecedor = service.listar();
        return ResponseEntity.ok(fornecedor);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FornecedorModel> buscar(@PathVariable Long id){
        try{
            FornecedorModel fornecedor = service.buscar(id);
            return ResponseEntity.ok(fornecedor);
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        try{
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
