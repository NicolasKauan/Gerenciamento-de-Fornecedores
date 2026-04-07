package com.nika.GerenciamentoDeFornecedores.services;

import com.nika.GerenciamentoDeFornecedores.model.FornecedorModel;
import com.nika.GerenciamentoDeFornecedores.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    //Criar
    public FornecedorModel criar(FornecedorModel fornecedor){
        return repository.save(fornecedor);
    }

    //listar
    public List<FornecedorModel> listar(){
        return repository.findAll();
    }

    //Buscar
    public FornecedorModel buscar(Long id){
        return repository.findById(id).orElse(null);
    }

    //atualizar
    public FornecedorModel atualizar(Long id, FornecedorModel fornecedorAtualizado){
        Optional<FornecedorModel> fornecedorExistente = repository.findById(id);

        if(fornecedorExistente.isPresent()){
            FornecedorModel fornecedor = fornecedorExistente.get();
            fornecedor.setCnpj(fornecedorAtualizado.getCnpj());
            fornecedor.setContato(fornecedorAtualizado.getContato());
            fornecedor.setStatus(fornecedorAtualizado.getStatus());
            fornecedor.setNomeFantasia(fornecedorAtualizado.getNomeFantasia());

            return repository.save(fornecedor);
        }else{
            throw new RuntimeException("Fornecedor não encontrado para o id: "+ id);
        }
    }

    //deletar
    public void deletar(Long id){
        repository.deleteById(id);
    }

}
