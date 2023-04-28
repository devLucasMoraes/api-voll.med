package med.voll.api.domain.consultas.validacoes.agendamento;

import med.voll.api.domain.consultas.DTOAgendamentoConsulta;
import med.voll.api.domain.consultas.validacoes.exeptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendametoConsulta{

    public void validar(DTOAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica");
        }

    }
}
