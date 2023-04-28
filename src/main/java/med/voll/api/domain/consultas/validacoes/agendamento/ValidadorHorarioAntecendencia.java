package med.voll.api.domain.consultas.validacoes.agendamento;

import med.voll.api.domain.consultas.DTOAgendamentoConsulta;
import med.voll.api.domain.consultas.validacoes.exeptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecendencia implements ValidadorAgendametoConsulta{

    public void validar(DTOAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecendencia minima de 30 minutos");
        }

    }
}
