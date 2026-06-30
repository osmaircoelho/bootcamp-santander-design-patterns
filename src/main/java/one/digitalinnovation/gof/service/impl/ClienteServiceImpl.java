package one.digitalinnovation.gof.service.impl;

import io.swagger.v3.oas.annotations.servers.Server;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Implementacao da <b>Strategy</b> {@link one.digitalinnovation.gof.service.ClienteService},
 *  a qual pode ser injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe he um
 *  {@link one.digitalinnovation.gof.service}, ela sera tratada como um <b>Singleton</b>
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    //TODO Singleton: Injetar os componentes do Spring com @Autowired.
    //TODO Strategy: Implementar os metodos definidos na interface.
    //TODO Facade: Abstrair integracoes com subsistemas, provendo uma interface simples.


    @Override
    public Iterable<Cliente> buscarTodos() {
        // FIXME buscar todos dos clientes.
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // FIXME buscar Clientes por ID.
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {
        // FIXME Verificar se o Endereco do Cliente ja existe (pelo CEP)
        // FIXME Caso nao exista, integrar com o via CEP e persistir o retorno.
        // FIXME Alterar Cliente, vinculando o Endereco (novo ou existente).
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // FIXME Buscar Cliente por ID, case exista:
        // FIXME Verificar se o Endereco do Cliente ja existe (pelo CEP)
        // FIXME Caso nao exista, integrar com o via CEP e persistir o retorno.
        // FIXME Alterar Cliente, vinculando o Endereco (novo ou existente).
    }

    @Override
    public void deletar(Long id) {
        //FIXME deletar cliente por ID.
    }
}
