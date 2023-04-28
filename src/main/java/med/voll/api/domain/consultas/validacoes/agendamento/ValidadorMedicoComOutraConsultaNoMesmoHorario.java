package med.voll.api.domain.consultas.validacoes.agendamento;

import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DTOAgendamentoConsulta;
import med.voll.api.domain.consultas.validacoes.exeptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendametoConsulta{
    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DTOAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
