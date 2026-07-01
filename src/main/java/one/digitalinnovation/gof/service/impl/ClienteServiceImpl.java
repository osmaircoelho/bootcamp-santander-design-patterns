package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ClienteRepository;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *  Implementacao da <b>Strategy</b> {@link one.digitalinnovation.gof.service.ClienteService},
 *  a qual pode ser injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe he um
 *  {@link one.digitalinnovation.gof.service}, ela sera tratada como um <b>Singleton</b>
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    //TODO Singleton: Injetar os componentes do Spring com @Autowired.
    // buscar cliente do respository
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    //TODO Strategy: Implementar os metodos definidos na interface.
    //TODO Facade: Abstrair integracoes com subsistemas, provendo uma interface simples.


    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        // FIXME Verificar se o Endereco do Cliente ja existe (pelo CEP)
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // FIXME Caso nao exista, integrar com o via CEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // FIXME Alterar Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
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
