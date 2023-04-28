package med.voll.api.domain.consultas.validacoes.agendamento;

import med.voll.api.domain.consultas.DTOAgendamentoConsulta;

public interface ValidadorAgendametoConsulta {
    public void validar(DTOAgendamentoConsulta dados);
}
