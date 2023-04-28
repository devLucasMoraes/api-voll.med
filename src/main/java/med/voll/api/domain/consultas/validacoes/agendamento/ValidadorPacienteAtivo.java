package med.voll.api.domain.consultas.validacoes.agendamento;

import med.voll.api.domain.consultas.DTOAgendamentoConsulta;
import med.voll.api.domain.consultas.validacoes.exeptions.ValidacaoException;
import med.voll.api.domain.pacientes.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendametoConsulta{
    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DTOAgendamentoConsulta dados) {
        var pacienteEstaAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
