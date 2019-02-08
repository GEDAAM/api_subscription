package br.edu.gedaam.service;

import br.edu.gedaam.model.Faculdade;
import br.edu.gedaam.model.Inscricao;
import br.edu.gedaam.model.Pessoa;
import br.edu.gedaam.model.Turma;
import br.edu.gedaam.repository.InscricaoRepository;
import br.edu.gedaam.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class InscricaoService {

    final private String CAMINHO_ARQUIVO = "/home/castro/Downloads/";
    final private String ARQUIVO_LEITURA = CAMINHO_ARQUIVO + "2018-2-Respostas_GEDAAM.csv";

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    InscricaoRepository inscricaoRepository;

    @Autowired
    CargaService cargaService;


    Map<String, Faculdade> faculdades = new HashMap<>();
    Map<String, Turma> turmas = new HashMap<>();

    public void importFile() {

        faculdades = cargaService.criaListaFaculdades();
        turmas = cargaService.criaListaTurmas();

        Date dataInicio = new Date(System.currentTimeMillis());
        System.out.println("Início do Processamento: " + dataInicio.toString());

        readFile();
        Date dataFim = new Date(System.currentTimeMillis());
        System.out.println("Fim do Processamento: " + dataFim.toString());
    }


    private void processLine(String line) {
        String[] lineArray = line.split(",");
        System.out.println(line);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(lineArray[1].trim());
        pessoa.setTelefone(lineArray[5].trim());
        pessoa.setFaculdade(faculdadeLookup(lineArray[2].trim()));
        pessoa.setMatricula(lineArray[3].trim());
        pessoa.setPeriodo(Integer.getInteger(lineArray[4].trim().substring(0, 0)));

        pessoaRepository.save(pessoa);

        String opcao1Processada = lineArray[6].trim().length() == 0 ?
                (lineArray[8].trim().length() == 0 ? lineArray[10].trim() : lineArray[8].trim())
                : lineArray[6].trim();
        String opcao2Processada = lineArray[7].trim().length() == 0 ?
                (lineArray[9].trim().length() == 0 ? lineArray[11].trim() : lineArray[8].trim())
                : lineArray[7].trim();

        Inscricao inscricao = new Inscricao();
        inscricao.setPessoa(pessoa);
        inscricao.setOpcao1(turmaLookUp(opcao1Processada));
        inscricao.setOpcao2(turmaLookUp(opcao2Processada));
        inscricao.setDataHoraInscricao(DateTimeService.formatDateTime(lineArray[0].trim()));

        inscricaoRepository.save(inscricao);

    }

    private Turma turmaLookUp(String descricaoTurma) {
        return turmas.get(descricaoTurma);
    }

    private Faculdade faculdadeLookup(String nomeFaculdade) {
        return faculdades.get(nomeFaculdade);
    }

    private void readFile() {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(ARQUIVO_LEITURA);
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);

            while (br.ready()) {
                String linha = br.readLine();
                processLine(linha);
            } // while

            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
