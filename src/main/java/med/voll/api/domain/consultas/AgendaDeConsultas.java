package med.voll.api.domain.consultas;

import med.voll.api.domain.consultas.validacoes.agendamento.ValidadorAgendametoConsulta;
import med.voll.api.domain.consultas.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import med.voll.api.domain.consultas.validacoes.exeptions.ValidacaoException;
import med.voll.api.domain.medicos.Medico;
import med.voll.api.domain.medicos.MedicoRepository;
import med.voll.api.domain.pacientes.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendametoConsulta> validadores;

    @Autowired
    private  List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

    public DTODetalhamentoConsulta agendar(DTOAgendamentoConsulta dados) {
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do medico informado nao existe");
        }

        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado nao existe");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        if (medico == null) {
            throw new ValidacaoException("Nao existe medico disponive nessa data");
        }
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);

        consultaRepository.save(consulta);

        return new DTODetalhamentoConsulta(consulta);

    }

    public void cancelar(DTOCancelamentoConsulta dados) {
        if (!consultaRepository.existsById(dados.idConsulta())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        validadoresCancelamento.forEach(v -> v.validar(dados));

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }

    private Medico escolherMedico(DTOAgendamentoConsulta dados) {
        if(dados != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatoria quando o medico ao for escolhido");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }
}
